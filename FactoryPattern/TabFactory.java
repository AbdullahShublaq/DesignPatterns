/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Tab;

/**
 *
 * @author Abdullah Shublaq
 */
public class TabFactory {

    public static Map<Integer, Class<? extends MyTap>> tabs = new HashMap<>();

    static {
        File f = new File(new File("").getAbsolutePath().concat("\\src\\FactoryPattern\\Tabs"));

        int i = 1;
        for (File file : f.listFiles()) {
            String name = file.getName().split("\\.")[0];
            Class<? extends MyTap> c = null;
            try {
                c = Class.forName("FactoryPattern.Tabs." + name).asSubclass(MyTap.class);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TabFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabs.put(i, c);
            i++;
        }

    }

    public static MyTap createTap(int type) {
        Class<? extends MyTap> c = tabs.get(type);
        try {
            MyTap tab = c.getConstructor().newInstance();
            return tab;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TabFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
