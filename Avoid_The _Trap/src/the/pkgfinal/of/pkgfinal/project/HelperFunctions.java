package the.pkgfinal.of.pkgfinal.project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 This class provides some Timing and setup aids to the game
 */

public class HelperFunctions {

    public static BufferedImage img, img2, img3, reset, wining, losing, wrong, start;

    /* 
     *loadImages: load pictures needed in the game.
     *Args: none
     *Return: none 
     */
    public static void loadImages() {
        try {
            start =ImageIO.read(new File("imgs/Start.png"));
            img = ImageIO.read(new File("imgs/Drawing.png"));
            img2 = ImageIO.read(new File("imgs/Trapped.png"));
            img3 = ImageIO.read(new File("imgs/trace.png"));
            wrong = ImageIO.read(new File("imgs/Wrong.png"));
            wining = ImageIO.read(new File("imgs/FinalWin.png"));
            losing = ImageIO.read(new File("imgs/FinalLost.png"));
            reset = ImageIO.read(new File("imgs/Reset.png"));

        } catch (IOException e) {
            System.out.println("Images not found");
        }
    }

    /* 
     *delay1: delay tine for 3 secs 
     *Args: None
     *return: void
     */
    public static void delay1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /* 
     *delay: delay tine for n secs 
     *Args: int secends
     *return: void
     */

    public static void delay(int n) {
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    /* 
    *score: calculats the score 
    *Args: double time
    *Return: int score
    */

    public static int score(double time) {
        int score = (int) Math.ceil(time / 3.0);
        return score;
    }

}
