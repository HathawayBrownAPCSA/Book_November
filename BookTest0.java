// Tests the expanded Book class, used with Chapter 8.

import java.util.Scanner;

public class BookTest
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner (System.in);
    System.out.print("Enter the title of the book: ");
    String title = keyboard.nextLine();
    
    System.out.print("Author\'s last name: ");
    String authorLast = keyboard.nextLine();
    
    System.out.print("Author\'s first name: ");
    String authorFirst = keyboard.nextLine();
    
    System.out.print("Number of pages: ");
    int pages = keyboard.nextInt();
    String dummy = keyboard.nextLine ();  // clear the input line
    
    Book book = new Book(title, authorLast, authorFirst, pages);
    
    System.out.println(book.toString());

    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());

    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());

    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());
    
    System.out.print("Search for: ");
    String word = keyboard.nextLine();
    if (book.findKeyword(word))
      System.out.println(word + " found in\n" + book.toString());
    else
      System.out.println(word + " not found in\n" + book.toString());
    
    keyboard.close();
  }
}
