package school.application.search;

import school.entity.Student;

public class SearchStudentForId extends BazeSearch implements Search {
    private static final String NAME = "Поиск ученика по id";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------"+ NAME +"-------");
        int id = getInt("Введите id");
       Student student = controller.SearchStudentsForId(id);
        if (student==null) System.out.println("!!!нет ученика с таким id");
        else System.out.println(student);
    }
}
