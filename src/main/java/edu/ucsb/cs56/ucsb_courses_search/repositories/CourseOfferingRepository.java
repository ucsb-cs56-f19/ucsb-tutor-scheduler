package edu.ucsb.cs56.ucsb_courses_search.repositories;

import edu.ucsb.cs56.ucsb_courses_search.entities.CourseOffering;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends CrudRepository<CourseOffering, Long> {
      // List<CourseOffering> findByQuarter(String quarter);
}
