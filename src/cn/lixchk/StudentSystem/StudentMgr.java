package cn.lixchk.StudentSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentMgr {
    ArrayList<Student> students = new ArrayList<>();

    public StudentMgr() {
        addStudent("Chuck", "Male", 18, 2018144106);
    }

    public boolean addStudent(Student e) {
        if (students.contains(e)) {
            return false;
        } else {
            students.add(e);
            return true;
        }
    }

    public boolean addStudent(String name, String gender, int age, long studentId) {
        if (searchByStudentId(studentId) != null) {
            return false;
        } else {
            students.add(new Student(name, gender, age, studentId));
            return true;
        }
    }

    public Student searchByName(String n) {
        Iterator<Student> ite = students.iterator();
        Student temp = null;
        while (ite.hasNext()) {
            if ((temp = ite.next()).getName().equals(n))
                return temp;
        }
        return temp;
    }

    public Student searchByStudentId(long id) {
        Iterator<Student> ite = students.iterator();
        Student temp = null;
        while (ite.hasNext()) {
            if ((temp = ite.next()).getStudentId() == id)
                return temp;
        }
        return temp;
    }

    public void showStudents() {
        System.out.printf("%-12s%-12s%-10s-%-4s\n", "ID", "Name", "Gender", "Age");
        System.out.println();
        for (int index = 0; index < students.size(); index++) {
            showStudent(index);
        }
    }

    public void showStudent(Student student) {
        String[] courseList = student.getCourseList();
        System.out.printf("%-12d%-12s%-10s%-4d",
                student.getStudentId(), student.getName(), student.getGender(), student.getAge());
        for (int i = 0; i < courseList.length; i++) {
            System.out.printf("%-8s",courseList);
            if ((i + 1) % 3 == 0) {
                System.out.printf("\n%-35s", "");
            }
        }
    }

    public void showStudent(int index) {
        showStudent(students.get(index));
    }

    public void showStudent(String name) {
        Student student;
        if ((student = searchByName(name)) != null) {
            showStudent(student);
        } else {
            System.out.println("Can't find this student!");
        }
    }
}
