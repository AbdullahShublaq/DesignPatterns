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
public class Deceased extends AbstractState{

    public Deceased(Solider solider) {
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
    }

    @Override
    public void FullAmmo() {
    }

    @Override
    public void LowAmmo() {
    }
    
}
