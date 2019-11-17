package edu.ucsb.cs56.ucsb_courses_search.repositories;

import edu.ucsb.cs56.ucsb_courses_search.entities.Rooms;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends CrudRepository<Rooms, Long> {

}