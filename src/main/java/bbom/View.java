package bbom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import bbom.interfaces.ControllerInterface;
import bbom.interfaces.ViewInterface;

public class View extends JFrame implements ActionListener, ViewInterface{

    private ControllerInterface controller;

    public View() {		
		super("My Input App");
		
		setSize(300, 70);
		setResizable(false);
		
		//The input button
		var updateButton = new JButton("Update");
		updateButton.addActionListener(this);

		setLayout(new BorderLayout());
	    add(updateButton,BorderLayout.NORTH);
	    	    		
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
    public void actionPerformed(ActionEvent e) {
		//The button was clicked, update the controller
        this.controller.onUpdate();
    }

	@Override
    public void addController(final ControllerInterface controller) {
        this.controller=controller;
    }

	@Override
	public void controllerUpdate(final int value) {
		//This view is only for the input, so the controller won't update it
	}
    
}
