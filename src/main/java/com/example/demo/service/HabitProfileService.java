// package com.example.demo.service;

// import com.example.demo.model.HabitProfile;
// import java.util.List;

// public interface HabitProfileService {
//     HabitProfile createOrUpdateHabit(HabitProfile habit);
//     HabitProfile getHabitByStudent(Long studentId);
//     HabitProfile getHabitById(Long id);
//     List<HabitProfile> getAllHabitProfiles();
// }
package com.example.demo.service;

import com.example.demo.model.HabitProfile;

public interface HabitProfileService {

    HabitProfile createHabitProfile(HabitProfile habitProfile);

    HabitProfile getHabitProfileByStudentId(Long studentId);
}
