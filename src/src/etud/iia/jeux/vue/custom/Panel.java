/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.etud.iia.jeux.vue.custom;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class Panel extends JPanel{
    private static final long serialVersionUID = 1L;
    private ImageIcon background;
    
    public Panel(){
        super();
        this.background = new ImageIcon("src/ressources/images/backOriginal.jpg");
    }
    
    public void setBackground(ImageIcon background){
        this.background = background;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      //  g.drawImage(background.getImage(), 0, 0, this);
        g.drawImage(background.getImage(),0,0,800,600, this);
    }
}
