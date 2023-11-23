package com.example.lms.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "course Name should vot be null")
    @Size(min = 4,max = 10)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String courseName;
    @NotNull(message = "course Id should vot be null")
    private String courseId;
    @NotNull(message = "Course description should not be null")
    @Size(min = 15,message = "description Should be more than 15 ")
    private String courseDescription;
    @Pattern(regexp = "^(Avalible|NotAvalible)$")
    private String courseStatus;




}
