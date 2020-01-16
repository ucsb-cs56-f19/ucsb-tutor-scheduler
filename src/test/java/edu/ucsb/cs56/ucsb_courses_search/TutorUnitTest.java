package edu.ucsb.cs56.ucsb_courses_search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;

public class TutorUnitTest {

    @Test
    public void whenCalledGetFName_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");

        assertThat(tutor.getFname()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledGetLName_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");

        assertThat(tutor.getLname()).isEqualTo("Smith");
    }

    @Test
    public void whenCalledGetEmail_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        assertThat(tutor.getEmail()).isEqualTo("julie@domain.com");
    }

    @Test
    public void whenCalledSetFname_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");

        tutor.setFname("John");

        assertThat(tutor.getFname()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetLname_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        tutor.setLname("Jones");
        assertThat(tutor.getLname()).isEqualTo("Jones");
    }

    @Test
    public void whenCalledSetEmail_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        tutor.setEmail("julie@otherdomain.com");
        assertThat(tutor.getEmail()).isEqualTo("julie@otherdomain.com");
    }

    @Test
    public void whenCalledtoString_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        assertThat(tutor.toString()).isEqualTo("Tutor{id=0, fname=Julie, lname=Smith, email=julie@domain.com, level=PAID}");
    }

    @Test
    public void whenCalledGetLevel_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "190J");
        tutor.setLevel("PAID");
        assertThat(tutor.getLevel()).isEqualTo("PAID");
    }

    @Test
    public void whenCalledGetId_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        tutor.setId(1);
        assertThat(tutor.getId()).isEqualTo(1);
    }

    @Test
    public void whenCalledGetTutorAssignments_thenCorrect(){
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");
        CourseOffering course = new CourseOffering("CS56", "W20", "Conrad");
        Set<TutorAssignment> ta = new Set<TutorAssignment>(new TutorAssignment(tutor, course));

        tutor.tutorAssignments = ta;
        assertThat(tutor.getTutorAssignments()).isEqualTo(ta);
    }

    
}
