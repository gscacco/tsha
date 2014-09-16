/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import com.google.common.eventbus.Subscribe;
import engine.TshaEventBus;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import reports.CommandReport;

/**
 *
 * @author mpanagrosso
 */
public class ReportsManager {

    private static ReportsManager instance = null;
    public final static int PROCESSED = 0;
    public final static int NULLVIEW = 1;
    public final static int NULLMESSAGE = 2;
    public final static int COMMANDNOTVALID = 3;

    public static ReportsManager getInstance() {

        if (instance == null) {
            instance = new ReportsManager();
            TshaEventBus.getInstance().register(instance);

        }
        return instance;
    }

    @Subscribe
    public int handleCommandReport(final CommandReport event) {
        if (event.getWindow() == null) {
            return NULLVIEW;
        }
        if (event.getMessage() == null) {
            return NULLMESSAGE;
        }
        if (event.getCommandResult() != 0) {
            return COMMANDNOTVALID;
        }
       
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
            final PopupControl popup = new PopupControl();
            popup.setAutoFix(false);
            popup.setHideOnEscape(true);
            popup.getScene().setRoot(new Label(event.getMessage()));
            popup.setId("popup");
            popup.show(event.getWindow());
            popup.setAutoHide(true); 
            }
        });
      
            return PROCESSED;
        

    }
}
