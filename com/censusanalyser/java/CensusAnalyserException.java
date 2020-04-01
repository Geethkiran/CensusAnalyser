package CensusAnalyserProject.com.censusanalyser.java;

public class CensusAnalyserException extends Exception {


    public enum CensusExceptionType {
        NO_SUCH_FILE,INCORRECT_DATA_ISSUE,DELIMITER_ISSUE;
    }
    public CensusExceptionType type;

    public CensusAnalyserException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}