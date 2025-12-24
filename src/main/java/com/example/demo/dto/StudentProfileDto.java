package com.example.demo.dto;

public class StudentProfileDto {
    private String studentId;
    private String fullName;
    private String email;
    private String department;
    private Integer yearLevel;
    private boolean active;

    public StudentProfileDto() {}

    public StudentProfileDto(String studentId, String fullName,
                             String email, String department,
                             Integer yearLevel, boolean active) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.yearLevel = yearLevel;
        this.active = active;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Integer getYearLevel() { return yearLevel; }
    public void setYearLevel(Integer yearLevel) { this.yearLevel = yearLevel; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
