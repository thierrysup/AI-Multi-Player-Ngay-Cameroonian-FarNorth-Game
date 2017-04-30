/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

import java.awt.Color;
import java.awt.Window;
import javax.swing.JWindow;
import src.etud.iia.jeux.vue.WindowNgay;
/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class FenetreDeChargement extends JWindow {
	
				/*id proposé par eclipse pour la classe. j'ai attribué le nombre tel que :
				 *le premier chiffre indique le packétage et le deuxième la classe.
				 *par example ici 2 pour le pakétage "mesOutils" l'autre pour la classe
				*/
	private static final long serialVersionUID = 24L;
	
	//instanciation de notre classe Panneau
	PanneauDeChargement pan = new PanneauDeChargement() ;
        WindowNgay fen ;
	private int compteur = 0;
    
	// constructeur
	public FenetreDeChargement(){
	    this.setBackground(Color.white) ;
	    fen =new WindowNgay();
		this.setSize(400, 200) ;
		this.setLocationRelativeTo(null) ;
		this.setContentPane(pan) ;

		this.setAlwaysOnTop(true) ;
		
		this.setVisible(true) ;
                
                
		
		// pose de 2s avant de commencer pour pallier à la lenter du processeur pour afficher la fenêtre
		try {
			Thread.sleep(1000) ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//repétition infinie de notre methode go()
		do{
			//Remise de Valeur definies par defaut dans la classe Panneau puor une bonne repétition
		   pan.setPosX(-10) ;
		   pan.setB(true) ;
		   pan.setA(2f) ;
		   go();
		   compteur ++ ;
		}
		while(compteur != 3) ;
	}

    public WindowNgay getFen() {
        return fen;
    }
        
	// defintion de la methode go()
	public void go(){
		//position de notre cercle rempli; modificateur dans pan.setPosX()
		int x = 0;
		//condition d'arrêt pour les apparutions  du cercle 
		boolean bol = false ;
		
		//premier defilement
		for( ; ; ){
			
			x = pan.getPosX() ;
			x++ ;
			pan.setPosX(x) ;
			
			try {
				Thread.sleep(2);
				pan.repaint() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// si x = à la position "STOP" numero 1 faire
			if(x == (int)(pan.getWidth()/2) - 15){
				x = -10 ;          //réinitialisation de la position du cercle
				pan.setA(2.5f) ;   // valeur de a pour le changement de la largeur du rectangle pour eviter d'effacer le premier position "STOP" du cerle
				
				// deuxième defilement
				for( ; ; ){
					
					x++ ;
					pan.setPosX(x) ;
					
					try {
						Thread.sleep(1) ; // pose de deux milliseconde
						pan.repaint() ;  // le contenu du composant est redessiner
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// si x = à la seconde position "STOP" numero 2 , arrêter le deuxième defilement
					if(x == (int)(pan.getWidth()/2)-45)
						break ;
				} // fin du 2eme defilement
				
				x = -10 ;        // réinitialisation
				pan.setA(2.7f) ; //  nouvelle valeur pour a
				
				// troisième et dernier defilement
				for( ; ; ){
					
					x++ ;
					pan.setPosX(x) ;
					
					try {
						Thread.sleep(1) ; // repos
						pan.repaint() ;   // dessin
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// si x = à la position "STOP" numero 3  defilement faire
					if(x == (int)(pan.getWidth()/2) - 75){
						bol = true ; //  vrai car arrivées terminer
						break ;      // fin du dernier defilement 
					} // fin de la 3eme codition d'arrêt
				} // fin du 3eme defilement
				
			}// fin de la 2eme condition d'arrêt 
			
			
			if(bol == true)
				break ;    // fin du premier et de tout les defilement
		
		}
		
		// initialisation de la position du cercle à la prémiere position "STOP"
		x = (int)(pan.getWidth()/2) - 15 ;
		pan.setB(false) ;  // condition pour les instruction néccessaire pour le depart du cercle
		
		// premier depart
		for( ; ; ){
			
			x++ ;
			pan.setPosX(x) ;
			pan.setA(2.2f) ;
			
			try {
				pan.repaint() ;
				Thread.sleep(2) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// si x à depasser la largeur du composant faire
			if(x == pan.getWidth()+15){
				
				x = (int)(pan.getWidth()/2) - 45 ; // valeur du second "STOP"
				pan.setA(2.9f) ;
				
				// second depart
				for( ; ; ){
					
					x++ ;
					pan.setPosX(x) ;
					
					try {
						pan.repaint() ;
						Thread.sleep(2) ;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// si x à depasser la largeur du composant faire
					if(x == pan.getWidth()+15){
						
						x = (int)(pan.getWidth()/2) - 75 ; // valeur du dernier "STOP"
						pan.setA(4f) ;
						
						// troisième depart
						for( ; ; ){
							
							x++ ;
							pan.setPosX(x) ;
							
							try {
								pan.repaint() ;
								Thread.sleep(1) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							if(x == pan.getWidth()+15)
								break ;   // arrêt du troisième depart
						} //fin du for
						
						break ;  //fin du duxième depart
					} // fin du if
					
				}  //fin du for
			
				break ; // fin du premier depart
			} //fin du if
			
		} // fin du for
	   	
   }   // fin de la methode go()
	
} //fin de la class

