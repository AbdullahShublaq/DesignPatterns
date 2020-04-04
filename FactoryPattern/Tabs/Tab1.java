/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern.Tabs;

import FactoryPattern.MyTap;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdullah Shublaq
 */
public class Tab1 implements MyTap {

    @Override
    public String Title() {
        return "test1";
    }

    @Override
    public Icon icon() {
        return null;
    }

    @Override
    public String Tip() {
        return "test1,hint";
    }

    @Override
    public JPanel Content() {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel();
        filler.setIcon(new ImageIcon(new File("").getAbsolutePath().concat("\\src\\FactoryPattern\\Icons\\icon.png")));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
