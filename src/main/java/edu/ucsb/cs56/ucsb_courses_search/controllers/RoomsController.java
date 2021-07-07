package edu.ucsb.cs56.ucsb_courses_search.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ucsb.cs56.ucsb_courses_search.entities.Rooms;
import edu.ucsb.cs56.ucsb_courses_search.repositories.RoomsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RoomsController {

    private Logger logger = LoggerFactory.getLogger(RoomsController.class);

    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsController(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }
    
    @GetMapping("/rooms/roomsPage")
    public String roomsPage(Rooms rooms) {
        return "rooms/roomsPage";
    }

    @GetMapping("/rooms/create")
    public String create(Rooms rooms) {
        return "rooms/create";
    }

    @PostMapping("/rooms/add")
    public String addRooms(@Valid Rooms rooms, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "rooms/create";
        }

        roomsRepository.save(rooms);
        model.addAttribute("rooms", roomsRepository.findAll());
        return "index";
    }

    @GetMapping("/rooms/show/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Rooms rooms = roomsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rooms Id:" + id));
        model.addAttribute("rooms", rooms);
        return "rooms/show";
    }

    @GetMapping("/rooms/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Rooms rooms = roomsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rooms Id:" + id));
        model.addAttribute("rooms", rooms);
        return "rooms/update";
    }

    @PostMapping("/rooms/update/{id}")
    public String updateRooms(@PathVariable("id") long id, @Valid Rooms rooms, BindingResult result, Model model) {
        if (result.hasErrors()) {
            rooms.setId(id);
            return "rooms/update";
        }

        roomsRepository.save(rooms);
        return "index";
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRooms(@PathVariable("id") long id, Model model) {
        Rooms rooms = roomsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rooms Id:" + id));
        roomsRepository.delete(rooms);
        model.addAttribute("rooms", roomsRepository.findAll());
        return "index";
    }
}
