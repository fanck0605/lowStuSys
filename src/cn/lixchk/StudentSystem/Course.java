package cn.lixchk.StudentSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    private String name;
    private ArrayList<Student> classList = new ArrayList<>();

    Course(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (classList.contains(student)) {
            return false;
        } else {
            classList.add(student);
            student.addCourse(this);
            return true;
        }
    }

    public Student getStudent(int index) {
        return classList.get(index);
    }

    public boolean hasStudent(long ID) {
        Iterator<Student> ite = classList.iterator();
        while (ite.hasNext()) {
            if (ite.next().getStudentId() == ID) {
                return true;
            }
        }
        return false;
    }

    public Student searchByName(String studentName) {
        Iterator<Student> ite = classList.iterator();
        Student temp = null;
        while (ite.hasNext()) {
            if ((temp = ite.next()).getName().equals(studentName))
                return temp;
        }
        return temp;
    }

    public void showClass() {
        System.out.printf("%-12s%-12s%-10s-%-4s\n", "ID", "Name", "Gender", "Age");
        System.out.println();
        Iterator<Student> ite = classList.iterator();
        while (ite.hasNext()) {
            showStudent(ite.next());
        }
    }

    public void showStudent(Student student) {
        System.out.printf("%-12d%-12s%-10s%-4d\n",
                student.getStudentId(), student.getName(), student.getGender(), student.getAge());
    }

    public void showStudent(int index) {
        showStudent(classList.get(index));
    }

    public void showStudent(String name) {
        Student student;
        if ((student = searchByName(name)) != null) {
            showStudent(student);
        } else {
            System.out.println("Can't find this student!");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

