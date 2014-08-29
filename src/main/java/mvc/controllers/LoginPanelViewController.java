/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Mirko
 */
public class LoginPanelViewController implements Initializable {

    @FXML
    private TshaTextFieldControl userName;
    @FXML
    private TshaPasswordFieldControl passWord;
    @FXML
    private Button login;
    @FXML
    private Button shutDown;
    @FXML
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userName.setLabelText("User Name");
        passWord.setLabelText("Password");
        login.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                root.getScene().getWindow().hide();
            }
        });

        shutDown.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                root.getScene().getWindow().hide();
            }
        });

//        for (Node node : ((AnchorPane)userName.getChildren().get(0)).getChildren()) {
//            if (node.getId().equals("text")) {
//                node.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
//                    public void handle(KeyEvent event) {
//                        TextField userText = (TextField) event.getSource();
//                        if (userText.getText().length() >= 5) {
//                            userText.setStyle(".red");
//                        }
//                        if (event.getCharacter().matches("[A-Za-z]")) {
//                        } else {
//                            userText.setStyle(".red");
//
//                        }
//                    }
//                });
//            }
//        }

    }

}
