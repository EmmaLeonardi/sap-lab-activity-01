package bbom;

public class Controller {

    private Model model;

    public Controller(){

    }

    public int onUpdate(){
        model.update();
        return model.getState();

    }

    public void addModel(final Model model) {
        this.model=model;
    }
    
}
