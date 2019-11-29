import java.util.GregorianCalendar;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

/**
 * 
 * Person
 * 
 */

public abstract class Person {
    protected String name;
    protected String address;
    protected int age;
    protected GregorianCalendar birthday;

    public Person(String name, String address, int year, int month, int day) {
        this.name = name;
        this.address = address;
        setBirthday(year, month, day);
        this.age = getAge();
    }

    // calls previous constructor and sets default address and birthday

    public Person(String name) {
        this(name, "unknown ", 0, 0, 0);
    }

    public Person() {
        this("unknown ");
    }

    // birthday code based on code from W07Practical

    public void setBirthday(int year, int month, int day) {
        GregorianCalendar birthday = new GregorianCalendar(year, month - 1, day);
        this.birthday = birthday;
    }

    public int getAge() {
        GregorianCalendar today = new GregorianCalendar();
        if (today.get(today.MONTH) > birthday.get(MONTH) || today.get(today.MONTH) == birthday.get(MONTH)
            && today.get(today.DAY_OF_MONTH) >= birthday.get(DAY_OF_MONTH)) {
            age = today.get(today.YEAR) - birthday.get(YEAR);
            return age;
        } else {
            age = today.get(today.YEAR) - birthday.get(YEAR) - 1;
            return age;
        }
    }

    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        if (birthday.get(YEAR) > 1900) { // so age of anyone with birthday 0/0/0
                                         // (defaults for unknown) won't be printed
            System.out.println("Age: " + getAge());
            System.out.println("Birthday: " + birthday.get(DAY_OF_MONTH) + "/"
                    + (birthday.get(MONTH) + 1) + "/"
                    + birthday.get(YEAR));
        }

        else {
            System.out.println("Age: unknown");
            System.out.println("Birthday: unknown");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}