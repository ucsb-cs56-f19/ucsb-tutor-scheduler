package edu.ucsb.cs56.ucsb_courses_search.controllers;

import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.entities.TutorsToCSV;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CSVDownloadController {
    private static Logger logger = LoggerFactory.getLogger(CSVDownloadController.class);
    @Autowired
    TutorRepository tutorRepository;

    @GetMapping("/tutorCSVDownload")
    public void downloadCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=tutors.csv");
        List<Tutor> tutors =  (List<Tutor>) tutorRepository.findAll();

        TutorsToCSV.writeTutors(response.getWriter(), tutors);
    }
}
