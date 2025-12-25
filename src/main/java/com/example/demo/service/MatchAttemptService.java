// package com.example.demo.service;

// import com.example.demo.model.MatchAttemptRecord;
// import java.util.List;

// public interface MatchAttemptService {
//     MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt);
//     List<MatchAttemptRecord> getAttemptsByStudent(Long studentId);
//     MatchAttemptRecord updateAttemptStatus(Long attemptId, String status);
//     List<MatchAttemptRecord> getAllMatchAttempts();
// }
package com.example.demo.repository;

import com.example.demo.model.MatchAttemptRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchAttemptRecordRepository
        extends JpaRepository<MatchAttemptRecord, Long> {

    List<MatchAttemptRecord>
    findByInitiatorStudentIdOrCandidateStudentId(
            Long initiatorStudentId,
            Long candidateStudentId
    );
}
