package edu.ucsb.cs56.ucsb_courses_search.entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

public class TutorBean implements java.io.Serializable {
    @CsvBindByPosition(position = 0)
    private long id;

    @CsvBindByPosition(position = 1)
    private String fname;

    @CsvBindByPosition(position = 2)
    private String lname;

    @CsvBindByPosition(position = 3)
    private String email;

    @CsvBindByPosition(position = 4)
    private String level;

    public TutorBean() {
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
