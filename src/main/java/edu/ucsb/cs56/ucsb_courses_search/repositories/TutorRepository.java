package edu.ucsb.cs56.ucsb_courses_search.repositories;

import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends CrudRepository<Tutor, Long> {

   // List<Tutor> findByFname(String fname);

}
