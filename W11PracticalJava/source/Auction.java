import java.util.ArrayList;
/**
 * 
 * Auction
 * 
 */

public class Auction {

    private double currentBid;
    private boolean isOpen=false;
    private final int MAX_NUMBER_OF_BIDS = 5;
    private final int MAX_NUMBER_OF_ITEMS = 10;
    private ArrayList<Item> itemList;
    private ArrayList<Item> soldItems;
    private ArrayList<Item> unsoldItems;
    private Item item;

    Buyer buyer = new Buyer();

    public Auction() {
        itemList = new ArrayList<Item>(); // using an array list means that as items are
                                          // bought/sold the size of the item list adapts
        soldItems = new ArrayList<Item>(); //anything sold ends up here  
        unsoldItems = new ArrayList<Item>();                              
    }

    // items added to list if there are fewer than the max number of items

    public void addToItemList(Artwork item) {
        if (itemList.size() < MAX_NUMBER_OF_ITEMS) {
            itemList.add(item);
            item.updateStatus("for sale");
        }else{
            System.out.println("Maximum number of items already in auction.");
        }
    }

    public void addToItemList(Book item) {
        if (itemList.size() < MAX_NUMBER_OF_ITEMS) {
            itemList.add(item);
            item.updateStatus("for sale");
        }else{
            System.out.println("Maximum number of items already in auction.");
        }
    }

    public void addToItemList(Jewellery item) {
        if (itemList.size() < MAX_NUMBER_OF_ITEMS) {
            itemList.add(item);
            item.updateStatus("for sale");
        }else{
            System.out.println("Maximum number of items already in auction.");
        }
    }
    // checks that a bid is valid

    public boolean isBidValid(Buyer buyer, Item item){
        if(item.getNumberOfBids() <= MAX_NUMBER_OF_BIDS && 
           buyer.getBid() >= item.getCurrentPrice() &&
           getOpen()){
            return true;
        }return false;
    }

    //checks that the final bid is both greater than reserve and current bid 
    
    public boolean isBidSuccessful(Buyer buyer, Item item){
        Item currentItem = buyer.getItem();
        if(currentItem.getNumberOfBids() <= MAX_NUMBER_OF_BIDS && 
                buyer.getBid() >= currentItem.getReserveValue()
                && buyer.getBid() == currentItem.getCurrentPrice()
                && getOpen()){
                    return true;
        }return false;
    }

    public void receiveBid(Buyer buyer, Item item){

        if(isBidValid(buyer,item)){
                buyer.setItemToBuy(item); 
                currentBid = buyer.getBid();
                item.setCurrentPrice(currentBid);
                item.incrementNoOfBids();
                
        }
        if(isBidSuccessful(buyer,item) && item.getNumberOfBids() == MAX_NUMBER_OF_BIDS){

            // for the final successful bid. details of the buyer, charity, donor and item are updated.
            item.setBuyer(buyer);
            item.setFinalPrice(buyer.getBid());
            buyer.decreaseBalance(buyer.getBid());
            item.updateStatus("sold");
            item.getCharity().raiseBalance(buyer.getBid());
            if(!(item.getCharity().getDonors().contains(item.getDonor()))){
                item.getCharity().addDonor(item.getDonor());
            }
            item.getDonor().raiseBalance(buyer.getBid());
            soldItems.add(item);
            itemList.remove(item);
            buyer.resetBid();
        }
        //any items still unsold after 5 bids removed from auction.
        if(isBidValid(buyer,item) && item.getNumberOfBids() == MAX_NUMBER_OF_BIDS && buyer.getBid() < item.getReserveValue()){
            
            item.updateStatus("unsold");
            unsoldItems.add(item);
            itemList.remove(item);
            buyer.resetBid();
        }
        if(isBidSuccessful(buyer, item) && getOpen()){
            item.setBuyer(buyer);
            item.setFinalPrice(item.getCurrentPrice());
            buyer.resetBid();   
        }
    }

    public void stopBids(Item item){
        if(item.getBuyer() != null){
            Buyer currentBuyer = item.getBuyer();
            if(isBidSuccessful(currentBuyer, item)){
                currentBuyer.decreaseBalance(currentBuyer.getBid());
                item.updateStatus("sold");
                item.getCharity().raiseBalance(currentBuyer.getBid());
                item.getDonor().raiseBalance(currentBuyer.getBid());
            }
            if(!(item.getCharity().getDonors().contains(item.getDonor()))){
                item.getCharity().addDonor(item.getDonor());
            }
            if(!(soldItems.contains(item))){
                soldItems.add(item);
                itemList.remove(item);
            }
            currentBuyer.resetBid();
        }
    }

    public void openAuction(){
        this.isOpen = true;
    }

    public void closeAuction(){
        this.isOpen = false;
    }

    public boolean getOpen(){
        return isOpen;
    }

    public void printDetails() { // prints the current details of all items in the auction
        System.out.println("******Auction List******");
        System.out.println();
                for (Item item : itemList) {
            if(item instanceof Jewellery){
                this.item =(Jewellery)item;
                item.printDetails();
            }else if(item instanceof Book){
                this.item = (Book)item;
                item.printDetails();
            }else if(item instanceof Artwork){
                this.item = (Artwork)item;
                item.printDetails();
            }
            System.out.println();
        }
    }

    public void printBooksForSale(){
        System.out.println("******Books for Sale******");
        System.out.println();
        for(Item book : itemList){
            if(book instanceof Book){
                book.printDetails();
            }
        }
    }

    public void printSoldItems(){
        System.out.println("****** Sold Items ******");
        if(soldItems.isEmpty()){
           System.out.println("Nothing has been sold yet.");
           System.out.println();
        }
        else{ 
            for(Item itemSold : soldItems){
                System.out.println("Item: " + itemSold.getName());
                System.out.println("Sale Price: £" + itemSold.getFinalPrice());
                System.out.println();
            }   
        }
    }

    public void printSoldItem(Item toPrint){
        for(Item item : soldItems){
            if(item.getName().equals(toPrint.getName())){
                item.printDetails();
            }
        }
    }

    public void printUnsoldJewellery(){
        System.out.println("******Unsold Jewellery******");
        System.out.println();
        for(Item item : unsoldItems){
            if(item instanceof Jewellery){
                item.printDetails();
            }
        }
    }
}