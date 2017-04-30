/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class PanelLog extends JPanel{
    private static final long serialVersionUID = 1L;
    private ImageIcon background;
    
    public PanelLog(){
        super();
        this.background = new ImageIcon("src/ressources/images/logo.jpg");
    }
    
    public void setBackground(ImageIcon background){
        this.background = background;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 107, 10, this);
    }
}
