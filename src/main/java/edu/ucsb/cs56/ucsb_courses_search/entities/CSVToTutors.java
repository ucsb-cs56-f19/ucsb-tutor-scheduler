package edu.ucsb.cs56.ucsb_courses_search.entities;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.List;
import java.util.Iterator;

public class CSVToTutors {
    private static Logger logger = LoggerFactory.getLogger(CSVToTutors.class);

    public static List<TutorBean> tutorBuilder(String filename) throws Exception {
        logger.info("tutor csv builder started.");
        try {
                Reader reader = Files.newBufferedReader(Paths.get(filename));

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
            while(csvTutorIterator.hasNext()) {
                TutorBean tutor = csvTutorIterator.next();
                logger.info(tutor.getId() + " " + tutor.getFname() + " " + tutor.getLname() + " " + tutor.getEmail());
            }
            List<TutorBean> tutors = (List<TutorBean>) csvTutorIterator;
            return tutors;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
