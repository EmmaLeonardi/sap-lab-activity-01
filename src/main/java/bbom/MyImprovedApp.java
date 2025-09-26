package bbom;

import java.lang.reflect.InvocationTargetException;

public class MyImprovedApp {

	private final View view;
	private final Controller controller;
	private final Model model;
	

	public MyImprovedApp() {	
		this.view=new View();
		this.controller=new Controller();
		this.model=new Model();
		this.view.addController(this.controller);
		this.controller.addModel(this.model);
		
	}

	public void startApp() throws InvocationTargetException, InterruptedException{
		this.view.start();
	}

    static public void main(String[] args) throws Exception {			  
    	var app = new MyImprovedApp();
		app.startApp();
	}	
}
