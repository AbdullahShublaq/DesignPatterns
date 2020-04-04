/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.States;

import StatePattern.Solider;

/**
 *
 * @author Abdullah Shublaq
 */
public abstract class AbstractState implements State{
    
    Solider solider;
    
    public AbstractState(Solider solider) {
        this.solider = solider;
    }
    
}
