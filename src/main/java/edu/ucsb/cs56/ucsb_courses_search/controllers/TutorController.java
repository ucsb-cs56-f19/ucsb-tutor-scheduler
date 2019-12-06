package edu.ucsb.cs56.ucsb_courses_search.controllers;

import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TutorController {

    private Logger logger = LoggerFactory.getLogger(TutorController.class);

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @GetMapping("/tutors/create")
    public String create(Tutor tutor) {
        return "tutors/create";
    }

    @GetMapping("/tutors/tutorsPage")
    public String tutorsPage(Tutor tutor) {
        return "tutors/tutorsPage";
    }

    @GetMapping("/tutors/tutorsAssignmentPage")
    public String tutorAssignmentPage(Tutor tutor) {
        return "tutors/tutorsAssignmentPage";
    }

    @PostMapping("/tutors/add")
    public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tutors/create";
        }

        tutorRepository.save(tutor);
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }

    @GetMapping("/tutors/show/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + id));
        model.addAttribute("tutor", tutor);
        return "tutors/show";
    }

    @GetMapping("/tutors/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + id));
        model.addAttribute("tutor", tutor);
        return "tutors/update";
    }

    @PostMapping("/tutors/update/{id}")
    public String updateTutor(@PathVariable("id") long id, @Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            tutor.setId(id);
            return "tutors/update";
        }

        tutorRepository.save(tutor);
        return "index";
    }

    @GetMapping("/tutors/delete/{id}")
    public String deleteTutor(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + id));
        tutorRepository.delete(tutor);
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }
}
