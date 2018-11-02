package school.application.search;

import school.entity.Student;

public class SearchStudentsForName extends BazeSearch implements Search {
    private static final String NAME = "Поиск ученика(ов) по имени";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------"+ NAME +"-------");
        String name = getStr("Введите имя");
        students =controller.SearchStudentsForName(name);
        if (students.size()!=0) {
            for (Student student:students){
                System.out.println(student);
            }
        }else System.out.println("!!!нет ученика(ов) с таким именем");
    }
}
