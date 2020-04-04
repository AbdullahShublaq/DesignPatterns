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
public class Patrol extends AbstractState{


    public Patrol(Solider solider) {
        super(solider);
    }

    @Override
    public void PlayerApproaches() {
        solider.setCurrentState(new Attack(solider));
        System.out.println("Attack...(ﾒ` ﾛ ´)︻デ═一");
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
    }
    @Override
    public void LowAmmo() {
    }
    
}
