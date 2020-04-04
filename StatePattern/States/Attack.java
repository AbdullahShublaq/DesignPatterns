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
public class Attack extends AbstractState{

    public Attack(Solider solider) {
        super(solider);
    }

    @Override
    public void PlayerApproaches() {
    }

    @Override
    public void PlayerRuns() {
        solider.setCurrentState(new Patrol(solider));
        System.out.println("Patrol...(←_←).(→_→)");
    }

    @Override
    public void fullHealth() {
    }

    @Override
    public void LowHealth() {
        solider.setCurrentState(new TakeCover(solider));
        System.out.println("Take Cover...┬┴┬┴┤(･_├┬┴┬┴");
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
