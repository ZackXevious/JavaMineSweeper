/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

/**
 * <h1>NumberPanel class</h1>
 * Extends panel.
 * Used by the playfield class.
 * 
 * A blank panel. The UI container uses this to active other panels nearby.
 * 
 * 
 * 
 * @author Zack Kirchens
 * @version 1.0
 * @since 2020-11-4
 */
public class BlankPanel extends panel{
    
    //Constructors--------------------------------------------------------------
    /**Up generation Blank Panel is represented as " ". isClicked is set to false
     * until user clicks on the panel and isClicked will be set to true. All connecting
     * blankPanels will have their isClicked set to true as well.
     * 
     */
    public BlankPanel(){
        this.Type=" ";
        this.isClicked=false;
    }
    
    //Accessors-----------------------------------------------------------------
    @Override
    public String getType() {
        return this.Type;
    }
    
    @Override
    public Boolean getClicked() {
        return this.isClicked;
    }
    
    //Mutators------------------------------------------------------------------
    @Override
    public String Activate() {
        this.isClicked=true;
        return this.getType();
    }
    
}
