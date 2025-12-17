package com.example.collectiondb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    private enum SleepSchedule{
        EARLY;
        REGULAR;
        LATE;
    }

    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private Level cleanlinessLevel;
   
    private enum Level{
        LOW;
        MEDIUM;
        HIGH;
    }

    @Enumerated(EnumType.STRING)
    private Level noiseTolerance;

    

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;
    
    public enum SocialPreference{
        INTROVERT;
        BALANCED;
    }

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public Integer getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(Integer studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }
    public Level getCleanlinessLevel() {
        return cleanlinessLevel;
    }
    public void setCleanlinessLevel(Level cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }
    public Level getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(Level noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }
    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public HabitProfile(Long id,Long studentId,Integer studyHoursPerDay,SleepSchedule sleepSchedule,Level cleanlinessLevel,Level noiseTolerance,SocialPreference socialPreference,LocalDateTime updatedAt){
        this.id=id;
        this.studentId=studentId;
        this.sleepSchedule=sleepSchedule;
        this.studyHoursPerDay=studyHoursPerDay;
        this.cleanlinessLevel=cleanlinessLevel;
        this.noiseTolerance=noiseTolerance;
        this.socialPreference=socialPreference;
        this.updatedAt=updatedAt;
    }
    public HabitProfile(){

    }

}
