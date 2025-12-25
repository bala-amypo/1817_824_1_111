// package com.example.demo.service;

// import com.example.demo.model.StudentProfile;
// import java.util.List;
// public interface  StudentProfileService {
//      StudentProfile createStudent(StudentProfile profile);
//      StudentProfile  getStudentById(Long id);
//      List<StudentProfile> getAllStudents();
//      StudentProfile findByStudentId(String studentId);
//      StudentProfile updateStudentStatus(Long id,boolean active);


    
// }
package com.example.demo.service;

import com.example.demo.model.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile student);

    StudentProfile getStudentById(Long id);

    StudentProfile getStudentByStudentId(String studentId);

    List<StudentProfile> getAllStudents();

    StudentProfile updateStudentStatus(long id, boolean active); // ✅ required by testcases

    

    
}
