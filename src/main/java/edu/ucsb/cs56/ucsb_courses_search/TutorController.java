package edu.ucsb.cs56.ucsb_courses_search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.ucsb.cs56.ucsb_courses_search.TutorSchedule;
import edu.ucsb.cs56.ucsb_courses_search.Tutor;

@Controller
public class TutorController {

 @Autowired
 private TutorSchedule tutorSchedule;

 @RequestMapping(value = "/tutorList", method = RequestMethod.GET)
 public String getTutorList(Model model) {
  List<Tutor> tutList = tutorSchedule.findAll();
  model.addAttribute("tutList", tutList);
  return "fragments/tutorlist";
 }

 @RequestMapping(value = "/addTutor", method = RequestMethod.GET)
 public String createNewTutor(Model model) {
   model.addAttribute("tutor", new Tutor());
   return "fragments/newtutorform";
 }

 @RequestMapping(value = "/tutorList", method = RequestMethod.POST)
 public String tutorSubmit(@ModelAttribute Tutor tutor, Model model) {
    List<Tutor> tutList = tutorSchedule.addNewTutor(tutor.getName(), tutor.getEmail(), tutor.getLabHours());
    model.addAttribute("tutList", tutList);
    return "fragments/tutorlist";
 }

}
