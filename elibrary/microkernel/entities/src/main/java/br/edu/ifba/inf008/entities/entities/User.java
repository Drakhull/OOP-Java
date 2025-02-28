package br.edu.ifba.inf008;

import java.io.Serializable;

import java.util.ArrayList;
import java.time.LocalDate;

public class User implements Serializable {
    private static int idCounter = 0;

    private int id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User (String name) {
        this.id = idCounter++;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowBooks.add(book);
    }

    public int borrowedBooksQuantity() {
        return borrowedBooks.size();
    }

    public Book returnBook(String isbn) {
        for (Book book: borrowedBooks) {
            if(book.getIsbn.equals(isbn)) {
                Book foundBook = book;
                borrowBooks.remove(book);

                return foundBook;
            }
        }

        return null;
    }

    // public void returnBook(Book book) {
    //     borrowedBooks.removeIf(loan -> loan.getBook().equals(book));
    // }
}
