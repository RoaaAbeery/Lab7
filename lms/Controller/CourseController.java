package com.example.lms.Controller;

import com.example.lms.Model.Course;
import com.example.lms.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api1/v1/course")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/getcourse")
    public ResponseEntity getcourse(){
        ArrayList<Course> c=new ArrayList<>();
      return   ResponseEntity.status(HttpStatus.OK).body(c);
    }
    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        courseService.addCourses(course);
       return ResponseEntity.status(HttpStatus.OK).body("course add");
    }
    @PutMapping("/updateCourse")
    public ResponseEntity updateCourse(@PathVariable String id,@Valid@RequestBody Course course,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = courseService.updateCourse(id,course);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("course update");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
    }
    @DeleteMapping("/deleteCourse")
    public ResponseEntity deleteCourse(@PathVariable String id){

        boolean isDelete = courseService.deleteCourse(id);
        if(isDelete){
            return ResponseEntity.status(HttpStatus.OK).body("course delete");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
    }
    @PutMapping("/changeCourseN")
    public ResponseEntity changeCourseN(@PathVariable String id,@RequestBody String courseName){
        boolean ischange=courseService.changeCourseN(id,courseName);
        if(ischange){
            return ResponseEntity.status(HttpStatus.OK).body("course name changed");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
    }
    @PutMapping("/status")
public ResponseEntity status(@PathVariable String id){

    boolean s = courseService.deleteCourse(id);
    if(s){
        return ResponseEntity.status(HttpStatus.OK).body("course Available");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("course NotAvailable or course not found");
}

}
