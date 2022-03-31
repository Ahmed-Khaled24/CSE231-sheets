package Sheet4;
import java.time.LocalDate;

public class Book {
    private int ID;
    private String title;
    private LocalDate releaseDate;
    private double price;

    public Book(String title, LocalDate releaseDate, double price) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void print(){
        System.out.println("ID: " + this.ID);
        System.out.println("Title: " + this.title);
        System.out.println("Release date: " + this.releaseDate);
        System.out.println("Price: $" + this.price);
    }
}
