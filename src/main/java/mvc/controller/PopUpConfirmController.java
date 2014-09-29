/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import constants.IPropertyReader;
import events.Events;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import managers.interfaces.ICommunicationManager;
import mvc.controller.interfaces.BaseController;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class PopUpConfirmController extends AnchorPane implements BaseController {

    private Stage stage;
    private Stage primaryStage;
    private ICommunicationManager communicationManager;
    private Events eventToFire;
    @FXML
    private Label confirmMessage;
    @FXML
    Button yesButton;
    @FXML
    Button noButton;

    public PopUpConfirmController(Stage primaryStage, Stage stage, ICommunicationManager communicationManager, IPropertyReader propertiesReader, Events event) {
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.communicationManager = communicationManager;

        this.eventToFire = event;
        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + propertiesReader.readProperty("views") + "PopUpConfirm.fxml"));
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
    public void initStage() {
        
        confirmMessage.setWrapText(true);
        confirmMessage.autosize();
        confirmMessage.setAlignment(Pos.CENTER);
        Scene scene = new Scene(this);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setOpacity(0.9);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setAlwaysOnTop(true);
        stage.initOwner(primaryStage);

        yesButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hideView();
                communicationManager.post(eventToFire);

            }
        });

        noButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hideView();
            }
        });
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

    public void setPopUpMessage(String message) {
       confirmMessage.setText(message);
    }

}
