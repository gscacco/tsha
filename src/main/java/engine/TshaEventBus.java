/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.google.common.eventbus.EventBus;

/**
 *
 * @author mpanagrosso
 */
public class TshaEventBus extends EventBus {

    private static TshaEventBus instance = null;

    public static TshaEventBus getInstance() {

        if (instance == null) {
            instance = new TshaEventBus();
        }
        return instance;
    }

}
