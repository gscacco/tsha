/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import constants.PropertiesReader;
import javafx.stage.Stage;
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
        LoginController controller = new LoginController(accountManager,new FakeCommunicationManager(),primaryStage, new Stage(), new PropertiesReader("src\\main\\resources\\config\\tshaconfig.properties"));
        controller.execute();
    }

    public static FakeAccountManager getAccountManager() {
        return accountManager;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
