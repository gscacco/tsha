/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.controllers.interfaces;

import reports.CommandReport;

/**
 *
 * @author mpanagrosso
 */
public interface IActionButton {
    public CommandReport ok();
    public void cancel();
    public CommandReport apply();
    public void close();
}
