/**
 * Artist
 */

public class Artist extends Person {

    private String movement;

    public Artist(String name, String address, int year, int month, int day, String movement) {
        super(name, address, year, month, day);
        this.movement = movement;
    }

    public Artist(String name, String address, int year, int month, int day) {
        super(name, address, year, month, day);
        this.movement = "unknown";
    }

    public Artist(String name, String movement) {
        super(name);
        this.movement = movement;
    }

    public Artist(String name) {
        super(name);
        this.movement = "unknown";
    }

    public Artist() {
        super();
        this.movement = "unknown";
    }

    public String getMovement() {
        return movement;
    }

    public void printDetails() {
        System.out.println("******Artist Details*******");
        super.printDetails();
        System.out.println("Artistic Movement: " + getMovement());
        System.out.println();
    }
}