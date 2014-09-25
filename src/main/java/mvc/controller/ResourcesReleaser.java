/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import com.google.common.eventbus.Subscribe;
import events.Events;
import java.util.ArrayList;
import managers.interfaces.ICommunicationManager;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class ResourcesReleaser implements IService {

    ICommunicationManager communicationManager;

    public ResourcesReleaser(ICommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
    }

    ArrayList<IService> registeredResources = new ArrayList<>();

    @Override
    public void execute() {
        release();

    }

    @Override
    public void release() {
        for (IService registeredResource : registeredResources) {

            registeredResource.release();
            communicationManager.post(Events.SESSION_WAITING_LOGIN);
        }
    }

    public void register(IService service) {
        registeredResources.add(service);
    }

}
