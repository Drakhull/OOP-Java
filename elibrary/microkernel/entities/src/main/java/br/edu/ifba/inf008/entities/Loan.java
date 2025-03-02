package br.edu.ifba.inf008.entities;

import java.io.Serializable;

import java.time.LocalDate;

public class Loan implements Serializable {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    public Loan(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(14); // 14 days for due date
        this.returned = false;

    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void confirmReturn() {
        this.returned = true;
    }

    public boolean isReturned() {
        return returned;
    }

    public boolean isUserAndBookEqual(User user, Book book) {
        return (user.equals(this.user) && book.equals(this.book));
    }
}
