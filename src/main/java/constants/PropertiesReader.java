/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mpanagrosso
 */
public class PropertiesReader extends Properties implements IPropertyReader {

    private boolean unixOSused;

    public PropertiesReader(String configurationFile) {
        try {
//            "src\\main\\resources\\config\\tshaconfig.properties"
            FileInputStream in = new FileInputStream(configurationFile);
            this.load(in);
            unixOSused = Boolean.parseBoolean(getProperty("UNIXOS_USED"));
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot open config file");
        }
    }

    @Override
    public String getProperty(String key) {
        String strKey = super.getProperty(key);
        if (!unixOSused && strKey != null) {
            strKey = strKey.replace("/", "\\");
        }
        return strKey;
    }

    @Override
    public String readProperty(String property) {
        return getProperty(property);
    }
}
