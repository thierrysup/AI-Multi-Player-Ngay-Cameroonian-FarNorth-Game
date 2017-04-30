/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.ngay;

import java.util.ArrayList;
import src.etud.iia.jeux.alg.AlgoJeu;
import src.etud.iia.jeux.alg.MaxN;
import src.etud.iia.jeux.modele.joueur.Joueur;

/**
 *
 * @authors thierry && mercedes
 */
public class PartieNgay2 {

    public static void main(String[] args) {

        Joueur j1 = new Joueur("1", 3);
        Joueur j2 = new Joueur("2", 4);
        Joueur j3 = new Joueur("3", 3);

        boolean jeufini = false;
        int joueurTour = 0;

        int profondeurMax = 1;
        System.out.println("********   essaie du TPE dedier aux jeu de Ngay 3 joueur - TPE COUR DE SMA   **********");
       
        AlgoJeu AlgoJoueur[] = new AlgoJeu[3];
        AlgoJoueur[0] = new MaxN(HeuristiquesNgay.h1, j1, j2, j3, 1);
      
        AlgoJoueur[1] = new MaxN(HeuristiquesNgay.h2, j2, j3, j1, profondeurMax);
        AlgoJoueur[2] = new MaxN(HeuristiquesNgay.h3, j3, j1, j2, profondeurMax);
        // AlgoJoueur[1] = new Humain();
        System.out.println("PARTIE POUR UNE RECHERCHE Max N A PROFONDEUR "
                + profondeurMax + " (joueur 2 et joueur 3)\n");
        System.out.println("Etat Initial du plateau de jeu:");

        PlateauNgay.setJoueurs(j1, j2, j3); // Pour savoir qui joue "1" et qui joue "2" et qui joue "3" 
        PlateauNgay plateauCourant = new PlateauNgay(j1); // On commence par le Joueur Blanc (arbitraire)

        // on itere sur les  joueurs, tant que le jeu n'est pas fini
        while (plateauCourant.finPartieNgay() == false) {
            System.out.println("avant le if " + joueurTour);
            if (joueurTour == 0) {
                plateauCourant.jouer(j1, AlgoJoueur);

                joueurTour = 1;
                System.out.println("apres le premier if " + joueurTour);
            } else if (joueurTour == 1) {
                plateauCourant.jouer(j2, AlgoJoueur);
                joueurTour = 2;
            } else {
                plateauCourant.jouer(j3, AlgoJoueur);

                joueurTour = 0;
            }
        }
    }
}
