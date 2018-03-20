/*
 * This class is a muose listener . It listens for mouse cliking events
 * a child of the Java's MouseAdapter class
 */
package the.pkgfinal.of.pkgfinal.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mouse extends MouseAdapter {
    
          public static int startedfrom, last =-6;
            //fun1
            public void mousePressed(MouseEvent e){
            int mx = e.getX();
            int my = e.getY();
            
                if(!Game.start && mx >266 && mx<=285 && my >=550 && my< 588){
                   Main.newgame.start();
                   
                }
            //mouse events during the game
                else{
            for(int i =0 ; i !=25; i++){
                if( Game.Boxes[i].x1 < mx  && Game.Boxes[i].x2 > mx && Game.Boxes[i].y1 < my  && Game.Boxes[i].y2 > my ){
                      if ((i == Game.from || i == Game.to) && last ==-6){
                       Game.Boxes[i].tapped=true; 
                      Sounds.steps();
                       startedfrom =i;
                       last = i;
                      }
                
                    if(last!=-6 && !Game.end){

                        if(Game.Boxes[last].boundaries.contains(i)){
                              Game.Boxes[i].tapped=true; 
                               Sounds.steps();
                              last = i;
                              if(Game.Boxes[i].chosen && !Game.Boxes[i].pressed ){
                                  Game.win= false;
                              }
                              if ((i==Game.to || i== Game.from)&& startedfrom != i){
                               if(Game.win)
                                  Game.won();
                               else 
                                   Game.lost();
                              }
                        }
                    }
                    
                }
                }
            
            //resseting the game 
             if (mx >= 50 && mx <= 200 && my > 25 && my < 40) {

                Main.newgame.playAgain();
            }
            
             //mouse events after the game ends
            if(Game.end){
                    if(mx >=314 && mx<=340 && my >=410 &&my<=430 &&Game.win){
                    
                        Main.newgame.playAgain();
                }else if (mx >=310 && mx<=340 && my >=410 &&my<=440 &&!Game.win){
                       Main.newgame.playAgain();
                }
                else if (mx >=210 && mx<245 && my>422&& my<440 && !Game.win){
                        System.exit(0);
                }else if(mx >=230 && mx <=250 && my>411 && my <427 && Game.win)
                    System.exit(0);
            }
                }
          
}}
