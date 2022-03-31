package Sheet4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int numberOfBooks = 0;
        numberOfBooks = scanner.nextInt();
        scanner.nextLine();

        List<Book> books = new ArrayList<>();

        for(int i = 0 ; i< numberOfBooks; i++){
            System.out.print("Is it Text book of Audio book? : " );
            String bookType = scanner.nextLine().toLowerCase(Locale.ROOT);


            System.out.print("Enter the title of the " + i+1 + " book: ");
            String title = scanner.nextLine();

            System.out.println("Enter the release date of the " + i+1 + " book: ");
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Month: ");
            int month = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Day: ");
            int day = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the price of the " + i+1 + " book: ");
            double price = scanner.nextDouble();
            scanner.nextLine();


            if(bookType.equals("audio")){
                System.out.print("Enter the Length in minutes of the " + i+1 + " book: ");
                double length = scanner.nextDouble();
                scanner.nextLine();

                Book book = new AudioBook(title, LocalDate.of(year, month, day), price, length);
                books.add(book);
            }

            if(bookType.equals("text")){
                System.out.print("Enter the number of pages of the " + i+1 + " book: ");
                int numberOfPages = scanner.nextInt();
                scanner.nextLine();
                Book book = new TextBook(title, LocalDate.of(year, month, day), price, numberOfPages);
                books.add(book);
            }
        }

        for (Book b: books)
            b.print();

    }
}
