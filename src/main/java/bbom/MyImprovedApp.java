package bbom;

public class MyImprovedApp {

	private final View view;
	private final ViewOutput viewOutput;
	private final StdinView viewStdin;
	private final Controller controller;
	private final Model model;
	

	public MyImprovedApp() {	
		//Views
		this.view=new View();
		this.viewOutput=new ViewOutput();
		this.viewStdin=new StdinView();
		//Controller
		this.controller=new Controller();
		//Model
		this.model=new Model();
		//Connecting the components
		this.viewOutput.addController(this.controller);
		this.view.addController(this.controller);
		this.viewStdin.addController(this.controller);
		this.controller.addModel(this.model);
		
	}

	public void startApp(){
		//Starts the GUIs
		this.view.start();
		this.viewOutput.start();
		this.viewStdin.start();
	}

    static public void main(String[] args) throws Exception {			  
    	var app = new MyImprovedApp();
		app.startApp();
	}	
}
