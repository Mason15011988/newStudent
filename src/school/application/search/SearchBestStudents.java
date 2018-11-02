package school.application.search;

import school.entity.Student;

public class SearchBestStudents extends BazeSearch implements Search {
    private static final String NAME = "Поиск самого(ых) умного(ых) ученика(ов)";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------"+ NAME +"-------");
        students = controller.SearchBestStudents();
        for (Student student:students){
            System.out.println(student + " средний балл " + student.sredneeMark());
        }
    }
}
