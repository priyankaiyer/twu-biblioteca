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

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return getName() + " " + getDirector() + " " + getRatings();
    }
}