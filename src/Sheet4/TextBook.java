package Sheet4;

import java.time.LocalDate;

public class TextBook extends Book{
    public static int counter = 1;
    private int NumPages;

    public TextBook(String title, LocalDate releaseDate, double price, int numPages) {
        super(title, releaseDate, price);
        NumPages = numPages;
        this.setID(counter);;
    }

    public void print(){
        super.print();
        System.out.println("Number of pages: " + NumPages);
    }
}
