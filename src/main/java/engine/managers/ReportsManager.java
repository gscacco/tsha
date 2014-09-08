/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import com.google.common.eventbus.Subscribe;
import engine.TshaEventBus;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import reports.CommandReport;

/**
 *
 * @author mpanagrosso
 */
public class ReportsManager {

    private static ReportsManager instance = null;

    public static ReportsManager getInstance() {

        if (instance == null) {
            instance = new ReportsManager();
            TshaEventBus.getInstance().register(instance);

        }
        return instance;
    }

    @Subscribe
    public boolean handleCommandReport(CommandReport event) {
        if (event.getCommandResult() > 0) {
            final PopupControl popup = new PopupControl();
            popup.setAutoFix(false);
            popup.setHideOnEscape(true);
            popup.getScene().setRoot(new Label(event.getMessage()));
            popup.setId("popup");
            popup.show(event.getWindow());
            popup.setAutoHide(true);
            return false;
        } else {
            return true;
        }

    }
}
