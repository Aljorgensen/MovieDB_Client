package com.mycompany.moviedb;


public class MovieDB_client {

    public static void main(String[] args) {
    
        Logik lo = new Logik();
        MainGui maingui = new MainGui();
        ResultGui regui = new ResultGui();
        InfoGui ingui = new InfoGui();

        maingui.lg = lo;
        maingui.regui = regui;
        maingui.ingui = ingui;
        lo.mg = maingui;
        lo.rg = regui;
        lo.ig = ingui;
        regui.lg = lo;
        regui.maingui = maingui;
        regui.ig = ingui;
        ingui.lg = lo;
        ingui.regui = regui;
        
        GuiController gc = new GuiController();
        gc.lo = lo;
        maingui.ejer = gc;
        gc.maingui = maingui;
        regui.ejer = gc;
        gc.regui = regui;
        ingui.ejer = gc;
        gc.ingui = ingui;
        
        //lo.readTokenFromFile();
    }

}
