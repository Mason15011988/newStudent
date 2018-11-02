package school.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@XmlType(propOrder = {"id","name","age","marks"})
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private List<Integer> marks = new ArrayList<>();

    public Student(int id, String name, int age, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(){}
@XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getMarks() {
        return marks;
    }
@XmlElementWrapper
@XmlElement(name = "mark")
    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    public void addMarks(List<Integer> mark){
        marks.addAll(mark);
    }
    public double  sredneeMark( ){
        double sum = 0;
        for (int item:marks) {
            sum+=item;
        }
        return (double)sum / marks.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }



    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
