package school.application.sort;

import school.entity.Student;

import java.util.List;

public class SortedId extends BazeSort implements Sort {
    private static final String NAME = "Сортировка по Id";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        List<Student> students = controller.SortStudentsForId();
        System.out.println("-------" + NAME + "-------");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
