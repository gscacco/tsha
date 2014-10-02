/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenario.objects;

import gov.nasa.worldwind.geom.Position;
import scenario.model.objects.WayPointModel;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.GlobeAnnotation;
import java.util.Observable;
import java.util.Observer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author mpanagrosso
 */
public class GraphicWayPoint {

    private GlobeAnnotation annotation;

    public GraphicWayPoint(WayPointModel wp, RenderableLayer layer) {
        annotation = new GlobeAnnotation(wp.getLabel().get(), wp.getPosition().get());
        layer.addRenderable(annotation);

        
        
        wp.getLabel().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal,
                    Object newVal) {
                System.out.println("label has changed! " + o.getValue());
                annotation.setText((String)o.getValue());
            }
        });

        
        wp.getPosition().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal,
                    Object newVal) {
                System.out.println("position has changed! " + o.getValue());
                annotation.setPosition((Position)o.getValue());
            }
        });
    }


}
