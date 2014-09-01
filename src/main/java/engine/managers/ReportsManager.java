/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import com.google.common.eventbus.Subscribe;
import engine.TshaEventBus;
import reports.CommandReport;

/**
 *
 * @author mpanagrosso
 */
public class ReportsManager {

    private static ReportsManager instance = null;

    public static ReportsManager getInstance() {

        if (instance == null) {
            instance = new ReportsManager();
            TshaEventBus.getInstance().register(instance);
        }
        return instance;
    }
    
    
    
    @Subscribe
    public void handleCommandReport(CommandReport event){
    
    }
}
