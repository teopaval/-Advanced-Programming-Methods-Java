package View;

import Controller.IMyController;

/**
 * Created by teo on 11/18/2016.
 */
public class RunCommand extends Command {
    private IMyController controller;
    public RunCommand(String key, String desc, IMyController ctr){
        super(key,desc);
        this.controller = ctr;
    }
    @Override
    public void execute(){
        controller.allStep();
    }
}
