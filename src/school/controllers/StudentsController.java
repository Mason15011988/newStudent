package school.controllers;

import school.dao.StudentDAO;
import school.dao.StudentnsXmlDao;
import school.entity.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentsController {
    private static final String PATH ="students.txt";
    private StudentDAO dao = new StudentnsXmlDao();
    public void addStudent(Student student){
        dao.addStudent(student);
    }

    public boolean isStudent(int id){
        Student student = new Student(id);
        if (dao.isStudent(student))return true;
        return false;
    }

    public List<Student> getStudents(){
        List<Student> students = dao.getStudents();
        return students;
    }

    public void removeStudent(Student student){
        dao.removeStudent(student);
    }

    public void addMarksStudent(Student student,List<Integer> marks){
        dao.addMarksStudent(student,marks);
    }

    public Student SearchStudentsForId(int id){
       Student student = dao.searcStudentForId(id);
       return student;
    }

    public List<Student> SearchStudentsForName(String name) {
        List<Student> students = dao.searcStudentsForName(name);

        return students;
    }

    public List<Student> SearchStudentsForAge(int age){
        List<Student> students = dao.searcStudentsForAge(age);
        return students;
    }

    public List<Student> SearchOldStudents(){
        List<Student> students = dao.getStudents();
        List<Student> studentsSearch = new ArrayList<>();
        students.sort((o1, o2) -> o2.getAge()-o1.getAge());
        Student studentMax = students.get(0);
        for (Student student:students){
            if (studentMax.getAge()==student.getAge())studentsSearch.add(student);
        }
        return studentsSearch;
    }

    public List<Student> SearchBestStudents(){
        List<Student> students = dao.getStudents();
        List<Student> studentsSearch = new ArrayList<>();
        students.sort((o1, o2) ->  o2.sredneeMark() > o1.sredneeMark() ? 1 : -1);
        Student studentMax = students.get(0);
        for (Student student:students){
            if (studentMax.sredneeMark()==student.sredneeMark())studentsSearch.add(student);
        }
        return studentsSearch;
    }

    public void saveStudentsInFile(){
        List<Student> students = dao.getStudents();
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
