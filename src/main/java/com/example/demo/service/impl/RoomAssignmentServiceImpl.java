// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.RoomAssignmentRecord;
// import com.example.demo.repository.RoomAssignmentRecordRepository;
// import com.example.demo.service.RoomAssignmentService;

// @Service
// @Transactional
// public class RoomAssignmentServiceImpl implements RoomAssignmentService {

//     private final RoomAssignmentRecordRepository repo;

//     public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public RoomAssignmentRecord assignRoom(RoomAssignmentRecord record) {
//         return repo.save(record);
//     }

//     @Override
//     public RoomAssignmentRecord getAssignmentById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Room assignment not found"));
//     }

//     @Override
//     public List<RoomAssignmentRecord> getAssignmentsForStudent(Long studentId) {
//         return repo.findByStudentAIdOrStudentBId(studentId, studentId);
//     }

//     @Override
//     public List<RoomAssignmentRecord> getAllRoomAssignments() {
//         return repo.findAll();
//     }

//     @Override
//     public RoomAssignmentRecord updateRoomStatus(Long id, String status) {
//         RoomAssignmentRecord r = repo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Room assignment not found"));
//         r.setStatus(RoomAssignmentRecord.Status.valueOf(status.toUpperCase()));
//         return repo.save(r);
//     }
// }





// package com.example.demo.service.impl;

// import com.example.demo.model.RoomAssignmentRecord;
// import com.example.demo.model.RoomAssignmentRecord.Status;
// import com.example.demo.repository.RoomAssignmentRecordRepository;
// import com.example.demo.service.RoomAssignmentService;
// import jakarta.transaction.Transactional;
// import org.springframework.stereotype.Service;

// @Service
// @Transactional
// public class RoomAssignmentServiceImpl implements RoomAssignmentService {

//     private final RoomAssignmentRecordRepository repository;

//     public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId) {

//         RoomAssignmentRecord record = new RoomAssignmentRecord();
//         record.setStudentAId(studentAId);
//         record.setStudentBId(studentBId);
//         record.setStatus(Status.ACTIVE);

//         return repository.save(record);
//     }
// }
package com.example.demo.service.impl;

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

    // REQUIRED by testcases
    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    // ✅ BASIC VERSION
    @Override
    public RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setRoomNumber("ROOM-" + studentAId + "-" + studentBId);
        record.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repository.save(record);
    }

    // ✅ TESTCASE EXPECTS THIS
    @Override
    public RoomAssignmentRecord assignRoom(
            Long studentAId,
            Long studentBId,
            String roomNumber
    ) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setRoomNumber(roomNumber);
        record.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repository.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Room assignment not found"));
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
        RoomAssignmentRecord record = getAssignmentById(id);
        record.setStatus(
                RoomAssignmentRecord.Status.valueOf(status.toUpperCase())
        );
        return repository.save(record);
    }
}
