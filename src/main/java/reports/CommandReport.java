/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import engine.TshaEventBus;
import javafx.stage.Stage;

/**
 *
 * @author mpanagrosso
 */
public class CommandReport {

    Stage stage;
    String message;

    public CommandReport(Stage stage, String message) {
        this.stage = stage;
        this.message = message;
    }

    public Stage getStage() {
        return stage;
    }

    public String getMessage() {
        return message;
    }

}
