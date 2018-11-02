package school.application.search;

import school.entity.Student;

public class SearchOldStudents extends BazeSearch implements Search {
    private static final String NAME = "Поиск самого(ых) взрослого(ых) ученика(ов)";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------"+ NAME +"-------");
         students = controller.SearchOldStudents();
        for (Student student:students){
            System.out.println(student);
        }

    }
}
