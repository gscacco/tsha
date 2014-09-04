/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import engine.TshaEventBus;
import java.io.Serializable;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author mpanagrosso
 */
public class CommandReport implements Serializable {

    Window window;
    String message;
    int commandResult;

    public CommandReport(Window window, String message, int commandResult) {
        this.window = window;
        this.message = message;
        this.commandResult = commandResult;
    }

    public Window getWindow() {
        return window;
    }

    public String getMessage() {
        return message;
    }

    
    public int getCommandResult() {
        return commandResult;
    }
}
