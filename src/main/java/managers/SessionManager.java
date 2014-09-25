/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import com.google.common.eventbus.Subscribe;
import events.Events;
import javafx.stage.Stage;
import managers.interfaces.ICommunicationManager;
import managers.interfaces.IServiceManager;

/**
 *
 * @author mpanagrosso
 */
public class SessionManager {

    private Stage primaryStage;
private IServiceManager serviceManager;


    public SessionManager(Stage primaryStage, ICommunicationManager communicationManager, IServiceManager serviceManager) {
      
        this.primaryStage = primaryStage;
        this.serviceManager = serviceManager;
        communicationManager.register(this);
        serviceManager.execute(Events.SESSION_WAITING_LOGIN);
   
    }

    @Subscribe
    public void handleSessionChange(Events event) {
        serviceManager.execute(event);
        
    }

}
