package bbom.interfaces;

/**A simple Model Interface */
public interface ModelInterface {

    /** 
     * Updates the status of the model
     */
    void update();

    /**
     * @return the status of the model
     */
    int getState();
    
}
