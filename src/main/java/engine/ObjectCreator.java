/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import engine.managers.AccountManager;
import engine.managers.ReportsManager;
import engine.managers.SessionManager;
import javafx.stage.Stage;

/**
 *
 * @author mpanagrosso
 */
public class ObjectCreator {

    private static ObjectCreator instance = null;

    public static ObjectCreator getInstance() {

        if (instance == null) {
            instance = new ObjectCreator();
 

        }
        return instance;
    }

    public void createObjects() {
        ReportsManager.getInstance();
        TshaEventBus.getInstance();
        AccountManager.getInstance();
        SessionManager.getInstance();
    }
}
