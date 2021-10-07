/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibryary;
import java.util.Calendar;
import java.util.GregorianCalendar;
import myClasses.Reader;
import myClasses.Book;
import myClasses.Author;
import myClasses.History;

public class App {
    public void run(){
        Reader reader1 = new Reader();
        reader1.setFirstName("peter");
        reader1.setLastName("petrov");
        reader1.setPhone("6545151231");
        Reader reader2 = new Reader();
        reader2.setFirstName("Slava");
        reader2.setLastName("Mamont");
        reader2.setPhone("2653269522");
        
        Book book1 = new Book();
        book1.setBookName("Voina i mir");
        book1.setPublishedYear(2021);
        
        Author author1 = new Author();
        author1.setFirstName("lev");
        author1.setLastName("Tolstoy");
        author1.setYear(1828);
                
        Author[] authors = new Author[1];
        authors[0]= author1;
        book1.setAuthor(authors);
        
        Book book2 = new Book();
        book2 .setBookName("otsi i deti");
        book2.setPublishedYear(1862);
        
        Author author2 = new Author();
        author2.setFirstName("ivan");
        author2.setLastName("Turgenev");
        author2.setYear(1818);
         
        Author[] authors2 = new Author[1];
        authors2[0]= author2;
        book2.setAuthor(authors2);
        
        History history1 = new History();
        history1.setReader(reader1);
        history1.setBook(book1);
        Calendar c = new GregorianCalendar();
        history1.setGivenDate(c.getTime());
        history1.setReturnedDate(c.getTime());
        
        
        
        History history2 = new History();
        history2.setReader(reader2);
        history2.setBook(book2);
        c = new GregorianCalendar();
        history2.setGivenDate(c.getTime());
        history2.setReturnedDate(c.getTime());
        System.out.println("history1 = " + history1.toString());
        System.out.println("history2 = " + history2.toString());
        
    }
    
}
