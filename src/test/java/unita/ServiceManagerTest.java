/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import managers.ServiceManager;
import managers.interfaces.IServiceManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.SpyiService;

/**
 *
 * @author mpanagrosso
 */
public class ServiceManagerTest {

    private static IServiceManager manager;

    @BeforeClass
    public static void setUp() {
        manager = new ServiceManager();

    }

    enum fakeEnum {

        FAKENAME

    }

    @Test
    public void shouldRunAService() {
        //setup
        SpyiService spyService = new SpyiService();
        manager.register(fakeEnum.FAKENAME, spyService);

        manager.execute(fakeEnum.FAKENAME);
        Assert.assertTrue(spyService.verifyIsExecuted());
    }

}
