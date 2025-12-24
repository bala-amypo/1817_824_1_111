// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.repository.StudentProfileRepository;
// import com.example.demo.model.StudentProfile;
// import com.example.demo.service.StudentProfileService;
// import java.util.List;
// import com.example.demo.exception.ResourceNotFoundException;


// @Service

// public class StudentProfileServiceImpl
//         implements StudentProfileService {

//     private final StudentProfileRepository repo;

//     public StudentProfileServiceImpl(StudentProfileRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public StudentProfile createStudent(StudentProfile profile) {
//         repo.findByStudentId(profile.getStudentId())
//             .ifPresent(s -> {
//                 throw new ResourceNotFoundException("studentId exists");
//             });
//         return repo.save(profile);
//     }

//     @Override
//     public StudentProfile getStudentById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() ->
//                     new ResourceNotFoundException("not found"));
//     }

//     @Override
//     public List<StudentProfile> getAllStudents() {
//         return repo.findAll();
//     }

//     @Override
//     public StudentProfile findByStudentId(String studentId) {
//         return repo.findByStudentId(studentId)
//                 .orElseThrow(() ->
//                     new ResourceNotFoundException("not found"));
//     }

//     @Override
//     public StudentProfile updateStudentStatus(Long id, boolean active) {
//         StudentProfile student = repo.findById(id)
//                 .orElseThrow(() ->
//                     new ResourceNotFoundException("not found"));
//         student.setActive(active);
//         return repo.save(student);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile createStudent(StudentProfile s) {

        if (repo.findByStudentId(s.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("studentId exists");
        }

        if (repo.findByEmail(s.getEmail()).isPresent()) {
            throw new IllegalArgumentException("email exists");
        }

        return repo.save(s);
    }

    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = getStudentById(id);
        s.setActive(active);
        return repo.save(s);
    }

    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    public Optional<StudentProfile> findByStudentId(String sid) {
        return repo.findByStudentId(sid);
    }
}

