package the.pkgfinal.of.pkgfinal.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/*
 *This class is responsible of playing the game's sounds upon different events. 
 */


public class Sounds {

   // steps sound method is invoked in Mouse.mousePressed(MouseEvent e); 
   public  static void steps(){
      
        try{ 
          InputStream inStep = new FileInputStream(new File("Sounds/walk_crop_mp3cut.wav")); // import sound from file
          AudioStream audioStep = new AudioStream(inStep);
           AudioPlayer.player.start(audioStep); // start playing sound
            }catch(Exception e){ 
              System.out.println(e);
            }
   }
   
   //winning music method is invoked in Game.won(); 
   public static void win() {
       try { 
           InputStream win = new FileInputStream(new File("Sounds/Short_triumphal_fanfare.wav"));
           
           AudioStream audioWin = new AudioStream(win); 
           AudioPlayer.player.start(audioWin);}
           catch (Exception e) { 
               System.out.println(e); 
       }
   }
   
   //losing ping sound method is invoked in Game.lost();
   public static void lose() {
        try {
           InputStream lose = new FileInputStream(new File("Sounds/glass_ping-Go445.wav"));
           AudioStream audioLose = new AudioStream(lose);
           AudioPlayer.player.start(audioLose);}
           catch (Exception e) {
               System.out.println(e);
        }
    }

    
}
