package edu.ucsb.cs56.ucsb_courses_search.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class TutorAssignment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "course_offering_id")
  CourseOffering courseOffering;

  @ManyToOne
  @JoinColumn(name = "tutor_id")
  Tutor tutor;

  public TutorAssignment() {
  }

  public TutorAssignment(Tutor tutor, CourseOffering courseOffering) {
    this.tutor = tutor;
    this.courseOffering = courseOffering;
  }

  public Tutor getTutor() {
    return tutor;
  }

  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }

  public CourseOffering getCourseOffering() {
    return courseOffering;
  }

  public void setCourseOffering(CourseOffering courseOffering) {
    this.courseOffering = courseOffering;
  }

  public Long getId() {
    return id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TutorAssignment other = (TutorAssignment) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
