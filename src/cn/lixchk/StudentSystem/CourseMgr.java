package cn.lixchk.StudentSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class CourseMgr {
    ArrayList<Course> courses = new ArrayList<>();

    public CourseMgr() {
        addCourse("Java");
    }

    public boolean addCourse(Course course) {
        if (courses.contains(course)) {
            return false;
        } else {
            courses.add(course);
            return true;
        }
    }

    public boolean addCourse(String name) {
        if (searchByName(name)!=null) {
            return false;
        } else {
            courses.add(new Course(name));
            return true;
        }
    }


    /**
     * @param name of course
     * @return index of course
     */
    public Course searchByName(String name) {
        Iterator<Course> ite = courses.iterator();
        Course temp=null;
        while (ite.hasNext()) {
            if ((temp=ite.next()).getName().equals(name)) {
                return temp;
            }
        }
        return temp;
    }


    public void showClassByName(String courseName){
        Course course= searchByName(courseName);
        if(course==null){
            System.out.println("Can't find this course!");
        }
        else{
            course.showClass();
        }
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
