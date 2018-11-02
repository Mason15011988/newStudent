package school.application.action;

import school.entity.Student;

import java.util.List;

public class AddMarksStudentAction extends BazeAction implements Action {
    private static final String NAME = "Добавление оценок ученику";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------" + NAME + "-------");
        int id = getInt("Введите id ученика, которому хотите добавить оценки");
        if (!controller.isStudent(id)) {
            System.out.println("!!! Ошибка--> Ученика с таким id нет");
        } else {
            Student student = new Student(id);
            List<Integer> marks = getListInteger("Введите оценки");
            controller.addMarksStudent(student,marks);
            boolean isAdded=controller.isStudent(id);
            System.out.println("-----Оценки добавлены-----");
        }
    }
}
