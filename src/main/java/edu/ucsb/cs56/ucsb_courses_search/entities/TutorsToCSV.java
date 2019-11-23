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
        String[] CSV_HEADER = {"id", "firstname", "lastname", "email"};
        try (
                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            csvWriter.writeNext(CSV_HEADER);

            for (Tutor tutor : tutors) {
                String[] data = {
                        tutor.getId().toString(),
                        tutor.getFname(),
                        tutor.getLname(),
                        tutor.getEmail()
                };

                csvWriter.writeNext(data);
            }

            System.out.println("Write CSV using CSVWriter successfully!");
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }
}
