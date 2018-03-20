/**
 * Avoid The Trap
 * 
 * Avoid The Trap is  a game for PC or Mac Copyright (c) 2015-2016 held jointly by the individual
 * authors.
 * 
 * Avoid The Trap was implemented as a CS101 course project at Prince Sultan University by Norah Alsabti, Raghad Alduhayan, Ghada Al-Assaf And Nouf Altuwaijri.
 * The game was inspired by one of Peak app games. http://www.peak.net/
 * Date:Fall 2015
 */
package the.pkgfinal.of.pkgfinal.project;




public class Main {

    public static Game newgame;
    
    public static void main(String[] args) {
        // Load images
        HelperFunctions.loadImages();
        
        //Start a new Game
        newgame = new Game();
        newgame.setVisible(true);
        newgame.initBoard();
        newgame.chose();

     
        
        while(true){
             newgame.repaint();
        }
    }

}
    
   
        
        
    
        

           
    

