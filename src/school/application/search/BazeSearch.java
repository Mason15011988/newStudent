package school.application.search;

import school.application.utils.UserInput;
import school.controllers.StudentsController;
import school.entity.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class BazeSearch {
    protected StudentsController controller = new StudentsController();

    protected List<Student> students = new ArrayList<>();

    protected int getInt(String message){
        System.out.println(message);
        return UserInput.getInt();
    }
    protected String getStr(String message) {
        System.out.println(message);
        return UserInput.getStr();
    }
}
