package pl.sda;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CSVFileReaderTest {

    private static final String CSV_FILE_NAME = "persons.csv";

    @Test
    public void readPersonData() throws IOException {
        //given
        String filePath = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        CSVFileReader reader = new CSVFileReader();

        //when
        List<Person> result = reader.readPersonData(filePath);

        //then
    }
}