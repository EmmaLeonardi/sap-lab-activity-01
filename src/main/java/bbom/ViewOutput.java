package bbom;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import bbom.interfaces.ControllerInterface;
import bbom.interfaces.ViewInterface;

public class ViewOutput extends JFrame implements ViewInterface{

    private ControllerInterface controller;
    private final JLabel resultField;

    public ViewOutput() {		
		super("My Output App");
		
		setSize(300, 70);
		setResizable(false);
		
        //The output label
		this.resultField = new JLabel("Output: ");	
		
		setLayout(new BorderLayout());
	    add(this.resultField,BorderLayout.NORTH);
	    	    		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(-1);
			}
		});
        
	}

    public void start(){
        try {
            SwingUtilities.invokeAndWait(() -> {
                //Sets window as visible
            	this.setVisible(true);
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void addController(final ControllerInterface controller) {
        this.controller=controller;
        //This view is updated when the controller updates it
        this.controller.registerCallback(this);
    }

    @Override
    public void controllerUpdate(final int value) {
        //The value from the controller updates the output field
        this.resultField.setText("Output: "+ value);
    }


}