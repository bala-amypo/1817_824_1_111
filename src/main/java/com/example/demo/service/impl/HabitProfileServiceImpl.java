// package com.example.demo.service.impl;

// import com.example.demo.model.HabitProfile;
// import com.example.demo.repository.HabitProfileRepository;
// import com.example.demo.service.HabitProfileService;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import java.util.List;

// @Service
// @Transactional
// public class HabitProfileServiceImpl implements HabitProfileService {

//     private final HabitProfileRepository repo;

//     public HabitProfileServiceImpl(HabitProfileRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public HabitProfile createOrUpdateHabit(HabitProfile habit) {
//         // Use the correct getter
//         Integer studyHours = habit.getStudyHoursPerDay();
//         if (studyHours == null || studyHours < 0 || studyHours > 24) {
//             throw new IllegalArgumentException("Study hours must be between 0 and 24");
//         }
//         return repo.save(habit);
//     }

//     @Override
//     public HabitProfile getHabitByStudent(Long studentId) {
//         return repo.findByStudentId(studentId)
//             .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
//     }

//     @Override
//     public HabitProfile getHabitById(Long id) {
//         return repo.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
//     }

//     @Override
//     public List<HabitProfile> getAllHabitProfiles() {
//         return repo.findAll();
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.model.HabitProfile;
// import com.example.demo.repository.HabitProfileRepository;
// import com.example.demo.service.HabitProfileService;
// import com.example.demo.exception.ResourceNotFoundException;
// import jakarta.transaction.Transactional;
// import org.springframework.stereotype.Service;

// @Service
// @Transactional
// public class HabitProfileServiceImpl implements HabitProfileService {

//     private final HabitProfileRepository repository;

//     public HabitProfileServiceImpl(HabitProfileRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public HabitProfile createHabitProfile(HabitProfile habitProfile) {
//         return repository.save(habitProfile);
//     }

//     @Override
//     public HabitProfile getHabitProfileByStudentId(Long studentId) {
//         return repository.findByStudentId(studentId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habitProfile) {
        return repository.save(habitProfile);
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}
