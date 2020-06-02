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
 * A panel that has a number. Value of number is set by the playfield class.
 * 
 * 
 * 
 * @author Zack Kirchens
 * @version 1.0
 * @since 2020-11-4
 */
public class NumberPanel extends panel{

    /**Up generation Blank Panel is represented as "#". isClicked is set to false
     * until user clicks on the panel and isClicked will be set to true. 
     * 
     */
    public NumberPanel(int value){
        this.Type=value+"";
        this.isClicked=false;
    }
    @Override
    public String getType() {
        return this.Type;
    }

    @Override
    public Boolean getClicked() {
        return this.isClicked;
    }

    @Override
    public String Activate() {
        this.isClicked=true;
        return this.getType();
    }
    
}
