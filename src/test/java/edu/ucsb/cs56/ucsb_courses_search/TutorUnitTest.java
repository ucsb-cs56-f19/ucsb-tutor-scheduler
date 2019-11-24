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
        assertThat(tutor.toString()).isEqualTo("Tutor{id=0, fname=Julie, lname=Smith, email=julie@domain.com}");
    }
}
