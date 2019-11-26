package edu.ucsb.cs56.ucsb_courses_search.controllers;

import edu.ucsb.cs56.ucsb_courses_search.entities.CSVToTutors;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.entities.TutorBean;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CSVUploadController {
    @Autowired
    TutorRepository tutorRepository;

    private Logger logger = LoggerFactory.getLogger(TutorController.class);

    @RequestMapping(path = "/tutorCSVUpload", method = RequestMethod.POST)
    public String uploadCSV(@RequestParam("file") MultipartFile file,
                            RedirectAttributes redirectAttributes) throws Exception {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "index";
        }
        try{
            List<Tutor> tutors = CSVToTutors.tutorBuilder(file);
            tutorRepository.saveAll(tutors);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
