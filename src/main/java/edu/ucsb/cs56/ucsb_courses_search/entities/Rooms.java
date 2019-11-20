package edu.ucsb.cs56.ucsb_courses_search.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Building Name is mandatory")
    private String buildingName;

    @NotBlank(message = "Room Number is mandatory")
    private int roomNumber;

    public Rooms() {
    }

    public Rooms(String buildingName, int roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setbuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setroomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getbuildingName() {
        return buildingName;
    }

    public int getroomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber + '}';
    }
}
