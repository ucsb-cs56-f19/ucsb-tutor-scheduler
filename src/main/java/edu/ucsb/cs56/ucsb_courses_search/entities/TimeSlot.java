package edu.ucsb.cs56.ucsb_courses_search.entities;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Start time is mandatory (e.g. 06:00PM)")
    private String startTime;

    @NotBlank(message = "End time is mandatory (e.g. 06:00PM)")
    private String endTime;

    @NotBlank(message = "Quarter is mandatory (e.g. S19)")
    private String quarter;

    public TimeSlot() {
    }

    public TimeSlot(String startTime, String endTime, String quarter) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.quarter = quarter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getQuarter() {
        return quarter;
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", quarter=" + quarter + '}';
    }
}
