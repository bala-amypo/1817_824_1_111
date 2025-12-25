// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.MatchAttemptRecord;
// import com.example.demo.repository.CompatibilityScoreRecordRepository;
// import com.example.demo.repository.MatchAttemptRecordRepository;
// import com.example.demo.service.MatchAttemptService;

// @Service
// @Transactional
// public class MatchAttemptServiceImpl implements MatchAttemptService {

//     private final MatchAttemptRecordRepository attemptRepo;
//     private final CompatibilityScoreRecordRepository scoreRepo;

//     public MatchAttemptServiceImpl(
//             MatchAttemptRecordRepository attemptRepo,
//             CompatibilityScoreRecordRepository scoreRepo) {
//         this.attemptRepo = attemptRepo;
//         this.scoreRepo = scoreRepo;
//     }

//     @Override
//     public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
//         return attemptRepo.save(attempt);
//     }

//     @Override
//     public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
//         return attemptRepo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
//     }

//     @Override
//     public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
//         MatchAttemptRecord a = attemptRepo.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Match attempt not found"));

//         // ✅ Convert String to Enum
//         a.setStatus(MatchAttemptRecord.Status.valueOf(status.toUpperCase()));

//         return attemptRepo.save(a);
//     }

//     @Override
//     public List<MatchAttemptRecord> getAllMatchAttempts() {
//         return attemptRepo.findAll();
//     }
// }



// package com.example.demo.service.impl;

// import com.example.demo.model.MatchAttemptRecord;
// import com.example.demo.model.MatchAttemptRecord.Status;
// import com.example.demo.repository.MatchAttemptRecordRepository;
// import com.example.demo.service.MatchAttemptService;
// import jakarta.transaction.Transactional;
// import org.springframework.stereotype.Service;

// @Service
// @Transactional
// public class MatchAttemptServiceImpl implements MatchAttemptService {

//     private final MatchAttemptRecordRepository repository;

//     public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public MatchAttemptRecord logMatchAttempt(Long studentAId, Long studentBId) {

//         MatchAttemptRecord record = new MatchAttemptRecord();
//         record.setStudentAId(studentAId);
//         record.setStudentBId(studentBId);
//         record.setStatus(Status.MATCHED);

//         return repository.save(record);
//     }
// }package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setStatus("ASSIGNED");
        return repository.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord record = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
        record.setStatus(status.toUpperCase());
        return repository.save(record);
    }
}
