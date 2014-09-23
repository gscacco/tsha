/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import com.google.common.eventbus.EventBus;
import java.util.HashMap;
import managers.interfaces.ICommunicationManager;

/**
 *
 * @author mpanagrosso
 */
public class CommmunicationManager implements ICommunicationManager {

    EventBus eventBus = new EventBus();

    private HashMap<Object, Object> subscribers;

    public CommmunicationManager() {
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
