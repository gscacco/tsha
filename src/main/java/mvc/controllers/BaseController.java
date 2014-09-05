package mvc.controllers;

import event.data.IExchangeData;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;

/**
 *
 * @author mpanagrosso
 */
public abstract class BaseController  implements ChangeListener<IExchangeData> {

    protected static Stage stage;

    public BaseController() {
        stage = new Stage();

    }

    public static Stage getStage() {
        return stage;
    }
    
   abstract public void showView(Stage primaryStage);
   abstract public void hideView();
   abstract public void initialize();

}
