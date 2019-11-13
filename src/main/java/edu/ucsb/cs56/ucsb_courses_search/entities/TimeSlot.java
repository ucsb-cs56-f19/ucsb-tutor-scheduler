package edu.ucsb.cs56.ucsb_courses_search.entities;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Start time is mandatory (military time e.g. 06:00 or 18:00)")
    private LocalTime start_time;

    @NotBlank(message = "End time is mandtory (military time e.g. 06:00 or 18:00)")
    private LocalTime end_time;

    public TimeSlot() {
    }

    public TimeSlot(LocalTime start_time, LocalTime end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setStartTime(LocalTime start_time) {
        this.start_time = start_time;
    }

    public void setEndTime(LocalTime end_time) {
        this.end_time = end_time;
    }

    public LocalTime getStartTime() {
        return start_time;
    }

    public LocalTime getEndTime() {
        return end_time;
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "id=" + id + ", start_time=" + start_time + ", end_time=" + end_time + '}';
    }
}
