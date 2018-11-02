package school.dao;

import school.entity.Student;
import school.entity.StudentWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentnsXmlDao implements StudentDAO {
    private File file = new File("students.xml");
    @Override
    public void addStudent(Student student) {
        List<Student> students = getStudents();
        students.add(student);
        save(students);
    }

    @Override
    public List<Student> getStudents() {
        try {
            JAXBContext context = JAXBContext.newInstance(StudentWrapper.class,Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StudentWrapper studentWrapper = (StudentWrapper) unmarshaller.unmarshal(file);
            return studentWrapper.getStudents();
        } catch (Exception e) {
            //log
            return new ArrayList<>();
        }
    }

    @Override
    public void removeStudent(Student student) {
        List<Student> students = getStudents();
        students.remove(student);
        save(students);
    }

    @Override
    public void addMarksStudent(Student student,List<Integer> marks) {
        List<Student> students = getStudents();
        int index = students.indexOf(student);
        students.get(index).addMarks(marks);
        save(students);
    }

    @Override
    public Student searcStudentForId(int id) {
        Student student = new Student(id);
        List<Student> students = getStudents();
        for (Student item:students){
            if (item.equals(student)){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Student> searcStudentsForAge(int age) {
        List<Student> students = getStudents();
        List<Student> studentsSearch = new ArrayList<>();
        for (Student student:students){
            if (student.getAge()== age){
                studentsSearch.add(student);
            }
        }
        return studentsSearch;
    }

    @Override
    public List<Student> searcStudentsForName(String name) {
        List<Student> students = getStudents();
        List<Student> studentsSearch = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                studentsSearch.add(student);
            }
        }
        return studentsSearch;
    }

    private void save(List<Student> students){
        StudentWrapper studentWrapper = new StudentWrapper(students);
        try {
            JAXBContext context = JAXBContext.newInstance(StudentWrapper.class,Student.class);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(studentWrapper,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
