package bbom;

import bbom.interfaces.ModelInterface;

public class Model implements ModelInterface {

    private int state;

    public Model(){
        //State starts from 0 and is incremented each update
        this.state=0;
    }

    public void update() {
        this.state++;
    }

    public int getState(){
        return this.state;
    }

}
