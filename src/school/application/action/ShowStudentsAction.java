package school.application.action;

import school.entity.Student;

import java.util.List;

public class ShowStudentsAction extends BazeAction implements Action {
    private static final String NAME = "Получения списка учеников";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        List<Student> students = controller.getStudents();
        System.out.println("-------"+ NAME+"-------");
        for (Student student:students){
            System.out.println(student);
        }
    }
}
