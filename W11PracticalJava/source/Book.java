/**
 * 
 * Book
 * 
 */

public class Book extends Item {

    private int edition;
    private Author author;

    public Book() {
        super();
        this.edition = 0;
        this.author = null;
    }
    public Book(String name, Charity charity) {
        super(name, charity);
        this.edition = 0;
        this.author = null;
    }
    public Book(String name, Charity charity, int edition, Author author) {
        super(name, charity);
        this.edition = edition;
        this.author = author;
    }

    public Book(String name, double startPrice, double reserveValue,
                Charity charity, int edition, Author author) {
        super(name, startPrice, reserveValue, charity);
        this.edition = edition;
        this.author = author;
    }

    public Book(String name, double startPrice, double reserveValue,
                Charity charity) {
        super(name, startPrice, reserveValue, charity);
        this.edition = 0;
        this.author = null;
    }

    public int getEdition() {
        return edition;
    }

    public void setAuthor(Person person) {
        if (person instanceof Author) {
            this.author = (Author) person;
        }
    }

    public Author getAuthor() {
        return author;
    }

    public void printDetails() {
        System.out.println("******Book Details******");
        super.printDetails();
        if (edition != 0) {
            System.out.println("Edition: " + getEdition());
        } else {
            System.out.println("Edition: unknown.");
        }
        if (getAuthor() != null) {
            System.out.println("Author:" + getAuthor().getName());
        } else {
            System.out.println("Author: unknown");
        }System.out.println();
    }
}