package com.example.demo.service;

import com.example.demo.model.HabitProfile;

public interface HabitProfileService {

    HabitProfile createHabitProfile(HabitProfile habitProfile);

    HabitProfile getHabitProfileByStudentId(Long studentId);
}
