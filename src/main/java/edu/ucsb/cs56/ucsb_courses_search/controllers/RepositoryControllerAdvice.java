package edu.ucsb.cs56.ucsb_courses_search.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.entities.CourseOffering;
import java.util.List;

@ControllerAdvice
public class RepositoryControllerAdvice {

    private final TutorRepository tutorRepository;
    private final CourseOfferingRepository courseOfferingRepository;

    @Autowired
    public RepositoryControllerAdvice(TutorRepository tutorRepository,
            CourseOfferingRepository courseOfferingRepository) {
        this.tutorRepository = tutorRepository;
        this.courseOfferingRepository = courseOfferingRepository;
    }

    @ModelAttribute("tutors")
    public Iterable<Tutor> getTutors() {
        return tutorRepository.findAll();
    }

    @ModelAttribute("courseOfferings")
    public Iterable<CourseOffering> getCourseOfferings() {
        return courseOfferingRepository.findAll();
    }
}