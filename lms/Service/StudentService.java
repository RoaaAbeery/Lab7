package com.example.lms.Service;

import com.example.lms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);

    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public boolean update(String id,Student student){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }
    public boolean delete (String id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Student> getStuid(String id){
        ArrayList<Student> newlist1=new ArrayList<>();
        for (Student student:students){
            if(student.getId().equals(id)){
                students.add(student);
                student.getId();
            }
        }
        return newlist1;
    }
    public boolean getCourse(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                if (student.getStatus().equals("regular")) {
                    student.setCouresregis(true);
                        return true;
                    }
                }
            }
        return false;
    }

}
