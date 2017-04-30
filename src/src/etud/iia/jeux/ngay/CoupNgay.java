/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.ngay;

import src.etud.iia.jeux.modele.CoupJeu;

/**
 *
 * @authors thierry && mercedes
 */
public class CoupNgay implements CoupJeu {

    private int indiceTrou;

    /**
     * **** Clonstructeur ******
     */
    public CoupNgay(int indiceTrou) {
        this.indiceTrou = indiceTrou;
    }

    /**
     * **** Accesseurs ******
     */
    public int getIndiceTrou() {
        return indiceTrou;
    }

    public void setIndiceTrou(int indiceTrou) {
        this.indiceTrou = indiceTrou;
    }

    /**
     * **** Accesseurs ******
     */
    
    
    @Override
    public String toString() {
        return "(" + (indiceTrou + 1) + ")";
    }
}
