/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdullah Shublaq
 */
public class AddCommandManager {

    List<AddingCommand> commands = new ArrayList<>();
    int index = 0;

    public void addCommand(AddingCommand c) {
        commands.add(c);
        index++;
    }

    public void undo() {
        if (index > 0) {
            index--;
            AddingCommand c = commands.get(index);
            c.unexecute();
        }
    }

    public void redo() {
        if (index < commands.size()) {
            AddingCommand c = commands.get(index);
            c.execute();
            index++;
            
            if(index != commands.size()){
               c.getTextField().setText(commands.get(index).getText()); 
            }            
        }
    }

}
