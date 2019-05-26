package cn.lixchk.StudentSystem;

import static cn.lixchk.StudentSystem.InputClass.*;

public class StudentSystemConsole {
    public static void main(String[] args) {
        showAuthorInfo();//Show author information;
        SchoolMgr schoolMgr = new SchoolMgr();
        while (true) {
            menu();
            int selectNum = getInt();
            switch (selectNum) {
                case 1:
                    schoolMgr.addStudent();
                    break;
                case 2:
                    schoolMgr.createCourse();
                    break;
                case 3:
                    schoolMgr.showStudents();
                    break;
                case 4:
                    schoolMgr.showStudentByCourse();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!Please enter again!");
            }
        }
    }

    public static void menu() {
        System.out.println("1.Add a student");
        System.out.println("2.Create a course");
        System.out.println("3.Show all student");
        System.out.println("4.Show a class");
        System.out.println("5.Exit this console");

    }

    public static void showAuthorInfo() {
        System.out.println();
        System.out.println("Author     : ·¶³Éâý");
        System.out.println("Student ID : 2018144106");
        System.out.println("Class      : 18Èí¼þ1");
        System.out.println();
    }
}
