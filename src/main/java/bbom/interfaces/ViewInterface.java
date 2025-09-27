package bbom.interfaces;


/**A simple View Interface**/
public interface ViewInterface {

    /***
     * Connects the controller to the view 
     * @param controller the controller connected to the view
     */
    public void addController(final ControllerInterface controller);

    /**
     * Starts the View
     */
    public void start();

    /**
     * Updates the view from the controller
     * @param value the value given from the controller
     */
    public void controllerUpdate(final int value);
    
}
