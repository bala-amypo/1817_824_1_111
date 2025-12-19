package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompatibilityScoreServiceImpl
        implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepo,
            HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long id1, Long id2) {

        if (id1.equals(id2)) {
            throw new IllegalArgumentException("same student");
        }

        List<CompatibilityScoreRecord> existing =
                scoreRepo.findByStudentAIdOrStudentBId(id1, id1);

        for (CompatibilityScoreRecord r : existing) {
            if (
                (r.getStudentAId().equals(id1) && r.getStudentBId().equals(id2)) ||
                (r.getStudentAId().equals(id2) && r.getStudentBId().equals(id1))
            ) {
                return r;
            }
        }

        HabitProfile h1 = habitRepo.findByStudentId(id1)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));

        HabitProfile h2 = habitRepo.findByStudentId(id2)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));

        int score = Math.abs(h1.getStudyHours() - h2.getStudyHours());

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(id1);
        record.setStudentBId(id2);
        record.setScore(score);

        return scoreRepo.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
