package br.edu.ifba.inf008.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class Library implements Serializable {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Book> lendedBooks = new HashMap<>();
    private ArrayList<Loan> loans = new ArrayList();
    private static Library instance;

    private static final int borrowLimit = 5;

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public HashMap<String, Book> getBooks() {
        return this.books;
    }

    public void registerNewBook(String isbn, String title, String author, String publishYear, String genre) {
        Book book = new Book(isbn, title, author, publishYear, genre);
        addBook(book);
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    private void lend(Book book, User user) {
        if(user.borrowedBooksQuantity() < borrowLimit &&
           books.containsKey(book.getIsbn())) {

            user.borrowBook(book);

            lendedBooks.put(book.getIsbn(), book);
            books.remove(book.getIsbn());
        }
    }

    public void lendBook(Book book, User user) {
        lend(book, user);

        loans.add(new Loan(user, book, LocalDate.now()));
    }

    public void lendBook(Book book, User user, LocalDate date) {
        lend(book, user);

        loans.add(new Loan(user, book, date));
    }

    public void retrieveBook(String isbn, User user) {
        if(user.borrowedBooksQuantity() < borrowLimit &&
           lendedBooks.containsKey(isbn)) {

            Book book = user.returnBook(isbn);

            lendedBooks.remove(isbn);
            books.put(isbn, book);

            for(Loan loan : loans) {
                if(!loan.isReturned() &&
                   loan.isUserAndBookEqual(user, book)) {

                   loan.confirmReturn();
                }
            }
        }
    }
}
