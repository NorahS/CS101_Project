   /*
   * this class provides all the game functionality. 
   * it's a child of the JFrame class.
   */
package the.pkgfinal.of.pkgfinal.project;


import java.awt.Graphics;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;



public class Game  extends JFrame  {
    
        //Sets all the Integer Attributes needed by the game 
      static int Height,Width,borders, marginTop,marginY, from, to, level=6;
      
      //Board:array of Boxs
      public static Box[] Boxes =new Box[25];
      
      
      static Random gen= new Random();
     
     //Sets all the Boolean Attrbuited needed by the game
      public static boolean end=false;
      static boolean first = false;
      static boolean started = false;
      static boolean win = true;
      static boolean on = false;
      static boolean start= false;
      
      //Timer
      public static int sTime;
      
 
    //constucter
        public Game(){
         borders=60;
         setSize(615+borders,623+borders);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         Height=this.getHeight();
         Width= this.getWidth();
         marginTop =23;
         marginY =2;
         
      
         //add  mouse listner
         addMouseListener(new Mouse());
         setFocusable(true);     
           
        }
        
        /*
        *initBoard: inilize each 25 box with id, img, and x-y coordenation to be drwon
        *Args: None
        *Return: void
        */
        public void initBoard(){
        for(int i=0,ind=0; i!=5;i++){
            for(int j=0; j!=5;j++){
                Boxes[ind] = new Box(ind,HelperFunctions.img,(Width-borders)/5*j+borders/2,(Height-marginTop-borders)/5*i+ borders/2+marginTop+marginY*i);
                Boxes[ind].chosen=false;
                Boxes[ind].tapped = false;
                Boxes[ind].pressed=false;
                ind++;    
                }
            }
        }
        
        
        
        /*
        *chose: randomly choose some boxs to ba a trap
        *Args: None
        *Return: void
        */
         public void chose(){
            int  randIndex ;
            for(int i=0;i!=level;i++){
             
             do{
                   randIndex=gen.nextInt(25);

               }while(Boxes[randIndex].chosen);
                              
            Boxes[randIndex].img = HelperFunctions.img2;
            Boxes[randIndex].chosen=true;
            }
            //start drwing
            first = true;
         }
         
         
        /*
        *chose2: randomly chooses 2 boxs as a start and end destnetion 
        *Args: None
        *Return:void
        */
         
         public static void chose2(){
             
            int randIndex ;
            do{
               randIndex=gen.nextInt(25);
             }while(Boxes[randIndex].chosen);
               
            Boxes[randIndex].img= HelperFunctions.img3;
            Boxes[randIndex].chosen=true;
            Boxes[randIndex].pressed=true;
            from=randIndex;
            
            do{
                randIndex=gen.nextInt(25);
               }while(Boxes[randIndex].chosen || from %5 == randIndex%5 ||from /5 == randIndex/5 );
               
            Boxes[randIndex].img= HelperFunctions.img3;
             Boxes[randIndex].chosen=true;
              Boxes[randIndex].pressed=true;
            to =randIndex;
             
             
         }
         
       /*
        *Won: end the game as a winner
        *Args: None
        *Return: void
        */
         public static void won(){
             end = true;
             Sounds.win();
         }
         
       /*
        *lost: end the game as a loser
        *Args: None
        *Return: void
        */
         public static void lost(){
          
             Game.win= false;
             Sounds.lose();
              end = true;
         }
         
         
        /*
        *paint: mange and draw the game graphics by a child class
        *Args: Graphics board
        *Return: void
        */ 
         public void paint(Graphics board){ 
        //paint after inilaizin the boxes
        Draw.paint3(board);
         }
         
   
        /*
        *playAgain: reset the game attrbuites to start again
        *Args: None
        *Return: void
        */ 
       public  void playAgain(){
               removeAll(); 
               this.initBoard();
               this.chose();
               end=false;
               started = false;
               on = false;
               win= true;
               end= false;
               Mouse.last =-6;
               
       }
         /*
        *start: starts the game
        *Args: None
        *Return: void
        */ 
       public void start(){
           start = true;
            removeAll(); 
       }
}
