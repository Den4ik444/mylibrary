/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myClasses;

import java.util.Arrays;

/**
 *
 * @author pupil
 */
public class Book {
    private String BookName;
    private int publishedYear;
    private Author[] author;

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author[] getAuthor() {
        return author;
    }

    public void setAuthor(Author[] author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "BookName=" + BookName + ", publishedYear=" + publishedYear + ", author=" + Arrays.toString(author)+ '}';
    }
    
}
