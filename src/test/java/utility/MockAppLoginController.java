/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import constants.PropertiesReader;
import unita.*;
import javafx.application.Application;
import javafx.stage.Stage;
import managers.interfaces.IAccountManager;
import mvc.controller.LoginController;

/**
 *
 * @author mpanagrosso
 */
public class MockAppLoginController extends MockApp {

    static FakeAccountManager accountManager;
    protected static Stage primaryStage;
    boolean accountManagerResult = false;

    @Override
    public void startSpecifiedComponents() {
        accountManager = new FakeAccountManager();
        accountManager.setValidationResult(accountManagerResult);
        LoginController controller = new LoginController(accountManager,new FakeCommunicationManager(), new Stage(), new PropertiesReader());
        controller.execute(primaryStage);
    }

    public static FakeAccountManager getAccountManager() {
        return accountManager;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
