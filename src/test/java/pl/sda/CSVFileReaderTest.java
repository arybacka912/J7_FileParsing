package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderTest {

    private static final String CSV_FILE_NAME = "persons.csv";

    @Test
    public void readPersonData() throws IOException {
        //given
        String filePath = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        CSVFileReader reader = new CSVFileReader();

        List<Person> expectedResult = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("Jan");
        person1.setLastName("Nowak");
        person1.setAge(50);

        Person person2 = new Person();
        person2.setName("Jan");
        person2.setLastName("Kowalski");
        person2.setAge(40);
        expectedResult.add(person1);
        expectedResult.add(person2);

        //when
        List<Person> result = reader.readPersonData(filePath);

        //then
        Assert.assertEquals(expectedResult, result);
    }
}