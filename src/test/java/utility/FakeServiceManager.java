/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.HashMap;
import managers.interfaces.IServiceManager;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class FakeServiceManager implements IServiceManager{

  private HashMap<Object, Runnable> registeredServices = new HashMap<>();

    @Override
    public void register(Object topic, IService service) {
        registeredServices.put(topic, () -> service.execute());

    }

    @Override
    public void execute(Object topic) {
        if (registeredServices.containsKey(topic)) {
            registeredServices.get(topic).run();
        }
    }
}
