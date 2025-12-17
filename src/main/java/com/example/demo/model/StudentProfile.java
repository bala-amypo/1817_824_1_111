package com.example.demo.model
import jakarta.presistence.Entity
import jakarta.presistence.Id
import jakarta.presistence.GeneratedValue
import jakarta.presistence.GeneratedType
@Entity
public class StudentProfile{
    @Id
    @GeneratedValue(star)
}