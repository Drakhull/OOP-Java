package br.edu.ifba.inf008.plugins;

import br.edu.ifba.inf008.interfaces.IPlugin;
import br.edu.ifba.inf008.interfaces.ICore;
import br.edu.ifba.inf008.interfaces.IUIController;

import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

public class MyPlugin implements IPlugin
{
    public boolean init() {
        IUIController uiController = ICore.getInstance().getUIController();

        MenuItem menuItem = uiController.createMenuItem("Menu", "My Menu Item");
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("I've been clicked!");
            }
        });

        // HBox hBox = uiController.createSearchBar();

        // uiController.createTab("new tab", new Rectangle(200,200, Color.LIGHTSTEELBLUE));

        // uiController.createTab("new tab", new Image("https://cdn.britannica.com/43/125343-004-E0E57F29/Satan-illustration-Gustave-Dore-John-Milton-Paradise.jpg"));

        return true;
    }
}
