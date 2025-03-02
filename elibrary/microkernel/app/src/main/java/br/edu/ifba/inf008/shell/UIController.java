package br.edu.ifba.inf008.shell;

import br.edu.ifba.inf008.interfaces.IUIController;
import br.edu.ifba.inf008.interfaces.ICore;
import br.edu.ifba.inf008.shell.PluginController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.geometry.Side;
import javafx.scene.Node;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;

import br.edu.ifba.inf008.entities.Library;

import javafx.scene.control.Label;



import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
import javafx.event.EventHandler;

public class UIController extends Application implements IUIController
{
    private ICore core;
    private MenuBar menuBar;
    private TabPane tabPane;
    private static UIController uiController;

    public UIController() {
    }

    @Override
    public void init() {
        uiController = this;
    }

    public static UIController getInstance() {
        return uiController;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("E-Library");

        menuBar = new MenuBar();

        VBox vBox = new VBox(menuBar);

        tabPane = new TabPane();
        tabPane.setSide(Side.BOTTOM);

        Label title = new Label("E-Library");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        StackPane titleContainer = new StackPane(title);
        titleContainer.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(createSearchBar(), titleContainer, tabPane, createBookList(), createGenreSection());

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        Core.getInstance().getPluginController().init();
    }

    public MenuItem createMenuItem(String menuText, String menuItemText) {
        // Criar o menu caso ele nao exista
        Menu newMenu = null;
        for (Menu menu : menuBar.getMenus()) {
            if (menu.getText() == menuText) {
                newMenu = menu;
                break;
            }
        }
        if (newMenu == null) {
            newMenu = new Menu(menuText);
            menuBar.getMenus().add(newMenu);
        }

        // Criar o menu item neste menu
        MenuItem menuItem = new MenuItem(menuItemText);
        newMenu.getItems().add(menuItem);

        return menuItem;
    }

    public boolean createTab(String tabText, Node contents) {
        Tab tab = new Tab();
        tab.setText(tabText);
        tab.setContent(contents);
        tabPane.getTabs().add(tab);

        return true;
    }

    public HBox createSearchBar() {
        HBox searchBar = new HBox();
        searchBar.setSpacing(10);
        searchBar.setAlignment(Pos.CENTER);

        // Search icon
        ImageView searchIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/search.png")));
        searchIcon.setFitHeight(20);
        searchIcon.setFitWidth(20);

        // Search field
        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        searchField.setPrefWidth(400);

        // Profile icon
        Circle profileIcon = new Circle(15, Color.LIGHTGRAY);
        profileIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Open profile screen from the user
                System.out.println("Open users profile");
            }
        });
            searchBar.getChildren().addAll(searchIcon, searchField, profileIcon);
        return searchBar;
    }

    private ScrollPane createBookList() {
        HBox bookList = new HBox();
        bookList.setSpacing(10);
        bookList.setAlignment(Pos.CENTER);

        Library.getInstance();

        // Replace
        for (int i = 0; i < 10; i++) {
            VBox book = createBook("Book " + (i + 1), "/images/default_book_cover.png");
            bookList.getChildren().add(book);
        }

        ScrollPane scrollPane = new ScrollPane(bookList);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    private VBox createBook(String title, String imagePath) {
        VBox book = new VBox();
        book.setSpacing(5);
        book.setAlignment(Pos.CENTER);

        // Books image
        ImageView bookImage = new ImageView(new Image(getClass().getResourceAsStream("/images/default_book_cover.jpg")));
        bookImage.setFitHeight(150);
        bookImage.setFitWidth(100);

        // Books title
        Label bookTitle = new Label(title);
        bookTitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));

        book.getChildren().addAll(bookImage, bookTitle);

        // Click book action
        book.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Open book details screen
                System.out.println("Open book details: " + title);
            }
        });

        return book;
    }

    private ScrollPane createGenreSection() {
        HBox genreList = new HBox();
        genreList.setSpacing(10);
        genreList.setAlignment(Pos.CENTER);

        // Exemplo de gêneros (substitua por dados reais)
        String[] genres = {"HORROR", "FICTION", "ACTION", "ROMANCE", "FANTASY"};
        for (String genre : genres) {
            Button genreButton = new Button(genre);
            genreButton.setStyle("-fx-background-radius: 60; -fx-border-radius: 60; -fx-border-color: black;");
            genreButton.setOnAction(event -> {
                // Filtrar livros por gênero
                System.out.println("Filtrar por gênero: " + genre);
            });
            genreList.getChildren().add(genreButton);
        }

        ScrollPane scrollPane = new ScrollPane(genreList);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }
}
