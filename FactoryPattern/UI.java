/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author Abdullah Shublaq
 */
public class UI extends JFrame {

    public UI() {

        JTabbedPane tabbedPane = new JTabbedPane();

        for (int i : TabFactory.tabs.keySet()) {
            MyTap tab = TabFactory.createTap(i);
            String name = TabFactory.tabs.get(i).getSimpleName();
            JComponent content = tab.Content();
            tabbedPane.addTab(tab.Title(), tab.icon(), content, tab.Tip());
        }


        //Add the tabbed pane to this panel.
        add(tabbedPane);

        setTitle("Factory Pattern");
        Dimension d = new Dimension(500, 250);
        setSize(d);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }

}
