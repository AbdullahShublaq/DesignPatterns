/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPattern;

import javafx.scene.control.TextField;

/**
 *
 * @author Abdullah Shublaq
 */
public interface AddingCommand {
    
    public void execute();
    public void unexecute();
    public TextField getTextField();
    public String getText();
    
}
