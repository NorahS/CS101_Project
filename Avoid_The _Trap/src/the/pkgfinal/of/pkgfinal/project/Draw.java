   /**
   * this class is a child of the Game Class, and it's responsible of all graphics decisions . 
   * it draws all the game states but it has some limitation due to poor performance of the JFrame functionalities
   * 
   */
package the.pkgfinal.of.pkgfinal.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Draw extends Game{
    
    
        //Set the color used 
        public static Color blue = new Color(67,112,163);
        public static Color crimson = new Color(204, 51, 145);
        
        public static double time;
        
        
               
        /*
        *paint3,draws the game state upon some og the game attributes
        *Args:Graphics board
        *Return:void
        */ 
         public static void paint3(Graphics board){
        //paint after inilaizin the boxes
        if(!Game.start){
              board.drawImage(HelperFunctions.start,0,21,blue,null);
              
        }
        else if (first){ 
         board.setColor(blue);
         board.fillRect(0,0,Width,Height);
         board.setColor(Color.WHITE);
         board.setFont( new Font("Arial", Font.BOLD, 12));
         // "graphing"/prints the names 
         board.drawString("© 2015 Norah Alsabti, Raghad Alduhayan, Ghada Al-Assaf And Nouf Altuwaijri. All Rights Reserved.", 40, 680);
   
        for( int i =0;i!=25;i++){

                board.drawImage(Boxes[i].img,Boxes[i].x1,Boxes[i].y1,blue,null);

                Boxes[i].img = HelperFunctions.img;  
        }
        first = false;
        started = true;
        on = true;
        HelperFunctions.delay1();
        chose2();
         Game.sTime =(int)System.currentTimeMillis();
         }
       
       //Paint if the game started
       else if(started){
         
           if(on){
           for( int i =0;i!=25;i++){
                board.drawImage(Boxes[i].chosen&&end && Boxes[i].img!=HelperFunctions.img3?HelperFunctions.img2:Boxes[i].img,Boxes[i].x1,Boxes[i].y1,(Boxes[i].tapped)?crimson:blue,null);
                 board.drawImage(HelperFunctions.reset,50,25,null,null);

               }
           }
           
           //when the game ends
           if(end){
   
             //announce wining
               if (Game.win){
 
                   board.drawImage(HelperFunctions.wining ,140,200,null,null);
                   int score = HelperFunctions.score(time);
                   board.setColor(blue);
                   board.setFont(new Font("default", Font.BOLD,16));
                   board.drawString(Integer.toString(score) +" Out of 5", 313,465);
                    HelperFunctions.delay(1);
                  
               }
               //announce loosing
               else if(!Game.win){
                    if(on){
                     for( int i =0;i!=25;i++){
                         if(!Boxes[i].pressed && Boxes[i].chosen && Boxes[i].tapped){
                             Boxes[i].img = HelperFunctions.wrong;
                         }else if(!Boxes[i].pressed &&Boxes[i].chosen){
                              Boxes[i].img = HelperFunctions.img2;
                         }
                board.drawImage(Boxes[i].img,Boxes[i].x1,Boxes[i].y1,(Boxes[i].tapped)?crimson:blue,null);
                
               } HelperFunctions.delay(2);
                        }
                    board.drawImage(HelperFunctions.losing ,140,200,null,null);
               }
                 on= false;
           }
           else{
             timer(board);
           }
       }
             
    }
         
                
        /*
        *timer,acts a game times
        *Args:Graphics board
        *Return:void
        */ 
         
         public static void timer(Graphics board){
              board.setColor(blue);
              board.fillRect(10,20,30,30);
              board.setColor(Color.WHITE);
       
              time = 15.0 - (((int)System.currentTimeMillis()-Game.sTime)/1000);
               
              if(time <=0){
                  Game.lost();
              }
               board.drawString(Double.toString(time), 10,40);
          }
         
    
}
