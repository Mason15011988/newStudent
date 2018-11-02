package school.application.action;

import school.application.utils.UserInput;
import school.controllers.StudentsController;

import java.util.List;

public abstract class BazeAction {
    protected StudentsController controller = new StudentsController();

    protected int getInt(String message){
        System.out.println(message);
        return UserInput.getInt();
    }
    protected String getStr(String message){
        System.out.println(message);
        return UserInput.getStr();
    }
    protected List<Integer> getListInteger(String message){
        System.out.println(message);
        return UserInput.getListInteger();
    }
}
