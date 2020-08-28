package be.intecbrussel;

import java.awt.*;
import java.awt.event.*;

public class Checkers extends Frame
{
    protected Board m;
    protected View view;
    protected Controller c;
    protected Timer t;
    
     public Checkers()
    {
        m = new Board();
        t = new Timer();
        view = new View(m);
        add(view);
        
        c = new Controller(m, view,t);
        
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
               System.exit(0);
            }
        });
    
    }
    public static void main(String args[]) {
        Checkers window = new Checkers();
        window.setSize(800,800);
        window.setTitle("Damspel");
        window.setVisible(true);
}
}