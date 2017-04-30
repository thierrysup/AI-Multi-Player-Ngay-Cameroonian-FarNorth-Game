/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class panelPlateau extends Panel{
    
    private final ImageIcon imgPlateau = new ImageIcon("src/ressources/images/ouisss.jpg");
    private final ImageIcon imgGrain = new ImageIcon("src/ressources/images/grain.png");
    
    private final int platX = 200;
    private final int platY = 100;
    
  
   
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgPlateau.getImage(), platX, platY, null);
        
        
     }
     
    
}
