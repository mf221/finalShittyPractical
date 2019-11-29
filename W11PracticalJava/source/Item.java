/**
 * 
 * Item
 * 
 */

public abstract class Item {

    protected  int code;
    protected static int nextCode;
    protected  int itemCode;
    protected int numberOfBids;
    protected double startPrice;
    protected double currentPrice;
    protected double finalPrice;
    protected double reserveValue;
    protected String status;
    protected String name;
    protected Donor donor;
    protected Buyer buyer;
    protected Person person;
    protected Charity charity;
    protected final int MAX_BIDS;

    private static int genItemCode() {
        nextCode++;
        return nextCode;
    }

    public int getItemCode(){
        return itemCode;
    }
    
    public Item() {
        this.itemCode = genItemCode();
        this.startPrice = 0;
        this.currentPrice = startPrice;
        this.numberOfBids =0;
        this.finalPrice = 0;
        this.reserveValue = 0;
        this.status = "unsold";
        this.name = "unknown";
        this.donor = null;
        this.buyer = null;
        this.charity = null;
        this.MAX_BIDS = 5; 
    }

    public Item(String name, double startPrice, double reserveValue,
                Charity charity) {
        this();
        this.name = name;
        this.startPrice = startPrice;
        this.currentPrice = startPrice;
        this.reserveValue = reserveValue;
        this.charity = charity;
    }

    public Item(String name, Charity charity) {
        this();
        this.name = name;
        this.charity = charity;
    }

    public Item(String name, double startPrice, double reserveValue) {
        this();
        this.name = name;
        this.startPrice = startPrice;
        this.currentPrice = startPrice;
        this.reserveValue = reserveValue;
    }

    public void printDetails() {
        System.out.println("Item Code: " + getItemCode());
        System.out.println("Item: " + getName());
        if (getCharity() != null) {
            System.out.println("Benefitting Charity: " + getCharity().getName());
        } else {
            System.out.println("Benefitting Charity: hasn't been assigned.");
        }
        System.out.println("Start Price: £" + getStartPrice());
        if(getCurrentPrice() != getFinalPrice()){
            System.out.println("Current Price: " + getCurrentPrice());
        }
        System.out.println("Number of Bids: " + getNumberOfBids());
        if(getFinalPrice() != 0){
            System.out.println("Final Price: £" + getFinalPrice());
        }
        System.out.println("Status: " + getStatus());
        if (getDonor() != null) {
            System.out.println("Donor: " + getDonor().getName());
        } else {
            System.out.println("Donor: hasn't been assigned.");
        }
        if (getBuyer() != null) {
            System.out.println("Buyer: " + getBuyer().getName());
        } else {
            System.out.println("Buyer: currently, the item " + getName() + " hasn't been bought.");
        }
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getCurrentPrice(){
        return currentPrice;
    }

    public int getNumberOfBids(){
        return numberOfBids;
    }

    public int getMaxBids(){
        return MAX_BIDS;
    }

    public void setFinalPrice(double finalPrice){
        this.finalPrice = finalPrice;
    }
    
    public void setCurrentPrice(double price){
        this.currentPrice = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public double getReserveValue() {
        return reserveValue;
    }

    public void setReserveValue(double reserveValue) {
        this.reserveValue = reserveValue;
    }

    public String getStatus() {
        return status;
    }

    public String updateStatus(String status) {
        this.status = status;
        return status;
    }

    public String getName() {
        return name;
    }

    public Donor getDonor() {
        return donor;
    }

    public Charity getCharity() {
        return charity;
    }
    public void incrementNoOfBids(){
        numberOfBids++;        
    }

    // checks that the person is a donor and casts this person as the donor

    public void setDonor(Person person) {
        if (person instanceof Donor) {
            this.donor = (Donor) person;
        }
    }

    public void setBuyer(Person person) {
        if (person instanceof Buyer) {
            this.buyer = (Buyer) person;
        }
    }

    public Buyer getBuyer() {
        return buyer;
    }

}