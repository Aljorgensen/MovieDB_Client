package com.mycompany.moviedb;


import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author andersjorgensen
 */
public class GuiController {
    
    
    JFrame vindue = new JFrame("MovieDB");
    Logik lo;
    MainGui maingui;
    ResultGui regui;
    InfoGui ingui;
    
    public GuiController(){
        Startgui start = new Startgui();
        
        start.ejer = this;
        
        vindue.add(start);
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vindue.pack();
        vindue.setLocationRelativeTo(null);
        vindue.setVisible(true);
    }
    
    public void skift(JPanel jf){
        vindue.getContentPane().removeAll();
        vindue.getContentPane().add(jf);
        vindue.pack();
        vindue.setVisible(true);
    }
}
