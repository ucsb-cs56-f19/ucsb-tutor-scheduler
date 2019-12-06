package edu.ucsb.cs56.ucsb_courses_search.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.RoomsRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TimeSlotRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorAssignmentRepository;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.entities.TutorAssignment;
import edu.ucsb.cs56.ucsb_courses_search.entities.CourseOffering;
import edu.ucsb.cs56.ucsb_courses_search.entities.Rooms;
import edu.ucsb.cs56.ucsb_courses_search.entities.TimeSlot;

import java.util.ArrayList;
import java.util.Collections;

@ControllerAdvice
public class RepositoryControllerAdvice {

    private final TutorRepository tutorRepository;
    private final CourseOfferingRepository courseOfferingRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final TutorAssignmentRepository tutorAssignmentRepository;
    private final RoomsRepository roomsRepository;

    
    @Autowired
    public RepositoryControllerAdvice(TutorRepository tutorRepository,
            CourseOfferingRepository courseOfferingRepository, TimeSlotRepository timeSlotRepository,
            TutorAssignmentRepository tutorAssignmentRepository, RoomsRepository
            roomsRepository) {
        this.tutorRepository = tutorRepository;
        this.courseOfferingRepository = courseOfferingRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.tutorAssignmentRepository = tutorAssignmentRepository;
        this.roomsRepository = roomsRepository;
    }

    @ModelAttribute("tutors")
    public Iterable<Tutor> getTutors() {
        return tutorRepository.findAll();
    }

    @ModelAttribute("courseOfferings")
    public Iterable<CourseOffering> getCourseOfferings() {
        return courseOfferingRepository.findAll();
    }

    @ModelAttribute("timeSlots")
    public Iterable<TimeSlot> getTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @ModelAttribute("tutorAssignments")
    public Iterable<TutorAssignment> getTutorAssignments() {
        ArrayList<TutorAssignment> sortedTAs = new ArrayList<>();
        for(TutorAssignment i : tutorAssignmentRepository.findAll()) {
            sortedTAs.add(i);
        }
        Collections.sort(sortedTAs);
        return sortedTAs;
    }

    @ModelAttribute("roomsModel")
    public Iterable<Rooms> getRoomsRepository() {
        return roomsRepository.findAll();
    }
}
