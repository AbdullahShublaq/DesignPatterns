/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPattern;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah Shublaq
 */
public class Main extends Application{
   
    AddCommandManager manager;
    
    @FXML
    public ListView<String> ListView;
    @FXML
    public Button RedoButton, AddButton, UndoButton;
    @FXML
    public TextField TextField;
    
    @FXML        
    void Add(ActionEvent event) {
        TextCommand c = new TextCommand(ListView, TextField, TextField.getText());
        c.execute();
        manager.addCommand(c);
    }
    @FXML
    void Undo(ActionEvent event) {
        manager.undo();
    }
    @FXML
    void Redo(ActionEvent event) {
        manager.redo();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        manager = new AddCommandManager();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
        
        
        
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Command Pattern");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
