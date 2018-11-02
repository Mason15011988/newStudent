package school.dao;

import school.entity.Student;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);

    List<Student> getStudents();

    void removeStudent(Student student);

    default boolean isStudent(Student student){
        return getStudents().contains(student);
    }
    void addMarksStudent(Student student,List<Integer> marks);

    Student searcStudentForId(int id);

    List<Student> searcStudentsForAge(int age);

    List<Student> searcStudentsForName(String name);


}
