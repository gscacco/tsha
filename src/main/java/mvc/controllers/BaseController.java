package mvc.controllers;

import javafx.stage.Stage;

/**
 *
 * @author mpanagrosso
 */
public abstract class BaseController {

    protected static Stage stage;

    public BaseController() {
        stage = new Stage();

    }

    public static Stage getStage() {
        return stage;
    }
    
    // TODO:centralizzare la setAlwaysOnTop 
   abstract public void showView(Stage primaryStage);
   abstract public void hideView();
   abstract public void initialize();

}
