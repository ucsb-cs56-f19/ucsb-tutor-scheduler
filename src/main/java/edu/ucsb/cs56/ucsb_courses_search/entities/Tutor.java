package edu.ucsb.cs56.ucsb_courses_search.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "First Name is mandatory")
    private String fname;

    @NotBlank(message = "Last Name is mandatory")
    private String lname;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Level is mandatory")
    private String level;

    @OneToMany(mappedBy = "tutor")
    private Set<TutorAssignment> tutorAssignments;

    public Tutor() {
    }

    public Tutor(String fname, String lname, String email, String level) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.level = level;
    }

    public Tutor(TutorBean bean){
        this.fname = bean.getFname();
        this.lname = bean.getLname();
        this.email = bean.getEmail();
        this.level = bean.getLevel();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Set<TutorAssignment> getTutorAssignments() {
        return tutorAssignments;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Tutor{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", level=" + level + '}';
    }
}
