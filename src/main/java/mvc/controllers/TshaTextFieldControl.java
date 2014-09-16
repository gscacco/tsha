package mvc.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stefano
 */
public class TshaTextFieldControl extends AnchorPane implements Initializable{

    @FXML
    private Label labelPippo;
    @FXML
    private TextField textPippo;

    public TshaTextFieldControl() throws MalformedURLException {
        java.nio.file.Path path = Paths.get("");
        System.out.println(path.toAbsolutePath().toString());
        FXMLLoader loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\base\\TshaTextFieldGadget.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(TshaPasswordFieldControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
    }

    public void setLabelText(String str) {
//        AnchorPane pane = (AnchorPane) getChildren().get(0);
//        for (Node item : pane.getChildren()) {
//            if (item.getId().equals("label")) {
//                ((Label) item).setText(str);
//                break;
//            }
//        }
       labelPippo.setText(str);
   }

    public TextField getTextField() {
//        AnchorPane pane = (AnchorPane) getChildren().get(0);
//        for (Node item : pane.getChildren()) {
//            if (item.getId().equals("text")) {
//                return ((TextField) item);
//
//            }
//        }
//        return null;
        return textPippo;
    }


    public void init() {
        if(textPippo != null){
        return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void load() {
        java.nio.file.Path path = Paths.get("");
        System.out.println(path.toAbsolutePath().toString());
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\base\\TshaTextFieldGadget.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TshaTextFieldControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TshaPasswordFieldControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
