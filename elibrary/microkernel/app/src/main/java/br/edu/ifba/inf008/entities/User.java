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

    public void borrowBook(Book book, LocalDate loanDate) {
        if (borrowedBooks.size() < 5) {
            // Loan loan = new Loan(this, book, loanDate);
            // borrowedBooks.add(loan);
        } else {
            throw new IllegalStateException("This user has reached the borrowed books limit.");
        }
    }

    // public void returnBook(Book book) {
    //     borrowedBooks.removeIf(loan -> loan.getBook().equals(book));
    // }
}
