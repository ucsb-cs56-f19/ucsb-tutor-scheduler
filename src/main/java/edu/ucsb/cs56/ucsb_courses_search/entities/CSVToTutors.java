package edu.ucsb.cs56.ucsb_courses_search.entities;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CSVToTutors {
    public static List<Tutor> tutorBuilder(MultipartFile file) throws Exception {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("/Users/Tanay/tutorCSV.csv"));

            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(TutorBean.class);
            String[] memberFieldsToBindTo = {"id", "firstname", "lastname", "email", "level"};
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<TutorBean> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<TutorBean> csvTutorIterator = csvToBean.iterator();
            List<Tutor> tutors = new ArrayList<>();
            while(csvTutorIterator.hasNext()) {
                TutorBean tutorBean = csvTutorIterator.next();
                Tutor tutor = new Tutor(tutorBean);
                tutors.add(tutor);
            }
            return tutors;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
}