package school.application.search;

import school.entity.Student;

public class SearchStudentsForAge extends BazeSearch implements Search {
    private static final String NAME = "Поиск ученика(ов) по возрасту";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------" + NAME + "-------");
        int age = getInt("Введите возраст");
        students = controller.SearchStudentsForAge(age);
        if (students.size()!=0) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else System.out.println("!!!нет ученика(ов) с таким возрастом");
    }
}
