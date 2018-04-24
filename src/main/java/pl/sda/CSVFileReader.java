package pl.sda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public List<Person> readPersonData(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] headers = null;
        String line;
        List<Person> persons = new ArrayList<>();

        int i = 0;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                Person parsedPerson = parseCSVRow(headers, line);
                persons.add(parsedPerson);
            }
        }
        return persons;
    }

    private Person parseCSVRow(String[] headers, String line) {
        Person person = new Person();
        String[] values = line.split(";");

        for (int i = 0; i < headers.length; i++) {
            setPersonFieldFromCSVFile(person, headers[i], values[i]);
        }
        return person;
    }

    private void setPersonFieldFromCSVFile(Person person, String header, String value) {
        if ("name".equals(header)) {
            person.setName(value);
        }
        if ("lastName".equals(header)) {
            person.setLastName(value);
        }
        if ("age".equals(header)) {
            person.setAge(Integer.parseInt(value));
        }
    }
}
