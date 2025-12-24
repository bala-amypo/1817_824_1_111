package com.example.demo.dto;

import java.time.LocalDateTime;

public class HabitProfileDto {

    private Long id;
    private Long studentId;

    private String sleepSchedule;
    private Integer studyHoursPerDay;
    private String cleanlinessLevel;
    private String noiseTolerance;
    private String socialPreference;

    private LocalDateTime updatedAt;

    public HabitProfileDto() {}

    public HabitProfileDto(Long id,
                           Long studentId,
                           String sleepSchedule,
                           Integer studyHoursPerDay,
                           String cleanlinessLevel,
                           String noiseTolerance,
                           String socialPreference,
                           LocalDateTime updatedAt) {
        this.id = id;
        this.studentId = studentId;
        this.sleepSchedule = sleepSchedule;
        this.studyHoursPerDay = studyHoursPerDay;
        this.cleanlinessLevel = cleanlinessLevel;
        this.noiseTolerance = noiseTolerance;
        this.socialPreference = socialPreference;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getSleepSchedule() { return sleepSchedule; }
    public void setSleepSchedule(String sleepSchedule) { this.sleepSchedule = sleepSchedule; }

    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(Integer studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }

    public String getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(String cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public String getNoiseTolerance() { return noiseTolerance; }
    public void setNoiseTolerance(String noiseTolerance) { this.noiseTolerance = noiseTolerance; }

    public String getSocialPreference() { return socialPreference; }
    public void setSocialPreference(String socialPreference) { this.socialPreference = socialPreference; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
