package com.example.lms.Controller;

import com.example.lms.Model.Student;
import com.example.lms.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api1/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/geStudents")
    public ResponseEntity geStudents (){
       ArrayList<Student> s= studentService.getStudents();
       return ResponseEntity.status(HttpStatus.OK).body(s);
    }
    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@Valid@RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student add");

    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @Valid@RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdated=studentService.update(id,student);
        if (isupdated){
            ResponseEntity.status(HttpStatus.OK).body("Student updated");
        }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
    @DeleteMapping("/deleteStudent{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
      boolean isdeleted= studentService.delete(id);
      if(isdeleted){
         return ResponseEntity.status(HttpStatus.OK).body("Student deleted");

      }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
    @GetMapping("/getId/{id}")
    public ResponseEntity getPosition(@PathVariable String id){
        ArrayList<Student> s=studentService.getStuid(id);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }
@PostMapping("/courseRegis/{id}")
    public ResponseEntity getCourse(@PathVariable String id){
       boolean isregist= studentService.getCourse(id);
       if(isregist){
           return ResponseEntity.status(HttpStatus.OK).body("user register");
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");

    }

}

