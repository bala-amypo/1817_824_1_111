package com.example.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.StudentProfileService;
import com.example.demo.repository.StudentProfileRepository;
import java.util.List;

@Service
public class StudentProfileServiceImplement implements StudentProfileService {
    @Autowired
    StudentProfileRepository rep;
    
    public StudentProfile createStudent(StudentProfile profile) {
        return rep.save(profile);
    }
    @Override
    public StudentProfile getStudentById(Long id) {
        return rep.findById(id).orElse(null);
    }
    public List<StudentProfile> getAllStudents() {
        return rep.findAll();
    }
    @Override
    public StudentProfile findByStudentId(String studentId) {
        return rep.findByStudentId(studentId);
    }
    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
    StudentProfile student = rep.findById(id).orElse(null);
    
    if (student == null) {
        return null; 
    }
    student.setActive(active);
    return rep.save(student);
}

}
