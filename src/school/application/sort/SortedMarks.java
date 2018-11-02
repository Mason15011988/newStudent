package school.application.sort;

import school.entity.Student;

import java.util.List;

public class SortedMarks extends BazeSort implements Sort {
    private static final String NAME = "Сортировка по успеваемости";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        List<Student> students = controller.SortStudentsForMarks();
        System.out.println("-------" + NAME + "-------");
        for (Student student : students) {
            System.out.println(student + " средний балл " + student.sredneeMark());
        }
    }
}
