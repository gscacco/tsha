/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import mvc.controller.ResourcesReleaser;

/**
 *
 * @author mpanagrosso
 */
public class MockAppResourcesReleaser extends MockApp {

   private static ResourcesReleaser releaser;

    public static ResourcesReleaser getReleaser() {
        return releaser;
    }

    @Override
    public void startSpecifiedComponents() {
        releaser = new ResourcesReleaser(new FakeCommunicationManager());
        
       
    }

}
