package bbom;

import java.util.HashSet;
import java.util.Set;

import bbom.interfaces.ControllerInterface;
import bbom.interfaces.ModelInterface;
import bbom.interfaces.ViewInterface;

public class Controller implements ControllerInterface{

    private ModelInterface model;
    private Set<ViewInterface> views;

    public Controller(){
        this.views=new HashSet<>();
    }

    public void onUpdate(){
        this.onUpdate(1);
    }

    @Override
    public void addModel(final ModelInterface model) {
        this.model=model;
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
