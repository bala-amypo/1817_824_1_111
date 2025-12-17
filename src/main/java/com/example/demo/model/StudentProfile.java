package com.example.demo.model
import jakarta.presistence.Entity
import jakarta.presistence.Id
import jakarta.presistence.GeneratedValue
import jakarta.presistence.GeneratedType
@Entity
public class StudentProfile{
    @Id
    @GeneratedValue(strategy =GeneratedType.Identity)
    private Long id;
    
    @column(unique=true)
    private String studentId;

    private String  fullName;

    @column(unique=true)
    private String email;

    private String department;
    
    private int yearLevel;

    
}