package cn.lixchk.StudentSystem;

import static cn.lixchk.StudentSystem.InputClass.*;

public class SchoolMgr {
    private CourseMgr courseMgr = new CourseMgr();
    private StudentMgr studentMgr = new StudentMgr();

    public SchoolMgr() {
    }

    public void addStudent() {
        System.out.println("Now enter the student's information.");
        System.out.println("Please input student's name:");
        String name = getString();

        System.out.println("Please input student's sex(ex. Male/Female/Special):");
        String gender = getString();

        System.out.println("Please input student's age:");
        int age = getInt();

        System.out.println("Please input student ID(ex. 2018144106):");
        long studentId = getLong();

        Student student = new Student(name, gender, age, studentId);

        System.out.print("Did he(she) join courses?(Yes or No)");
        String select = getString();
        if (select.toLowerCase().equals("yes") || select.charAt(0) == 'y') {
            System.out.println("Courses can be choose: ");
            for (String courseName : courseMgr.getCourses()) {
                System.out.println("\t" + courseName);
            }
            System.out.println("Now please enter the course's name!");
            String course = getString();
            Course temp;
            if ((temp = courseMgr.searchByName(course)) != null) {
                student.addCourse(temp);
            } else {
                System.out.println("Invalid course! Add fail!");
            }
        }
        if (studentMgr.addStudent(student)) {
            System.out.println("Add student success!");
        } else {
            System.out.println("Add student failed!");
        }
    }

    public void createCourse() {
        System.out.println("Please input the course's name:");
        String name = getString();
        if (courseMgr.addCourse(new Course(name))) {
            System.out.println("Create course success!");
        } else {
            System.out.println("Create course failed!");
        }
    }

    public void showStudents() {
        studentMgr.showStudents();
    }

    public void showStudentByCourse() {
        System.out.println("Courses can be choose: ");
        for (String courseName : courseMgr.getCourses()) {
            System.out.println("\t" + courseName);
        }
        System.out.println("Please enter the course name");
        String name = getString();
        courseMgr.showClassByName(name);
    }
}
