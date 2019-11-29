import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 * Test
 * 
 */

public class Test {

    public static void main(String[] args) {

        Buyer Matt = new Buyer("Matt", "Dover 6 DRA", 1997, 9, 7,1000);
        Buyer Isaac = new Buyer("Isaac","Dover 6 DRA",2000,11,16,1000);
        Buyer Jonno = new Buyer("Jonno");
        Author Mayumi = new Author("Mayumi");
        Artist VanGough = new Artist("Van Gough");
        Donor Jon = new Donor("Jon");
        Donor Findlay = new Donor("Findlay");
        Charity Oxfam = new Charity("Oxfam", "Helping homeless people.");
        Charity Cafod = new Charity("CAFOD", "Feeding the hungry");

        //Matt.printDetails();

        Artwork monaLisa = new Artwork("Mona Lisa", Oxfam);

        System.out.println();
        monaLisa.setArtist(VanGough);

        Jewellery necklace = new Jewellery("necklace", 95, 110,Oxfam);
        necklace.setDonor(Findlay); // all items have a donor so method defined in Item class
        
        Book bible = new Book("the bible",200,250, Oxfam);
        Book lightningThief = new Book("Percy Jackson",100,110,Cafod);
        Book halfbloodPrince = new Book("Harry Potter", 50, 75, Cafod);

        bible.setAuthor(Mayumi); // only a book can have an author so this method is in book class
        bible.setDonor(Jon);

        Auction charityAuction = new Auction();

        charityAuction.addToItemList(monaLisa);
        charityAuction.addToItemList(bible);
        charityAuction.addToItemList(halfbloodPrince);
        charityAuction.addToItemList(lightningThief);
        charityAuction.addToItemList(necklace);

        //charityAuction.printBooksForSale();
        //charityAuction.printSoldItems(); 
        charityAuction.openAuction();
        Matt.placeBid(201., bible);
        charityAuction.receiveBid(Matt, bible);
        Jonno.placeBid(211., bible);
        charityAuction.receiveBid(Jonno, bible);
        Matt.placeBid(212., bible);
        charityAuction.receiveBid(Matt, bible);
        Isaac.placeBid(214., bible);
        charityAuction.receiveBid(Isaac, bible);
        Matt.placeBid(155., bible);
        charityAuction.receiveBid(Matt, bible);
        Isaac.placeBid(156., bible);
        charityAuction.receiveBid(Isaac, bible);
        Matt.placeBid(157, bible);
        charityAuction.receiveBid(Matt, bible);
        //Oxfam.printDetails();
        //Isaac.printDetails();
        
        Isaac.placeBid(256, bible);
        charityAuction.receiveBid(Isaac, bible);
        charityAuction.stopBids(bible);
        charityAuction.printSoldItems();
        //charityAuction.printSoldItem(bible);
        
        Isaac.printDetails();
        Matt.printDetails();
        Oxfam.printDetails();
        //charityAuction.printDetails();
        // //charityAuction.printBooksForSale();
        // Matt.placeBid(100, necklace);
        // charityAuction.receiveBid(Matt,necklace);
        // Isaac.placeBid(101,necklace);
        // charityAuction.receiveBid(Isaac, necklace);
        // //charityAuction.stopBids(necklace);
        
        // //necklace.printDetails();
        // Matt.placeBid(103, necklace);
        // charityAuction.receiveBid(Matt,necklace);
        
        // Isaac.placeBid(104,necklace);
        // charityAuction.receiveBid(Isaac, necklace);
        // Isaac.placeBid(115,necklace);
        // charityAuction.receiveBid(Isaac, necklace);
        // // //charityAuction.printSoldItems();
        // // Oxfam.printDetails();
        // // Findlay.printDetails();
        // // Jon.printDetails();
        // //bible.printDetails();
        // charityAuction.stopBids(necklace);
        // Matt.placeBid(116, necklace);
        // charityAuction.receiveBid(Matt, necklace);
    }
}