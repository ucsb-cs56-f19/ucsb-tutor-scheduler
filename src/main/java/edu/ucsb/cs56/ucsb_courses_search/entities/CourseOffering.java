package edu.ucsb.cs56.ucsb_courses_search.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course is mandatory (e.g. CMPSC 32)")
    private String course;

    @NotBlank(message = "Quarter is mandtory (e.g. F19)")
    private String quarter;

    @NotBlank(message = "Instructor is mandatory (e.g. Mirza)")
    private String instructor;

    @OneToMany(mappedBy = "courseOffering")
    private Set<TutorAssignment> tutorAssignments;

    public CourseOffering() {
    }

    public CourseOffering(String course, String quarter, String instructor) {
        this.course = course;
        this.quarter = quarter;
        this.instructor = instructor;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourse() {
        return course;
    }

    public String getQuarter() {
        return quarter;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "CourseOffering{" + "id=" + id + ", course=" + course + ", quarter=" + quarter + ", instructor="
                + instructor + '}';
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CourseOffering c2 = (CourseOffering) obj;
        if (id == null) {
            if (c2.id != null)
                return false;
        } else if (!(id.equals(c2.id)))
            return false;

        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
