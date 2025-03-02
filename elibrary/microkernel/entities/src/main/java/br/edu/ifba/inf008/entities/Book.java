package br.edu.ifba.inf008.entities;

import java.io.Serializable;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;

public class Book implements Serializable{
    private String isbn;
    private String title;
    private String author;
    private String publishYear;
    private String genre;
    // private ImageView cover;

    public Book (String isbn, String title, String author, String publishYear, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.genre = genre;
    }

    // public Book (String isbn, String title, String author, String publishYear, String genre, String pathToCoverInResources) {
    //     this.isbn = isbn;
    //     this.title = title;
    //     this.author = author;
    //     this.publishYear = publishYear;
    //     this.genre = genre;
    //     this.cover = new ImageView(new Image(pathToCoverInResources));
    // }

    public String getIsbn () {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public String getGenre() {
        return this.genre;
    }

}
