/**
 * Author
 */

public class Author extends Person {

    private int booksWritten;
    private String writtenLanguage;

    public int getBooksWritten() {
        return booksWritten;
    }

    public String getLanguage() {
        return writtenLanguage;
    }

    // if the number of books written is 0, logically this person cannot be an
    // author so wouldn't exist in this class, therefore I have used 0 to indicate
    // an unknown number of books written this is translated in the printDetails method

    public Author() {
        super();
        this.booksWritten = 0;
        this.writtenLanguage = "language unknown";
    }

    public Author(String name, String address, int year, int month, int day) {
        super(name, address, year, month, day);
        this.booksWritten = 0;
        this.writtenLanguage = "language unknown";
    }

    public Author(String name, String address, int year, int month, int day, int booksWritten, String language) {
        super(name, address, year, month, day);
        this.booksWritten = booksWritten;
        this.writtenLanguage = language;
    }

    public Author(String name) {
        super(name);
        this.booksWritten = 0;
        this.writtenLanguage = "language unknown";
    }

    public Author(String name, int booksWritten, String language) {
        super(name);
        this.booksWritten = 0;
        this.writtenLanguage = language;
    }

    public void printDetails() {
        System.out.println("******Author Details******");
        super.printDetails();
        if (getBooksWritten() != 0) {
            System.out.println("Books written: " + getBooksWritten());
        } else {
            System.out.println("Books written: number unknown");
        }
        System.out.println("Written in: " + getLanguage());
        System.out.println();
    }
}