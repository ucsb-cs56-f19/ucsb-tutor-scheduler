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

    @OneToMany(mappedBy = "tutor")
    private Set<TutorAssignment> tutorAssignments;

    public Tutor() {
    }

    public Tutor(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
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

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Tutor{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }
}
