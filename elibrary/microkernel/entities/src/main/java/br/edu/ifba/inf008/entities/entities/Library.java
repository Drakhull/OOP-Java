package br.edu.ifba.inf008;

import java.io.Serializable;

import java.util.HashMap;

public class Library implements Serializable {
    private static HashMap<String, Book> books;
    private static ArrayList<Loan> loans;

    private int borrowLimit = 5;

    private Library(){
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    private void borrowBook(Book book, User user) {
        if(user.borrowedBooksQuantity < borrowLimit &&
           books.containsKey(book.getIsbn())) {
            user.borrowBook(book);
            books.remove(book.getIsbn, book);
        }

    }
}
