/**
 * Expands Book class from Ch04 Question 7 for Ch08
 * Implements the class "Book" with a title, number of authors, arrays of first and last names, total pages, and a
 * current page (default to 1 upon creation)
 * Author: Alison Xin
 * Turned in on 2016 11 22
 * Modified on 2016 11 28
 */
import java.util.Arrays; 

public class Book
{
 private String title; 
 private String[] authorLastArray, authorFirstArray;
 private int numPages, currentPage, numAuthors;
 /**
  * Creates a book with a number of pages and a current page
  * @param int numPages total number of pages in the book
  * @param int currentPage current page number in book
  * @param int numAuthors number of authors
  * @param String[] authorLastArray surnames of authors
  * @param String[] authorFirstArray given names of authors
  */
 public Book(String t, int authorNum, String[] surname, String[] first, int num)
 {
   title = t;
   numAuthors = authorNum; 
   authorLastArray = surname; 
   authorFirstArray = first; 
   numPages = num; 
   currentPage = 1; 
 }
 
 /**
  * Retrieves total number of pages
  * @return int total number of pages
  */
 public int getNumPages()
 {
   return numPages;
 }
 
 /**
  * Retrieves current page
  * @return int current page
  */
 public int getCurrentPage()
 {
   return currentPage;
 }
 
 /**
 * Turns the page of the book
 * Current page increases by 1
 */ 
 public void nextPage()
 {
   if (currentPage < numPages) 
    currentPage++; 
 }
 
 /**
  * Returns a string of descriptors for the book
  * @return String description
  */
 public String toString()
 {
   String result = "Title:    " + title + "\n"; 
   String authorLast, authorFirst, authorLine; 
   for (int i = 0; i <= numAuthors - 1; i++)
   {
     authorLast = authorLastArray[i];
     authorFirst = authorFirstArray[i];
     authorLine = "Author " + (i + 1) + ": " + authorLast + ", " + authorFirst + "\n";
     result += authorLine;
   }
   result += "Pages:    " + numPages + "\n" 
     + "Current:  " + currentPage + "\n"; 
   return result; 
 }
 /**
  * Searches for a given keyword in a string
  * Borrowed and repurposed from Magpie4 of Java Methods
  * @return boolean keyword found or not
  */
 public boolean findKeyword(String kword)
 {
  String phrase = title + " " + Arrays.toString(authorLastArray) + Arrays.toString(authorFirstArray); 
  phrase = phrase.trim().toLowerCase();
  String goal = kword.toLowerCase();

  int psn = phrase.indexOf(goal);
  
  // Refinement--make sure the goal isn't part of a
  // word
  while (psn >= 0)
  {
   // Find the string of length 1 before and after
   // the word
   String before = " ", after = " ";
   if (psn > 0)
   {
    before = phrase.substring(psn - 1, psn);
   }
   if (psn + goal.length() < phrase.length())
   {
    after = phrase.substring(
      psn + goal.length(),
      psn + goal.length() + 1);
   }

   // If before and after aren't letters, we've
   // found the word
   if (((before.compareTo("a") < 0) || (before
     .compareTo("z") > 0)) // before is not a
           // letter
     && ((after.compareTo("a") < 0) || (after
       .compareTo("z") > 0)))
   {
    return true;
   }
   // The last position didn't work, so let's find
   // the next, if there is one.
   psn = phrase.indexOf(goal, psn + 1);
  }

  return false;
 }
}