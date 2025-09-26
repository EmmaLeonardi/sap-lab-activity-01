package bbom;

public class Model {

    private int state;

    public Model(){
        this.state=0;
    }

    public void update() {
        this.state++;
    }

    public int getState(){
        return this.state;
    }

}
