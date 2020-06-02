
package Panels;

/**
 * <h1>MinePanel class</h1>
 * Extends panel.
 * Used by the playfield class.
 * 
 * A panel that notates a mine. used by the playfield class.
 * 
 * 
 * 
 * @author Zack Kirchens
 * @version 1.0
 * @since 2020-11-4
 */
public class MinePanel extends panel{

    /**Up generation Blank Panel is represented as "*". isClicked is set to false
     * until user clicks on the panel. When user clicks on panel. PlayerDead status
     * is set to true.
     * 
     */
    public MinePanel(){
        this.Type="*";
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
