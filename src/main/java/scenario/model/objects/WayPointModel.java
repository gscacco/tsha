/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenario.model.objects;

import gov.nasa.worldwind.geom.Position;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mpanagrosso
 */
public class WayPointModel {

    private SimpleObjectProperty<Position> position = new SimpleObjectProperty();
    private StringProperty labelText = new SimpleStringProperty();

    public void setPosition(Position pos) {
       position.setValue(pos);

    }

    public void setLabel(String label) {

        labelText.setValue(label);

    }

    public StringProperty getLabel() {
        return labelText;
    }

    public SimpleObjectProperty<Position> getPosition() {
        return position;
    }

}
