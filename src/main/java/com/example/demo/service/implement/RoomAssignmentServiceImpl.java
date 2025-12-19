package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository roomRepo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(
            RoomAssignmentRecordRepository roomRepo,
            StudentProfileRepository studentRepo) {
        this.roomRepo = roomRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        StudentProfile s1 = studentRepo.findById(r.getStudentAId())
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
        StudentProfile s2 = studentRepo.findById(r.getStudentBId())
            .orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (!s1.isActive() || !s2.isActive()) {
            throw new IllegalArgumentException("both students must be active");
        }
        return roomRepo.save(r);
    }

    @Override
    public RoomAssignmentRecord updateRoomStatus(Long id, String status) {
        RoomAssignmentRecord r = roomRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
        r.setStatus(status);
        return roomRepo.save(r);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsForStudent(Long studentId) {
        return roomRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return roomRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAllRoomAssignments() {
        return roomRepo.findAll();
    }
}