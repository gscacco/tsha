/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class ResourcesReleaser implements IService {

    ArrayList<IService> registeredResources = new ArrayList<>();

    @Override
    public void execute() {
        release();
    }

    @Override
    public void release() {
        for (IService registeredResource : registeredResources) {

            registeredResource.release();
        }
    }

    public void register(IService service) {
        registeredResources.add(service);
    }

}
