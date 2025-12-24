package com.example.demo.service;

import com.example.demo.model.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile studentProfile);

    StudentProfile getStudentById(Long id);

    StudentProfile getStudentByStudentId(String studentId);

    List<StudentProfile> getAllStudents();
}
