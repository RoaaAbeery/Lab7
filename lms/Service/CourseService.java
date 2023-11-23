package com.example.lms.Service;

import com.example.lms.Model.Course;
import com.example.lms.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses =new ArrayList<>();
     public ArrayList<Course> getCourses(){
         return courses;
     }
     public void addCourses (Course course){
         courses.add(course);
     }
    public boolean updateCourse(String id, Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId().equals(id)){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(String id){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId().equals(id)){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean changeCourseN(String id,String courseName){
         for (Course course:courses){
             if(course.getCourseId().equals(id)){
                 course.setCourseName(courseName);
                 return true;
             }
         }
         return false;
    }
public boolean status(String id){
    for (Course course:courses){
        if(course.getCourseId().equals(id)){
            if (course.getCourseStatus().equals("Avalible"))
            return true;
        }
    }
    return false;
}

}
