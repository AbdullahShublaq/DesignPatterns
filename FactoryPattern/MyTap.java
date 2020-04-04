/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Abdullah Shublaq
 */
public interface MyTap {
    
    public String Title();
    public Icon icon();
    public String Tip();
    public JPanel Content();
    
}
