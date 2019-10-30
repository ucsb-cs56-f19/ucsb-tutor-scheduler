package edu.ucsb.cs56.ucsb_courses_search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ucsb.cs56.ucsb_courses_search.Tutor;
;

@Repository
public class TutorSchedule {
  private List<Tutor> tutList;

  public TutorSchedule(){
    tutList = new ArrayList<>();
  }

  public List<Tutor> addNewTutor(String name, String email, String labHours){
    tutList.add(new Tutor(name, email, labHours));
    return tutList;
  }


  public List<Tutor> findAll(){
    return tutList;
  }

}
