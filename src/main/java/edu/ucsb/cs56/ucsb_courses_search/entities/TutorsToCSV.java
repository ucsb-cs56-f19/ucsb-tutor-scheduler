package edu.ucsb.cs56.ucsb_courses_search.entities;

import com.opencsv.CSVWriter;

import java.io.PrintWriter;
import java.util.List;

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
            csvWriter.close();
            System.out.println("Write CSV using CSVWriter successfully!");
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }
}
