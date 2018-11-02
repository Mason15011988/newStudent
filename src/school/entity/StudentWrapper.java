package school.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "students")
public class StudentWrapper {
    private List<Student> students = new ArrayList<>();

    public StudentWrapper(List<Student> students) {
        this.students = students;
    }

    public StudentWrapper() {}

@XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
