package Panels;

/**
 * <h1>Panel class</h1>
 * Extended by MinePanel, BlankPanel, and NumberPanel.
 * Used by the playfield class.
 * 
 * Framework for the entirety of the panel package.
 * 
 * 
 * 
 * @author Zack Kirchens
 * @version 1.0
 * @since 2020-22-3
 */
abstract public class panel {
    
    protected String Type; //The type of the panel
    protected Boolean isClicked; //If the panel is activated yet.
    
    
    /**
     * CONSTRUCTOR HANDLING INFORMATION:
     * 
     * This class is an abstract class. 
     * -Upon generation of the gameboard and all of its mines. All
     * "isClicked" booleans are set to false.
     * 
     * 
     * -Upon generation of mines all String "Type" is set to "*" signifying mines.
     * Numbers panels comes after the generation of mines and checkes the number of mines
     * around the panel. After that all other panels are set to blank.
     * 
     * Constructor methods are found within the sub classes named "BlankPanel.java"
     * "MinePanel.java" and "NumberPanel.java"
     * 
     */
    
    
    //Accessors-----------------------------------------------------------------
    /**
     * Returns the type of the panel.
     * @return Returns the value of type.
     */
    public abstract String getType();
    
    /**
     * Returns if the panel as has already been activated
     * @return Returns the value of isClicked
     */
    public abstract Boolean getClicked();
    
    
    //Mutators------------------------------------------------------------------
    /**
     * Activates the panel. Also sets the value of isClicked to true.
     * @return Returns a String (this is used by encapsulating classes)
     */
    public abstract String Activate();
}
