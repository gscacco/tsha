/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.interfaces;

import mvc.controller.interfaces.IService;


/**
 *
 * @author mpanagrosso
 */
public interface IServiceManager {


    public void register(Object topic, IService service);

    public void execute(Object topic);
    
}
