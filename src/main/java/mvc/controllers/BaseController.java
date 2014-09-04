/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.controllers;

import javafx.stage.Stage;

/**
 *
 * @author mpanagrosso
 */
public class BaseController {
    protected static Stage stage;
    public BaseController(){
        stage = new Stage();
    
    }
    
      public static Stage getStage(){return stage;}
    
}
