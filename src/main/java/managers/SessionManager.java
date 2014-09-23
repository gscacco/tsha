/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import com.google.common.eventbus.Subscribe;
import events.SessionEvent;
import javafx.stage.Stage;
import managers.interfaces.ICommunicationManager;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class SessionManager {

    private Stage primaryStage;

    private IService startUpGuiController;
    private IService loginController;

    public SessionManager(Stage primaryStage, ICommunicationManager communicationManager, IService startUpGuiController, IService loginController) {
        this.primaryStage = primaryStage;
        communicationManager.register(this);
        this.startUpGuiController = startUpGuiController;
        this.loginController = loginController;
        loginController.execute(primaryStage);

    }

    @Subscribe
    public void handleSessionChange(SessionEvent event) {
        if (event == SessionEvent.SESSION_ENTERED) {
            startUpGuiController.execute();
        }
    }

}
