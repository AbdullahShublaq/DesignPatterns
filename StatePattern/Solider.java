/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

import StatePattern.States.State;

/**
 *
 * @author Abdullah Shublaq
 */
public interface Solider {
    
    public void PlayerApproaches();
    public void PlayerRuns();
    public void fullHealth();
    public void LowHealth();
    public void NoHealth();
    public void FullAmmo();
    public void LowAmmo();
    public void setCurrentState(State state);
    public void setPreviousState(State state);
    public State getCurrentState();
    public State getPreviousState();
}
