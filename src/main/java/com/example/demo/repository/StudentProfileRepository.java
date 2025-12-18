package com.example.;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentProfile;

public interface HabitProfileRepository extends JpaRepository<StudentProfile, Long>{

}
