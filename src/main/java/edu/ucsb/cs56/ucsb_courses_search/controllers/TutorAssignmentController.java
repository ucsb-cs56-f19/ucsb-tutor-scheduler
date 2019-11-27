package edu.ucsb.cs56.ucsb_courses_search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucsb.cs56.ucsb_courses_search.entities.TutorAssignment;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.entities.CourseOffering;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorAssignmentRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.util.List;

@Controller
public class TutorAssignmentController {

  private Logger logger = LoggerFactory.getLogger(TutorAssignmentController.class);

  @Autowired
  private final TutorAssignmentRepository tutorAssignmentRepository;

  private final TutorRepository tutorRepository;
  private final CourseOfferingRepository courseOfferingRepository;

  @Autowired
  public TutorAssignmentController(TutorAssignmentRepository tutorAssignmentRepository, TutorRepository tutorRepository,
      CourseOfferingRepository courseOfferingRepository) {
    this.tutorAssignmentRepository = tutorAssignmentRepository;
    this.tutorRepository = tutorRepository;
    this.courseOfferingRepository = courseOfferingRepository;
  }

  @PostMapping("/tutorAssignments/add")
  public String add(@RequestParam(name = "cid") long cid, @RequestParam(name = "tid") long tid, Model model) {
    Tutor tutor = tutorRepository.findById(tid)
        .orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + tid));
    CourseOffering courseOffering = courseOfferingRepository.findById(cid)
        .orElseThrow(() -> new IllegalArgumentException("Invalid course offering Id:" + cid));
    TutorAssignment tutorAssignment = new TutorAssignment(tutor, courseOffering);
    tutorAssignmentRepository.save(tutorAssignment);
    model.addAttribute("tutorAssignments", tutorAssignmentRepository.findAll());
    return "index";
  }

  @GetMapping("/tutorAssignments/delete/{id}")
  public String delete(@PathVariable("id") long id, Model model) {
    TutorAssignment a = tutorAssignmentRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid tutor assignment Id:" + id));
    tutorAssignmentRepository.delete(a);
    return "index";
  }

  @GetMapping("/tutorAssignments/csv")
  public void downloadCSV(HttpServletResponse response) throws Exception {

    String filename = "tutorAssignment.csv";
    response.setContentType("text/csv");
    response.setHeader("Content-Disposition", "attachment; filename=" + filename);

    List<TutorAssignment> tutorAssign = (List<TutorAssignment>) tutorAssignmentRepository.findAll();

    // create Writer and write to csv file
    // For reference: http://opencsv.sourceforge.net/
    StatefulBeanToCsv<TutorAssignment> writer = new StatefulBeanToCsvBuilder<TutorAssignment>(response.getWriter())
          .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
          .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
          .withOrderedResults(false)
          .build();
    writer.write(tutorAssign);
  }
}