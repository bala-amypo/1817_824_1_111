package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHours() < 0 || habit.getStudyHours() > 24) {
            throw new IllegalArgumentException("study hours");
        }
        return repo.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repo.findByStudentId(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}