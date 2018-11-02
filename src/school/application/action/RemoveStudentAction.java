package school.application.action;

import school.entity.Student;

public class RemoveStudentAction extends BazeAction implements Action {
    private static final String NAME = "Удаления  ученика";
    @Override
    public String getName() {

            return NAME;

    }

    @Override
    public void execute() {
        System.out.println("-------" + NAME + "-------");
        int id = getInt("Введите id ученика, которого хотите удалить");
        if (!controller.isStudent(id)) {
            System.out.println("!!! Ошибка--> Ученика с таким id нет");
        } else {
            Student student = new Student(id);
            controller.removeStudent(student);
            boolean isAdded=controller.isStudent(id);
            if(!isAdded){
                System.out.println("-----Ученик удален-----");
            }else{
                System.out.println("!!!!!Ошибка при удалении!!!!");
            }
        }
    }
}
