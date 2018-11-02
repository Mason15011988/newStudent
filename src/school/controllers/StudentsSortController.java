package school.controllers;

import school.dao.StudentDAO;
import school.dao.StudentnsXmlDao;
import school.entity.Student;

import java.util.List;

public class StudentsSortController {
    private StudentDAO dao = new StudentnsXmlDao();
    public List<Student> SortStudentsForName(){
        List<Student> students = dao.getStudents();
        students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return students;
    }
    public List<Student> SortStudentsForId(){
        List<Student> students = dao.getStudents();
        students.sort((o1, o2) -> o1.getId()-o2.getId());
        return students;
    }
    public List<Student> SortStudentsForAge(){
        List<Student> students = dao.getStudents();
        students.sort((o1, o2) -> o1.getAge()-o2.getAge());
        return students;
    }
    public List<Student> SortStudentsForMarks(){
        List<Student> students = dao.getStudents();
        students.sort((o1, o2) ->  o2.sredneeMark() > o1.sredneeMark()?1:-1);
        return students;
    }
}
