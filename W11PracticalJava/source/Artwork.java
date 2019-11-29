/**
 * 
 * Artwork
 * 
 */

public class Artwork extends Item {
    private String type;
    private Artist artist;
    private int yearMade; // will be translated from 0 to unknown in printDetails()

    public Artwork() {
        super();
        this.type = "unknown";
        this.artist = null;
        this.yearMade = 0;
    }

    public Artwork(String name, Charity charity) {
        super(name, charity);
        this.type = "unknown";
        this.artist = null;
        this.yearMade = 0;

    }

    public Artwork(String name, double startPrice, double reserveValue,
                   Charity charity, String type, Artist artist, int yearMade) {
        super(name, startPrice, reserveValue, charity);
        this.type = type;
        this.artist = artist;
        this.yearMade = yearMade;
    }

    public Artwork(String name, Charity charity, String type, Artist artist, int yearMade) {
        super(name, charity);
        this.type = type;
        this.artist = artist;
        this.yearMade = yearMade;
    }

    public void printDetails() {
        System.out.println("******Artwork******");
        super.printDetails();
        System.out.println("Type: " + getType());
        if (artist != null) {
            System.out.println("Artist: " + getArtist().getName());
        } else {
            System.out.println("Artist: unknown");
        }
        if (getYearMade() != 0) {
            System.out.println("Year Created: " + getYearMade());
        } else {
            System.out.println("Year Created: unknown");
        }System.out.println();
    }

    public String getType() {
        return type;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setArtist(Person person) {
        if (person instanceof Artist) {
            this.artist = (Artist) person;

        }
    }
}