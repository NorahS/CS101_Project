 /**
   * This class initialize the game board and gives each box it's own attribute
   */
package the.pkgfinal.of.pkgfinal.project;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Box {
    
    // id of the box
    public int id;
     public BufferedImage img =null;

    //the surounding box
     List<Integer> boundaries = new ArrayList<>();
     public int x1,x2,y1,y2;
    
    // indeactors of Box state 
   public boolean chosen,tapped,pressed;
    
   /* 
   * Constucter
   * Args:int id,  BufferedImage img , int x-coordinate , int y-coordinate
   **/ 
    public Box(int id,BufferedImage img,int x, int y){
        this.id = id;
        this.img = img;
        this.x1 =x;
        this.x2= x+123;
        this.y1 = y;
        this.y2=y+122;
        this.chosen=false;
        this.tapped=false;
        this.pressed = false;
        
       
        this.boundaries.add(this.id-1);
        this.boundaries.add(this.id+1);
        this.boundaries.add(this.id+5);
        this.boundaries.add(this.id-5);
       
        
         
    }
}
