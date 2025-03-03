package br.edu.ifba.inf008.plugins;

import br.edu.ifba.inf008.interfaces.IPlugin;
import br.edu.ifba.inf008.interfaces.ICore;
import br.edu.ifba.inf008.interfaces.IUIController;
import br.edu.ifba.inf008.shell.RegisterBookScreen;

import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MyPlugin implements IPlugin
{
    public boolean init() {
        IUIController uiController = ICore.getInstance().getUIController();

        MenuItem menuItem = uiController.createMenuItem("Register Book", "Register New Book");
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage registerStage = new Stage();
                registerStage.setTitle("Register New Book");


                Scene registerScene = RegisterBookScreen.createRegisterBookScene(registerStage);


                registerStage.setScene(registerScene);


                registerStage.show();
            }
        });

        // uiController.createTab("new tab", new Rectangle(200,200, Color.LIGHTSTEELBLUE));

        // uiController.createTab("new tab", new Image("https://cdn.britannica.com/43/125343-004-E0E57F29/Satan-illustration-Gustave-Dore-John-Milton-Paradise.jpg"));

        return true;
    }
}
