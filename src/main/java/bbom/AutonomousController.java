package bbom;

import java.util.HashSet;
import java.util.Set;

import bbom.interfaces.ControllerInterface;
import bbom.interfaces.ModelInterface;
import bbom.interfaces.ViewInterface;

public class AutonomousController implements ControllerInterface{

    private ModelInterface model;
    private final Set<ViewInterface> views;
    private boolean start;

    public AutonomousController(){
        this.views=new HashSet<>();
        this.start=false;
    }

    public void onUpdate(){
        this.onUpdate(1);
    }

    @Override
    public void addModel(final ModelInterface model) {
        this.model=model;
        //As soon as a model is added, then the controller can start updating it
        this.start=true;
        new Thread(() -> {
            while (this.start) {
                try {
                    this.onUpdate(); //Updating the controller propagates the updates to both the model and the view(s)
                    Thread.sleep(1000); //Sleep for 1s
                } catch (InterruptedException e) {
                    this.start=false;
                }
            }
        }).run();
    }

    @Override
    public void registerCallback(final ViewInterface view) {
        //Adds the view to the set of views to update
        this.views.add(view);
    }

    @Override
    public void onUpdate(int value) {
        for(int i=0; i< value; i++){
            model.update();
        }
        var result=model.getState(); //New value 
        //Update all views registered in the set
        views.stream().forEach(elem->elem.controllerUpdate(result)); 
    }
    
}
