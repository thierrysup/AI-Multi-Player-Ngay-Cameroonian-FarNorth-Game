/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import static src.etud.iia.jeux.vue.PanelMenu.ac1;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class Button extends JButton implements MouseListener {

    private static final long serialVersionUID = 23L;
    private String name = "";
    private Sound sound;
    Font police = new Font("Ubuntu", Font.ITALIC, 16);
    Image img;

    public Button(String name) {
        super(name);
        this.name = name;
        sound = new Sound("src/ressources/songs/son2.WAV");
        
        try {
            img = ImageIO.read(new File("src/ressources/images/boutton2.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.

       // setHorizontalAlignment(SwingConstants.CENTER);
        //setHorizontalTextPosition(SwingConstants.CENTER);

        setIcon(new ImageIcon("src/ressources/images/boutton2.png"));
        setRolloverIcon(new ImageIcon("src/ressources/images/boutton2_2.png"));

        this.setPreferredSize(new Dimension(200, 60));
        this.addMouseListener(this) ;
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        //Objet qui permet de connaître les propriétés d'une police, dont la taille !
        FontMetrics fm = g.getFontMetrics();

        //Hauteur de la police d'écriture
        int height = fm.getHeight();
        //Largeur totale de la chaîne passée en paramètre
        int width = fm.stringWidth(this.name);

        g.setFont(police);
        g.setColor(Color.white);

        //On calcule donc la position du texte dans le bouton, et le tour est joué !
        g.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("je suis Clicker ...");
    }

   	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			   img = ImageIO.read(new File("src/ressources/images/boutton2_1.png")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			   img = ImageIO.read(new File("src/ressources/images/boutton2.png")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void mouseEntered(MouseEvent e) {
        try {
            img = ImageIO.read(new File("src/ressources/images/boutton2_2.png"));
            sound.play();
                
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			   img = ImageIO.read(new File("src/ressources/images/boutton2.png")) ;
                           sound.stop();
                             
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
