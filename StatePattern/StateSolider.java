/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

import StatePattern.States.Attack;
import StatePattern.States.Deceased;
import StatePattern.States.Patrol;
import StatePattern.States.Reload;
import StatePattern.States.State;
import StatePattern.States.TakeCover;

/**
 *
 * @author Abdullah Shublaq
 */
public class StateSolider implements Solider{

    State currentState = null;
    State previousState = null;//For Reload State
    
    @Override
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    @Override
    public void setPreviousState(State state) {
        this.previousState = state;
    }    
    @Override
    public State getPreviousState() {
        return this.previousState;
    }

    public StateSolider() {
        System.out.println("Create Solider");
        this.setCurrentState(new Patrol(this));
        System.out.println("Patrol...(←_←).(→_→)");
    }
    
    @Override
    public void PlayerApproaches() {
        this.currentState.PlayerApproaches();
    }
    @Override
    public void PlayerRuns() {
        this.currentState.PlayerRuns();
    }
    @Override
    public void fullHealth() {
        this.currentState.fullHealth();
    }
    @Override
    public void LowHealth() {
        this.currentState.LowHealth();
    }
    @Override
    public void NoHealth() {
        this.currentState.NoHealth();
    }
    @Override
    public void FullAmmo() {
        this.currentState.FullAmmo();
    }
    @Override
    public void LowAmmo() {
        this.currentState.LowAmmo();
    }

    @Override
    public State getCurrentState() {
        return this.currentState;
    }
    
}
