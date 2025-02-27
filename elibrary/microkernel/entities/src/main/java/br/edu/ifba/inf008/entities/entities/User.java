package br.edu.ifba.inf008;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class User implements Serializable {
    private static int idCounter = 0;

    private int id;
    private String name;
    private List<Loan> borrowedBooks;


    public User(){
    }

    public User (String name) {
        this.id = idCounter++;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int borrowedBooksQuantity() {
        return borrowedBooks.size();
    }

    // public void returnBook(Book book) {
    //     borrowedBooks.removeIf(loan -> loan.getBook().equals(book));
    // }
}
