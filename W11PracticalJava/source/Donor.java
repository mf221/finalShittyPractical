/**
 * 
 * Donor
 * 
 */

public class Donor extends Person {

    private double moneyRaised;

    public Donor(String name, String address, int year, int month, int day) {
        super(name, address, year, month, day);
        this.moneyRaised = 0;

    }

    public Donor(String name) {
        super(name);
        this.moneyRaised = 0;
    }

    public Donor() {
        super();
        this.moneyRaised = 0;
    }

    public double getmoneyRaised() {
        return moneyRaised;
    }

    public void raiseBalance(double finalPrice) {
        this.moneyRaised = moneyRaised + finalPrice;
    }

    public void printDetails() {
        System.out.println("******Donor Details******");
        super.printDetails();
        System.out.println("Money Raised: £" + getmoneyRaised());
        System.out.println();
    }
}