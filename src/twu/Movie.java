package twu;

public class Movie {
    private String name;
    private String author;
    private String ratings;

    public Movie(String name, String author, String ratings) {
        this.name = name;
        this.author = author;
        this.ratings = ratings;
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

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
    @Override
    public String toString() {
        return getName() + " " + getAuthor() + " " + getRatings();
    }
}