/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import javafx.stage.Stage;
import mvc.controllers.LoginPanelController;

/**
 *
 * @author Mirko
 */
public class SessionManager {

    static Stage primaryStage;


    public SessionManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void manageUserLogin() {
            LoginPanelController.getInstance().showView(primaryStage);
    }

}
