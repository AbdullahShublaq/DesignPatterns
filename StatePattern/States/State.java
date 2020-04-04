/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.States;

/**
 *
 * @author Abdullah Shublaq
 */
public interface State {

    public void PlayerApproaches();
    public void PlayerRuns();
    public void fullHealth();
    public void LowHealth();
    public void NoHealth();
    public void FullAmmo();
    public void LowAmmo();
}
