package bbom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class View extends JFrame implements ActionListener{

    private Controller controller;

    public View() {		
		super("My App");
		
		setSize(300, 70);
		setResizable(false);
		
		var updateButton = new JButton("Update");
		updateButton.addActionListener(this);

		var panel = new JPanel();		
		panel.add(updateButton);		
		
		setLayout(new BorderLayout());
	    add(panel,BorderLayout.NORTH);
	    	    		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(-1);
			}
		});
        
	}

    public void start() throws InvocationTargetException, InterruptedException{
        SwingUtilities.invokeAndWait(() -> {
			this.setVisible(true);
		});
    }

    private static void log(String msg) {
		System.out.println("[Output] " + msg);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        var x=this.controller.onUpdate();
        log(x+"");
    }

    public void addController(final Controller controller) {
        this.controller=controller;
    }

    
    
}
