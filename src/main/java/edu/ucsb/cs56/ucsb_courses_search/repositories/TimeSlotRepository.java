package edu.ucsb.cs56.ucsb_courses_search.repositories;

import edu.ucsb.cs56.ucsb_courses_search.entities.TimeSlot;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {

   // List<TimeSlot> findByFname(String fname);

}
