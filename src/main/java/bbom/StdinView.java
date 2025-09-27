package bbom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bbom.interfaces.ControllerInterface;
import bbom.interfaces.ViewInterface;

public class StdinView implements ViewInterface {

    private ControllerInterface controller;
    private final BufferedReader br;

    public StdinView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void addController(ControllerInterface controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        //Starts a new thread to listen to stdinput
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Enter a number to add to the current value:");
                    //Reads input line
                    final var value = Integer.parseInt(br.readLine());
                    if(value>0){
                         //Updates the controller
                        this.controller.onUpdate(value);
                    }else{
                        System.out.println("Number must be positive");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Must enter a valid number");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }).run();

    }

    @Override
    public void controllerUpdate(int value) {
        // This view is only for the command line input, so the controller won't update it
    }

}
