
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_assignments")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
private String roomNumber;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        COMPLETED
    }

    // -------- getters & setters --------
 public String getRoomNumber() {
        return roomNumber;
    }

    // ✅ THIS IS WHAT WAS MISSING
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
