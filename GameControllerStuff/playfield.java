/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControllerStuff;

import Panels.BlankPanel;
import Panels.MinePanel;
import Panels.NumberPanel;
import Panels.panel;
import java.util.Random;

/**
 * <h1>Playfield.java</h1>
 * THis is the main class and will handle the generation of the Window, panels,
 * and gamecomplete handling. This class uses the abstract panel class and its
 * three subclasses to generate the board.
 *
 * @author Zaxev
 */
public class playfield {
   panel [][] minefield = new panel[10][10];
   boolean gameComplete;
   boolean playerDead;
   
   //Mutators-------------------------------------------------------------------
   public void Generate(){
       
       //Random variable to help randomly place mines
       Random random = new Random(); 
       
       //Sets gamecomplete to false at gamestart
       this.gameComplete=false;
       
       //Sets player to active status meaning player can continue playing
       this.playerDead=false;
       
       
        //Clear the board
        for(int y=0;y<10;y++){
            for(int x=0; x<10; x++){
                this.minefield[x][y]=new BlankPanel();
            }
        }
        
        
        //Add some mines using the random. After placing all the mines, it will
        //look at surrounding tiles and changer their statuses.
        for(int i = 0; i<10; i++){
           this.minefield[random.nextInt(10)][random.nextInt(10)]= new MinePanel();
        }
        for(int y=0;y<10;y++){
            for(int x=0; x<10; x++){
                if(this.minefield[x][y].getType().equals(" ")){
                    //Check surrounding tiles.
                    int value=0;
                    for(int yi=y-1;yi<=y+1;yi++){//Surrounding Y values
                        for(int xi=x-1;xi<=x+1;xi++){//Surounding X values
                            try{
                                //Each panel checks surrounding panels for mines.
                                //"value" is incremented by 1 for every mine around it.
                                if(this.minefield[xi][yi].getType().equals("*")){
                                    value+=1;
                                }
                            }catch(Exception e){
                                System.out.println("Value does not exist!");
                            }
                        }
                    }
                    if(value>0){
                        System.out.println("Creating a new number panel with value "+value);
                        this.minefield[x][y]=new NumberPanel(value);
                    }
                    
                }
            }
        }
   }
   
   /**
    * This method is used when the user clicks on a panel.The panel will go through 
    * if statements. If a player clicks on a panel with a mine then the program
    * will end. Otherwise it will keep going.
    * 
    * Game will check GameComplete after every userActivatedPanel.
    * 
    * @param x x-coordinate of the (x,y) position
    * @param y y-coordinate of the (x,y) position
    * @return 
    */
   public String ActivatePanel(int x, int y){
       //If the x or y aren't inside the minefield or the panel already is activated.
       if(this.minefield[x][y].getClicked()){
           return null;
       }
       String returnString=this.minefield[x][y].Activate();
       if(this.minefield[x][y].getType().equals("*")){
           this.playerDead=true;
       }
       this.gameComplete=this.checkGameComplete();
       return returnString;
   }
   
   /**
    * This method checks the entire board to ensure there are no mine.
    * Method will be checked until either all panels are revealed without 
    * any of the mines being clicked or if a mine is revealed.
    * 
    * @return Determines if the game is complete or not.
    */
   public boolean checkGameComplete(){
       for(int y=0;y<10;y++){
            for(int x=0; x<10; x++){
                if(!this.minefield[x][y].getType().equals(" ")&&!this.minefield[x][y].getType().equals("*")){
                    if(!this.minefield[x][y].getClicked()){
                        return false;
                    }
                }
            }
        }
       return true;
   }
   //Accessors------------------------------------------------------------------
   /**
    * 
    * @return 
    */
   public boolean getGameComplete(){
       return this.gameComplete;
   }
   /**
    * 
    * @return 
    */
   public boolean getPlayerDead(){
       return this.playerDead;
   }
}
