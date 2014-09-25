/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.common.eventbus.EventBus;
import java.util.HashMap;
import managers.interfaces.ICommunicationManager;

/**
 *
 * @author mpanagrosso
 */
public class FakeCommunicationManager implements ICommunicationManager {
    EventBus eventBus = new EventBus();
    
    private HashMap<Object, Object> subscribers;

    public FakeCommunicationManager() {
        subscribers = new HashMap<>();
        
    }

    @Override
    public void register(Object subscriber) {
       subscribers.put(subscriber, null);
       eventBus.register(subscriber);
       
    }

 
    @Override
    public void post(Object event) {
        eventBus.post(event);

    }

}
