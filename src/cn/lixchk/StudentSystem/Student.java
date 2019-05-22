package cn.lixchk.StudentSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Student extends Person {
    private long studentId;
    private ArrayList<Course> courseList = new ArrayList<>();// 选修的课程列表



    public static final int UNKNOWN_STUDENT_ID = -1;


    public Student(String name, String gender, int age, long studentId) {
        super(name, gender, age);
        setStudentId(studentId);
    }


    public long getStudentId() {
        return studentId;
    }


    public void setStudentId(long studentId) {
        if (studentId > 2000000000 && studentId < 2100000000) {
            this.studentId = studentId;
        } else if (this.studentId > 2000000000 && this.studentId < 2100000000) {
            System.out.println("Invalid student ID! student ID don't Change");
        } else {
            this.studentId = UNKNOWN_STUDENT_ID;
        }
    }

    public boolean addCourse(Course course) {
        if (courseList.contains(course)) {
            return false;
        } else {
            courseList.add(course);
            course.addStudent(this);
            return true;
        }
    }

    /**
     *
     * @return cn.lixchk.StudentSystem.Course List (String)
     */
    public String[] getCourseList() {
        String[] courseListStr = new String[courseList.size()];
        for (int index = 0; index < courseList.size(); index++) {
            courseListStr[index] = courseList.get(index).getName();
        }
        return courseListStr;
    }

    public boolean dropCourse(String courseStr) {
        for (int index = 0; index < courseList.size(); index++) {
            if (courseList.get(index).getName().equals(courseStr)) {
                courseList.remove(index);
                return true;
            }
        }
        return false;
    }

    public String courseInformation(String courseName){
        Iterator<Course> ite = courseList.iterator();
        Course temp;
        while(ite.hasNext()) {
            if ((temp = ite.next()).getName().equals(courseName)) {
                return temp.toString();
            } else {
                return "No such course.";
            }
        }
            return "Null course list.";
    }

    public boolean dropCourse2(String courseName) {
        Iterator<Course> ite = courseList.iterator();
        Course temp;
        while (ite.hasNext()) {
            if ((temp = ite.next()).getName().equals(courseName)) {
                courseList.remove(temp);
                return true;
            }
        }
        return false;
    }
}
