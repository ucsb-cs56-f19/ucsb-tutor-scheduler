package edu.ucsb.cs56.ucsb_courses_search.entities;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class TutorsToCSV {
    public static void writeTutors(PrintWriter writer, List<Tutor> tutors) {
        writer.println("This is a test.");
        writer.println("If this were a real CSV, it would contain data from the cp object");
    }
}
