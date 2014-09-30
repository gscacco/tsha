/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import constants.IPropertyReader;
import events.Events;
import mvc.controller.interfaces.BaseController;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import managers.interfaces.ICommunicationManager;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class TshaMainBarController extends AnchorPane implements BaseController,
                                                                 IService {

    private Stage stage;
    private Stage primaryStage;
    private ICommunicationManager communicationManager;
    private PopUpConfirmController confirmController;
    @FXML
    private Button logoutButton;

    public TshaMainBarController(Stage primaryStage, Stage stage, 
                                ICommunicationManager communicationManager, 
                                IPropertyReader propertiesReader, 
                                PopUpConfirmController confirmController) {
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.communicationManager = communicationManager;
        this.confirmController  = confirmController;
        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainBar.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        initStage();
    }

    @Override
    public void showView() {
        this.setVisible(true);
        stage.show();

    }

    @Override
    public void hideView() {
        this.setVisible(false);
        stage.hide();
    }

    @Override
    public final void initStage() {
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.initOwner(primaryStage);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                confirmController.setPopUpMessage("Are you sure you want exit?");
                confirmController.showView();
            }
        });
    }

    public void setSize(double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }

    public void setLocation(int xPos, int yPos) {
        stage.setX(xPos);
        stage.setY(yPos);

    }

    @Override
    public void execute() {

        showView();
    }

    @Override
    public void release() {
        hideView();
    }

}
