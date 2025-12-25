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
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.model.MatchAttemptRecord.Status;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(Long studentAId, Long studentBId) {

        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setStatus(Status.MATCHED);

        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }
    @Override
public MatchAttemptRecord getAttemptById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Match attempt not found"));
}


    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {

        MatchAttemptRecord record = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Match attempt not found"));

        record.setStatus(Status.valueOf(status.toUpperCase()));
        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}
