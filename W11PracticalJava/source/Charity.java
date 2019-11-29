import java.util.ArrayList;
/**
 * 
 * Charity
 * 
 */

public class Charity {

    private String name;
    private String mission;
    private double balance;
    private ArrayList<Donor> donors;
    

    public Charity(String name, String mission) {
        this.name = name;
        this.mission = mission;
        this.balance = 0; // as balance only reflects what has been raised, so initially 0.
        donors = new ArrayList<Donor>();
    }

    public void addDonor(Donor donor){
        donors.add(donor);
    }

    public ArrayList<Donor> getDonors(){
        return donors;
    }

    public String getName() {
        return name;
    }

    public void raiseBalance(double moneyIn){
        this.balance = balance + moneyIn;
    }

    public String getMission() {
        return mission;
    }

    public double getBalance() {
        return balance;
    }

    public Donor getMaxDonor(){
        Donor biggestDonor = new Donor();
        donors.add(biggestDonor);
        for(Donor donor : donors){
            if(donor.getmoneyRaised() > biggestDonor.getmoneyRaised()){
                biggestDonor = donor;
                
            }
        }return biggestDonor;
    }

    public void printDetails() {
        System.out.println("******Charity Details******");
        System.out.println("Charity Name: " + getName());
        System.out.println("Charity Mission: " + getMission());
        System.out.println("Charity Balance: £" + getBalance());
        System.out.println("Biggest Donor: " + getMaxDonor().getName());
        System.out.println();
    }
}