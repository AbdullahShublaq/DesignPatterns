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
public class TakeCover extends AbstractState{

    public TakeCover(Solider solider) {
        super(solider);
    }

    @Override
    public void PlayerApproaches() {
    }

    @Override
    public void PlayerRuns() {
    }

    @Override
    public void fullHealth() {
        solider.setCurrentState(new Attack(solider));
        System.out.println("Attack...(ﾒ` ﾛ ´)︻デ═一");
    }

    @Override
    public void LowHealth() {
    }

    @Override
    public void NoHealth() {
        solider.setCurrentState(new Deceased(solider));
        System.out.println("Deceased...(×_×)");
    }

    @Override
    public void FullAmmo() {
    }

    @Override
    public void LowAmmo() {       
        solider.setPreviousState(solider.getCurrentState());
        solider.setCurrentState(new Reload(solider));
        System.out.println("Reload...");
    }
    
}
