/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
// importation néccessaire à la realisation de notre "container" ou composant
import java.awt.Graphics ;
import java.awt.Font ;
import java.awt.Color ;
import java.awt.Image ;

import java.io.File ;
import java.io.IOException ;

import javax.imageio.ImageIO ;
import javax.swing.ImageIcon;
import javax.swing.JPanel ;

// Definition de notre classe (notre composant)
public class PanneauDeChargement extends JPanel {
	
				/*id proposé par eclipse pour la classe. j'ai attribué le nombre tel que :
				 *le premier chiffre indique le packétage et le deuxième la classe.
				 *par example ici 2 pour le pakétage "mesOutils" l'autre pour la classe
				*/
	private static final long serialVersionUID = 29L;

	// Variable qui permettra de definir la position de notre cercle rempli
	private int posX = -10 ;
	
	//Variable qui permettra d'attribuer une position à notre rectangle (Voir son rôle à l'endroit approprié
	private Float a = 2f ;
	
	//condition pour la venue de notre cercle et pour son depart
	private boolean b = true ;
	
    // Pour definir le style d'écriture 
	Font font = new Font("Ubuntu", Font.TRUETYPE_FONT, 18) ;
        
        
	
	
	// Definition de la methode "paintComponent"
	public void paintComponent(Graphics g){
		
		try {
			Image img = ImageIO.read(new File("src/ressources/images/oui.png"));
                       // Image img1 =ImageIO.read(new File("src/ressources/images/progress_ring.gif"));
			g.drawImage(img, 100, 30, 50, 100,this) ;
                        //g.drawImage(img1, 200,100, 50, 50, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setFont(font);
		g.setColor(Color.blue) ;
		g.drawString("       L  o  a  d  i  n  g  .  .  .", 150, 80) ;
		      
		//apparution de notre cercle rempli
		if(b == true){
          
			/* Le rectangle se trouvant sur la trajectoire de notre cercle se dessine.
			 * ce rectangle est d'abord dessiner pour effacer les précédantes positions de notre cercle
			 * la largeur est de determiner par la division de celui de notre composante par le float a
			 * largeur qui dépendra des positions "STOP" de notre cercle tel qu'indiquer dans la methode "go()" de la classe Fenetre utilisant notre conteneur
			 * la variable a est choisi aléatoirement suivant les instructions de la methode go()
			 * pourvue qu'il permet au rectangle d'efffacer toute les positions voulues de notre cercle
			 * on aurait pu definir autrement la largeur de notre rectangle
			 * cela en remplaçant "this.getWidth()/a" par la position "STOP" de notre cercle +un entier "r" à chaque fois
			 * l'entier r devra être l'assurance que le cercle ne touchera pas la borne du rectangle
			 * cette technique devra être utiliser si l'on voudrai que le programme soit stable pour tout redimensionement de la fenêtre
			 * le rectangle est de la couleur de fond pour plus de lucidité
			 */
		     g.setColor(Color.white) ;
		      // la borne du rectangle [o, this.getwidth()/a] correspondant à la zone "d'arriver"
		     g.fillRect(0, 140, (int)(this.getWidth()/a), 20 ) ;
		
		     g.setColor(Color.black) ;
             g.fillOval(posX, 150, 7, 7) ;
		  }
		//depart de notre cercle rempli
		else{
			
			g.setColor(Color.white) ;
			// la borne est [this.getwith()/a , this.getWidth ] correspondant à la zone "de depart"
			g.fillRect((int)(this.getWidth()/a), 140, this.getWidth(), 20 ) ;
			
			g.setColor(Color.black) ;
	        g.fillOval(posX, 150, 7, 7) ;
		}
	}
	
// defintion des accesseurs aux champs privés
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setA(float a) {
		this.a = a;
	}

	public void setB(boolean b) {
		this.b = b;
	}
	


}

