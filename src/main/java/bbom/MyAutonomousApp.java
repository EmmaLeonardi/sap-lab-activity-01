package bbom;

public class MyAutonomousApp {

	private final ViewOutput viewOutput;
	private final AutonomousController controller;
	private final Model model;
	

	public MyAutonomousApp() {	
		//View
		this.viewOutput=new ViewOutput();
		//Controller
		this.controller=new AutonomousController();
		//Model
		this.model=new Model();
		//Connecting the components
		this.viewOutput.addController(this.controller);
		
	}

	public void startApp(){
		//Starts the GUI
		this.viewOutput.start();
		this.controller.addModel(this.model);
	}

    static public void main(String[] args) throws Exception {			  
    	var app = new MyAutonomousApp();
		app.startApp();
	}	
}
