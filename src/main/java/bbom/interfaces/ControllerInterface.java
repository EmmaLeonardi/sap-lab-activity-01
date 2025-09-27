package bbom.interfaces;

/**A simple Controller Interface**/
public interface ControllerInterface {

    /**
     * Connects the model to the controller
     * @param model the model connected to the view
     */
    public void addModel(final ModelInterface model);

    /**
     * Sets a set of views to update when the model updates
     * @param view
     */
    public void registerCallback(final ViewInterface view);

    /** 
     * A function called by the view to update the controller
     */
    public void onUpdate();

    /** 
     * A function called by the view to update the controller
     * @param value the value from the input view
     */
    public void onUpdate(final int value);
    
}
