package school.application.sort;
import school.entity.Student;
import java.util.List;

public class SortedName extends BazeSort implements Sort {
    private static final String NAME = "Сортировка по имени";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        List<Student> students = controller.SortStudentsForName();
        System.out.println("-------" + NAME + "-------");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
