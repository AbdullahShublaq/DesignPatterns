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
public class Reload extends AbstractState {

    public Reload(Solider solider) {
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
        if (solider.getPreviousState().getClass() == Attack.class) {
            solider.setPreviousState(solider.getCurrentState());
            solider.setCurrentState(new Attack(solider));
            System.out.println("Attack...(ﾒ` ﾛ ´)︻デ═一");
        } else if (solider.getPreviousState().getClass() == TakeCover.class) {
            solider.setPreviousState(solider.getCurrentState());
            solider.setCurrentState(new TakeCover(solider));
            System.out.println("Take Cover...┬┴┬┴┤(･_├┬┴┬┴");
        }
    }

    @Override
    public void LowAmmo() {
    }

}
