package cn.lixchk.StudentSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class CourseMgr {
    ArrayList<Course> courses = new ArrayList<>();

    public CourseMgr() {
        addCourse("Java");
    }

    public boolean addCourse(Course e) {
        if (searchByName(e.getName()) == null) {
            courses.add(e);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCourse(String name) {
        if (searchByName(name) == null) {
            courses.add(new Course(name));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param name of course
     * @return index of course
     */
    public Course searchByName(String name) {
        Iterator<Course> ite = courses.iterator();
        Course temp = null;
        while (ite.hasNext()) {
            if ((temp = ite.next()).getName().equals(name)) {
                return temp;
            }
        }
        return temp;
    }

    public boolean hasCourse(String name) {
        return searchByName(name) != null;
    }


    public void showClassByName(String courseName) {
        Course course;
        if ((course = searchByName(courseName)) == null) {
            System.out.println("Can't find this course!");
        } else {
            course.showClass();
        }
    }

    public String[] getCourses() {
        int courseSize = courses.size();
        String[] courseStr = new String[courseSize];
        for (int index = 0; index < courseSize; index++) {
            courseStr[index] = courses.get(index).getName();
        }
        return courseStr;
    }

    @Override
    public String toString() {
        Iterator<Course> ite = courses.iterator();
        String temp = null;
        if (ite.hasNext()) {
            temp = ite.next().getName();
        }
        while (ite.hasNext()) {
            temp = temp + " " + ite.next().getName();
        }
        return temp;
    }
}
