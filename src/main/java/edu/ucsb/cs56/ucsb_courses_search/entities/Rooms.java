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
    private String bname;

    @NotBlank(message = "Room Number is mandatory")
    private int rnum;

    public Rooms() {
    }

    public Rooms(String bname, int rnum) {
        this.bname = bname;
        this.rnum = rnum;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public String getBname() {
        return bname;
    }

    public int getRnum() {
        return rnum;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", bname=" + bname + ", rnum=" + rnum + '}';
    }
}
