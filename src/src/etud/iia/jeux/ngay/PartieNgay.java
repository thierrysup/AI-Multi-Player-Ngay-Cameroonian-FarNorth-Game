/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.ngay;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import src.etud.iia.jeux.vue.WindowNgay;
import src.etud.iia.jeux.vue.custom.FenetreDeChargement;

/**
 *
 * @author thierry
 */
public class PartieNgay {

    public static void main(String[] args) {
        FenetreDeChargement fenetre0 = new FenetreDeChargement();
		fenetre0.setVisible(false);
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
			
					//On met à jour 'le look and feel' de notre application avec celui du SE.
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
					//'FenetreDeConnexion' est une de mes classes de ce packétage : c'est un 'JFrame'.
//				WindowNgay wi = new WindowNgay();
//                                wi.setVisible(true);
                                fenetre0.getFen().setVisible(true);
			
			}
			
		}) ;

        
        
    }
}
