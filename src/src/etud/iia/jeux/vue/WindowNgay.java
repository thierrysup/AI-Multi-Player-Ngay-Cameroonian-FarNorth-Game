/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.etud.iia.jeux.vue;

import javax.swing.JFrame;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class WindowNgay extends JFrame{
    
    private final PanelMenu menu;
    
    
    public WindowNgay (){
        super();    
        menu = new PanelMenu(this);
        this.setTitle("Ngay Dev");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(menu);
    }
}
