/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import canvas.TshaJFrameReference;
import canvas.TshaMainWindow;
import com.google.common.eventbus.Subscribe;
import engine.TshaApplication;
import engine.TshaEventBus;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;
import mvc.controllers.LoginPanelController;
import reports.SessionEvent;

/**
 *
 * @author Mirko
 */
public class SessionManager {

    private static SessionManager instance = null;

     Stage primaryStage;
     private SessionEvent sessionState;

    public static SessionManager getInstance() {

        if (instance == null) {
            instance = new SessionManager();
            TshaEventBus.getInstance().register(instance);

        }
        return instance;
    }

    private SessionManager() {
     primaryStage = TshaApplication.getStage();
    }

    public void manageUserLogin() {
        LoginPanelController.getInstance().showView(primaryStage);
    }
    
        @Subscribe
        public void handleSessionChange(SessionEvent event){
        if(event == SessionEvent.SESSION_ENTERED){
            try {
                startSession();
            } catch (IOException ex) {
                Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        }
        
        
        public void startSession() throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                SessionManager sessionManager = getInstance();

                // Setting LookAndFeel 
//                sessionManager.setLookAndFeel();

                //touch adapter connection
//                sessionManager.runTouchAdapter();
                TshaJFrameReference.getInstance().setMDI_Parent(new TshaMainWindow());
                // ---------------------------------------------------------------------
                // Starting logged in
                sessionState = SessionEvent.SESSION_ENTERED;
                 TshaJFrameReference.getInstance().getMDI_Parent().setVisible(true);
                 TshaJFrameReference.getInstance().getMDI_Parent().requestFocus();
            }
        });
            TshaApplication.getStage().setOpacity(0);
   }

    public void loadPlugins() {
    }

  
  
    
}
