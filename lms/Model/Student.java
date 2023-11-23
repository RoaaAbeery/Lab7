package com.example.lms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "name should not be empty ")
    @Size(min = 4,max = 10 ,message = "name should ber mor than 4 and less than 10")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @NotNull(message = "id should not be empty ")
    @Size(min = 10,max = 10,message = "id length should be 10")
    private String id;
    @Pattern(regexp = "^(withdrawn|regular)$")
    private String status;
    @Email(message = "invalid email")
    private String email;
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format")
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateBrith;
    @Positive
    private int level;
    @NotNull(message = "password should not be null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$\n")
    private String password;
    @AssertFalse
    private boolean couresregis;
}
