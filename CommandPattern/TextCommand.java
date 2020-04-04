/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPattern;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Abdullah Shublaq
 */
public class TextCommand implements AddingCommand{
    
    public ListView<String> ListView;
    public TextField TextField;
    public String text;

    public TextCommand(ListView<String> ListView, TextField TextField, String text) {
        this.ListView = ListView;
        this.TextField = TextField;
        this.text = text;
    }
    
    
    @Override
    public void execute() {
        if(!text.trim().equals("")){
            ListView.getItems().add(text);
        }
        TextField.setText("");
    }

    @Override
    public void unexecute() {
        if(ListView.getItems().size() > 0){
            String Lasttext = ListView.getItems().get(ListView.getItems().size()-1);
            ListView.getItems().remove(Lasttext);
            TextField.setText(Lasttext);
        }
    }
	
	@Override
    public TextField getTextField() {
        return TextField;
    }
    
    @Override
    public String getText() {
        return text;
    }
    
}
