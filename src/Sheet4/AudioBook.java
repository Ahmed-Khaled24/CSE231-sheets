package Sheet4;

import java.time.LocalDate;

public class AudioBook extends Book{
    private static int counter = 1;
    private double timeLength;

    public AudioBook(String title, LocalDate releaseDate, double price, double timeLength) {
        super(title, releaseDate, price);
        this.timeLength = timeLength;
        this.setID(counter++);
    }

    public void print(){
        super.print();
        System.out.println("Length in minutes: " + this.timeLength);
    }

}
