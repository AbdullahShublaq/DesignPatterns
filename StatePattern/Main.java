/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah Shublaq
 */
public class Main extends Application implements Initializable {
    
    @FXML
    public RadioButton playerApproachesRadio, playerRunsRadio;
    ToggleGroup enemyGroup;
    
    @FXML
    public RadioButton healthFullRadio, healthLowRadio, healthNoRadio;
    ToggleGroup healthGroup;
    
    @FXML
    public RadioButton ammoFullRadio, ammoLowRadio;
    ToggleGroup ammoGroup;

    public Solider solider;
    
    @FXML
    void Action(ActionEvent event) {
        //Enemy
        if(playerApproachesRadio.isSelected()){
            solider.PlayerApproaches();
        }else if(playerRunsRadio.isSelected()){
            solider.PlayerRuns();
        }
        //Health
        if(healthFullRadio.isSelected()){
            solider.fullHealth();
        }else if(healthLowRadio.isSelected()){
            solider.LowHealth();
        }else if(healthNoRadio.isSelected()){
            solider.NoHealth();
        }
        //Ammo
        if(ammoFullRadio.isSelected()){
            solider.FullAmmo();
        }else if(ammoLowRadio.isSelected()){
            solider.LowAmmo();
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        solider = new StateSolider();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
 
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("State Pattern");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enemyGroup = new ToggleGroup();
        playerApproachesRadio.setToggleGroup(enemyGroup);
        playerRunsRadio.setToggleGroup(enemyGroup);
        
        healthGroup = new ToggleGroup();
        healthFullRadio.setToggleGroup(healthGroup);
        healthLowRadio.setToggleGroup(healthGroup);
        healthNoRadio.setToggleGroup(healthGroup);
        
        ammoGroup = new ToggleGroup();
        ammoFullRadio.setToggleGroup(ammoGroup);
        ammoLowRadio.setToggleGroup(ammoGroup);
    }
}
