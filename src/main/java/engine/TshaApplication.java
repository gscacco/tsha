/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import engine.managers.SessionManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mirko
 *
 */
public class TshaApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        setUpMainWindow();
        primaryStage.show();
        ObjectCreator.getInstance().createObjects();

        SessionManager.getInstance().manageUserLogin();


    }

    public static Stage getStage() {
        return primaryStage;
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    private void setUpMainWindow() {

        Group root = new Group();
        primaryStage.setScene(new Scene(root,Color.BLACK));
//         primaryStage.setFullScreen(true);

    }

}
