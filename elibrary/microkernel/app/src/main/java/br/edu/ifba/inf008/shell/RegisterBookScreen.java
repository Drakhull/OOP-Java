package br.edu.ifba.inf008.shell;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import br.edu.ifba.inf008.entities.Library;
import br.edu.ifba.inf008.entities.Book;

public class RegisterBookScreen {
    public static Scene createRegisterBookScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10); // Espaçamento horizontal
        grid.setVgap(10); // Espaçamento vertical
        grid.setPadding(new javafx.geometry.Insets(20)); // Margens

        TextField isbnField = new TextField();
        TextField titleField = new TextField();
        TextField authorField = new TextField();
        TextField publishYearField = new TextField();
        TextField genreField = new TextField();

        grid.add(new Label("ISBN:"), 0, 0);
        grid.add(isbnField, 1, 0);
        grid.add(new Label("Title:"), 0, 1);
        grid.add(titleField, 1, 1);
        grid.add(new Label("Author:"), 0, 2);
        grid.add(authorField, 1, 2);
        grid.add(new Label("Publish Year:"), 0, 3);
        grid.add(publishYearField, 1, 3);
        grid.add(new Label("Genre:"), 0, 4);
        grid.add(genreField, 1, 4);

        Button registerButton = new Button("Register");
        grid.add(registerButton, 1, 5);

        registerButton.setOnAction(event -> {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String publishYear = publishYearField.getText();
            String genre = genreField.getText();

            Book newBook = new Book(isbn, title, author, publishYear, genre);

            Library.getInstance().addBook(newBook);

            primaryStage.close();
        });

        Scene scene = new Scene(grid, 400, 300);
        return scene;
    }
}
