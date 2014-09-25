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
    private static FakeServiceManager fakeServiceManager;

    @Override

    public void startSpecifiedComponents() {
        fakeCommmunicator = new FakeCommunicationManager();
        fakeServiceManager =  new FakeServiceManager();
        sessionManager = new SessionManager(primaryStage, fakeCommmunicator,fakeServiceManager);
    }

    public static FakeServiceManager getFakeServiceManager() {
        return fakeServiceManager;
    }
    public static FakeCommunicationManager getFakeCommunicator() {

        return fakeCommmunicator;

    }


    public static void main(String[] args) {
        launch(args);

    }
}
