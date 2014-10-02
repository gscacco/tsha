/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import scenario.objects.GraphicWayPoint;
import scenario.model.objects.WayPointModel;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.GlobeAnnotation;
import gov.nasa.worldwind.render.Renderable;
import org.junit.Assert;
import org.junit.Test;
import utility.UniqueGenerator;

/**
 *
 * @author mpanagrosso
 */
public class GraphicWayPointTest {

    @Test
    public void shouldExist() {

        //setup
        WayPointModel wp = new WayPointModel();

        wp.setPosition(new Position(LatLon.fromDegrees(41, 12), 1000));
        String labelText = UniqueGenerator.getString();
        wp.setLabel(labelText);
        RenderableLayer layer = new RenderableLayer();

        //exercise
        GraphicWayPoint gwp = new GraphicWayPoint(wp, layer);
        GlobeAnnotation annotation = null;
        for (Renderable r : layer.getRenderables()) {
            if (r instanceof GlobeAnnotation) {
                annotation = (GlobeAnnotation) r;
            }
        }

        //verify
        Assert.assertEquals(annotation.getText(), labelText);
        Assert.assertEquals(annotation.getPosition().latitude, wp.getPosition().get().getLatitude());
        Assert.assertEquals(annotation.getPosition().longitude, wp.getPosition().get().getLongitude());
        Assert.assertTrue(annotation.getPosition().getAltitude() == wp.getPosition().get().getAltitude());

    }

    @Test
    public void shouldUpdate() {
        WayPointModel wp = new WayPointModel();

        wp.setPosition(new Position(LatLon.fromDegrees(41, 12), 1000));

        wp.setLabel(UniqueGenerator.getString());

        RenderableLayer layer = new RenderableLayer();
        GraphicWayPoint gwp = new GraphicWayPoint(wp, layer);
        //exercise

        wp.setLabel(UniqueGenerator.getString());
        wp.setPosition(new Position(LatLon.fromDegrees(55, 23), 2000));

        GlobeAnnotation annotation = null;
        for (Renderable r : layer.getRenderables()) {
            if (r instanceof GlobeAnnotation) {
                annotation = (GlobeAnnotation) r;
            }
        }

        //verify
        Assert.assertEquals(annotation.getText(), wp.getLabel().get());

        Assert.assertEquals(annotation.getPosition().latitude, wp.getPosition().get().getLatitude());
        Assert.assertEquals(annotation.getPosition().longitude, wp.getPosition().get().getLongitude());
        Assert.assertTrue(annotation.getPosition().getAltitude() == wp.getPosition().get().getAltitude());
    }

}
