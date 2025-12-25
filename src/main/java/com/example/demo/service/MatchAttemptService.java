// package com.example.demo.service;

// import com.example.demo.model.MatchAttemptRecord;
// import java.util.List;

// public interface MatchAttemptService {
//     MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt);
//     List<MatchAttemptRecord> getAttemptsByStudent(Long studentId);
//     MatchAttemptRecord updateAttemptStatus(Long attemptId, String status);
//     List<MatchAttemptRecord> getAllMatchAttempts();
// }
package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;

import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId);

    RoomAssignmentRecord getAssignmentById(Long id);

    List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId);

    List<RoomAssignmentRecord> getAllAssignments();

    RoomAssignmentRecord updateStatus(Long id, String status);
}
