package twu;

public class Movie {
    private String name;
    private String director;
    private String ratings;

    public Movie(String name, String director, String ratings) {
        this.name = name;
        this.director = director;
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return getName() + " " + getDirector() + " " + getRatings();
    }
}