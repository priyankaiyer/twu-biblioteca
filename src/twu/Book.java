package twu;

public class Book {

    private String number;
    private String name;
    private String author;
    private boolean reserved = false;

    public Book(String number, String name, String author, boolean reserved) {
        this.number = number;
        this.name = name;
        this.author = author;
        this.reserved = reserved;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        String reserved = "";
        if (isReserved())
            reserved = "reserved";
        else
            reserved = "available";
        return getNumber() + " " + getName() + " " + getAuthor() + " " + reserved;
    }
}
