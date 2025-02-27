package br.edu.ifba.inf008;

import java.time.LocalDate;

public class Loan {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;

    public Loan(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(14); // 14 days for due date
    }
}
