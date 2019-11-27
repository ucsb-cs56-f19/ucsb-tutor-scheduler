package edu.ucsb.cs56.ucsb_courses_search.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TimeSlotRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(TutorController.class);

    private final TutorRepository tutorRepository;
    private final CourseOfferingRepository courseOfferingRepository;
    private final TimeSlotRepository timeSlotRepository;


    @Autowired
    public HomeController(TutorRepository tutorRepository, CourseOfferingRepository courseOfferingRepository,
        TimeSlotRepository timeSlotRepository) {
        this.tutorRepository = tutorRepository;
        this.courseOfferingRepository = courseOfferingRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    //fish:generate course offerings,need course go to course page
    @GetMapping("/")
    public String home(Model model) {
        logger.info("Entering TutorController.home.  model=" + model.toString());
        // model.addAttribute("tutors", tutorRepository.findAll());
        // model.addAttribute("courseOfferings", courseOfferingRepository.findAll());
        logger.info("Exiting TutorController.home.  model=" + model.toString());
        return "index";
    }

}
