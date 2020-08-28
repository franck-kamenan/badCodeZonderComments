package be.intecbrussel;

import be.intecbrussel.Board;
import be.intecbrussel.Timer;

import java.awt.event.*;

public class Controller
implements MouseListener
{private Timer t;
 private Board b;
    private View v;
   
  
    public Controller(Board board, View view, Timer timer)
    {
        b = board;
        v = view;
       v.addMouseListener (this);
      t = timer;
     b.turnChange();
    }
    
 public void mouseClicked (MouseEvent e) {
int x = e.getX()/60;
      int y = e.getY()/60;
      
     if(x<10&&y<10&&x>-1&&y>-1){
         
switch (t.theTime%2){
case 0:b.mustTake();
b.scan();
b.activate(x,y);

if(b.activated){

t.times();


}
        
        break;
case 1:b.scan();
b.move(x,y);
if(b.ready){
b.checkItOut();
t.times();
b.turnChange();

}

 
 break;
  default:
        
        
         System.out.println(t.theTime);
         break; 
}}
}





 
     public void mousePressed(MouseEvent e) {
      
    }

    public void mouseReleased(MouseEvent e) {v.repaint();
    
    }

    public void mouseEntered(MouseEvent e) {
      
    }

    public void mouseExited(MouseEvent e) {
       
    }
    public void mouseMoved(MouseEvent e){}
   
     public void mouseDragged(MouseEvent e){}
  



}




