package CensusAnalyserProject.com.censusanalyser.java;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    static int counter = 0;

    public StateCensusAnalyser() {
    }

    public static int openCsvBuilder(String csvFilePath, Object myClass) throws CensusAnalyserException {
        Reader reader = null;
        CsvToBean<Object> csvToBean;
        try {
            reader = Files.newBufferedReader(Paths.get(csvFilePath));
            csvToBean = new CsvToBeanBuilder(reader).withType((Class) myClass).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<Object> myIterator = csvToBean.iterator();
            while (myIterator.hasNext()) {
                counter++;
                myIterator.next();
            }
        }
         catch (NoSuchFileException e) {
            throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE,
                    "no such file exists");
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE,
                    "some error related to headers or incorrect extension");
        } finally {
            return counter;

        }
    }
}