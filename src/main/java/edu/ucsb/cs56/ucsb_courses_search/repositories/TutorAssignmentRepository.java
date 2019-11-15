package edu.ucsb.cs56.ucsb_courses_search.repositories;

import edu.ucsb.cs56.ucsb_courses_search.entities.TutorAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorAssignmentRepository extends CrudRepository<TutorAssignment, Long> {

}