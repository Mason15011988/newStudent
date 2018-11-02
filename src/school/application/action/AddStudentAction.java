package school.application.action;

import school.entity.Student;

import java.util.List;

public class AddStudentAction extends BazeAction implements Action  {
    private static final String NAME = "Добавление ученика";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        System.out.println("-------"+ NAME +"-------");
        int id = getInt("Введите id");
        if (controller.isStudent(id)){
            System.out.println("!!! Ошибка--> Ученик с таким id уже есть");
        }else{
            String name = getStr("Введите имя");
            int age = getInt("Введите возраст");
            List<Integer> marks = getListInteger("Введите оценки");
            Student student = new Student(id,name,age,marks);
            controller.addStudent(student);
            boolean isAdded=controller.isStudent(id);
            if(isAdded){
                System.out.println("-----Ученик добавлен-----");
            }else{
                System.out.println("!!!!!Ошибка при добавлении!!!!");
            }
        }
    }
}
