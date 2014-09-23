/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import constants.PropertiesReader;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JFrame;
import managers.SessionManager;
import mvc.controller.LoginController;
import mvc.controller.TshaMainBarController;
import mvc.controller.interfaces.IService;
import mvc.controller.StartUpGuiController;

/**
 *
 * @author mpanagrosso
 */
public class MockAppSessionManager extends MockApp {

    boolean accountManagerResult = false;
    private static FakeCommunicationManager fakeCommmunicator;
    private SessionManager sessionManager;
    private static SpyStartUpGuiService spyService;

    @Override

    public void startSpecifiedComponents() {
        fakeCommmunicator = new FakeCommunicationManager();

        spyService = new SpyStartUpGuiService();
        spyService.setExecuteReturnValue(true);
        sessionManager = new SessionManager(primaryStage, fakeCommmunicator, spyService, new LoginController(new FakeAccountManager(), fakeCommmunicator, new Stage(), new PropertiesReader()));
    }

    public static FakeCommunicationManager getFakeCommunicator() {

        return fakeCommmunicator;

    }

    public static SpyStartUpGuiService getSpyService() {
        return spyService;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
