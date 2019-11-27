package edu.ucsb.cs56.ucsb_courses_search.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ucsb.cs56.ucsb_courses_search.entities.TimeSlot;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TimeSlotRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TimeSlotController {

    private Logger logger = LoggerFactory.getLogger(TimeSlotController.class);

    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public TimeSlotController(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @GetMapping("/timeSlots/create")
    public String create(TimeSlot timeSlot) {
        return "timeSlots/create";
    }

    @PostMapping("/timeSlots/add")
    public String addTimeSlot(@Valid TimeSlot timeSlot, BindingResult result, Model model) {
        // if (result.hasErrors()) {
        //     return "timeSlots/create";
        // }
        result.hasErrors();

        timeSlotRepository.save(timeSlot);
        model.addAttribute("timeSlots", timeSlotRepository.findAll());
        return "index";
    }

    @GetMapping("/timeSlots/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TimeSlot timeSlot = timeSlotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid time slot Id:" + id));
        model.addAttribute("timeSlot", timeSlot);
        return "timeSlots/update";
    }

    @PostMapping("/timeSlots/update/{id}")
    public String updateTimeSlot(@PathVariable("id") long id, @Valid TimeSlot timeSlot, BindingResult result, Model model) {
        if (result.hasErrors()) {
            timeSlot.setId(id);
            return "timeSlots/update";
        }

        timeSlotRepository.save(timeSlot);
        return "index";
    }

    @GetMapping("/timeSlots/delete/{id}")
    public String deleteTimeSlot(@PathVariable("id") long id, Model model) {
        TimeSlot timeSlot = timeSlotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid time slot Id:" + id));
        timeSlotRepository.delete(timeSlot);
        model.addAttribute("timeSlots", timeSlotRepository.findAll());
        return "index";
    }
}
