/**
 * Tests the expanded Book class in Chapter 8
 * Creates with a title, number of authors, arrays of first and last names, total pages, and a current page
 * Turns the pages three times, then prints the book's info
 * Keywords can be searched through the book's information (not case-sensitive, but spelling must be exact)
 * Author: Alison Xin
 * Teacher: Michael Buescher (AP Computer Science)
 * Turned in on 2016 11 22
 * Modified 2016 11 28
 */

import java.util.Scanner;
import java.util.Arrays; 

public class BookTest
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner (System.in);
    System.out.print("Enter the title of the book: ");
    String title = keyboard.nextLine();
    
    System.out.print("Number of authors: "); 
    int numAuthors = keyboard.nextInt(); 
    String dummy = keyboard.nextLine(); // clears line for next input 
    String[] authorFirstArray; // arrays are good for handling multiple authors
    String[] authorLastArray; 
    if (numAuthors > 0)
    {
      authorFirstArray = new String[numAuthors]; 
      authorLastArray = new String[numAuthors];
      // A looping prompt for all the authors' names
      for (int i = 0; i <= numAuthors - 1; i++)
      {
        System.out.print("Author " + (i + 1) + "\'s last name: ");
        String authorLast = keyboard.nextLine();
        authorLastArray[i] = authorLast;
        
        System.out.print("Author " + (i + 1) + "\'s first name: ");
        String authorFirst = keyboard.nextLine();
        authorFirstArray[i] = authorFirst; 
      }
    } else {
      authorFirstArray = new String[1]; 
      authorLastArray = new String[1];
      // creates 2 blank arrays of length 1
      // this results in book.toString() not printing out an author line
    }

    System.out.print("Number of pages: ");
    int pages = keyboard.nextInt();
    dummy = keyboard.nextLine ();  // clear the line;
    
    Book book = new Book(title, numAuthors, authorLastArray, authorFirstArray, pages);
    
    System.out.println(book.toString()); // prints a description of the book
    
    // turns the pages three times, returning the current page after each one
    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());

    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());

    book.nextPage();
    System.out.println("Now on page " + book.getCurrentPage());
    
    // search for keyword until input of STOP
    String word; 
    System.out.print("Search for (STOP to end search): ");
    word = keyboard.nextLine();
    
    while (! word.equals("STOP")) 
    {
      if (book.findKeyword(word))
        System.out.println(word + " found in\n" + book.toString());
      else
        System.out.println(word + " not found in\n" + book.toString());
      
      System.out.print("Search for (STOP to end search): ");
      word = keyboard.nextLine();
    } 
    
    keyboard.close();
  }
}