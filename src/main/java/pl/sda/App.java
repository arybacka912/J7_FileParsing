package pl.sda;

import java.io.IOException;
import java.util.List;

//POJO - Plain Old Java Object
public class App 
{
    public static void main( String[] args ) throws IOException {
//        CSVFileReader csvReader = new CSVFileReader();
//        JSONFileReader jsonReader = new JSONFileReader();
//
//        try {
//            List<Person> personList = csvReader.readPersonData("/home/michal/persons.csv");
//            for (Person person : personList) {
//                System.out.println(person.getName() + " " + person.getLastName() + " "+person.getAge());
//            }
//        } catch (IOException e) {
//            System.out.println("WYSTĄPIŁ BŁĄD");
//        }
//        CSVFileWriter writer = new CSVFileWriter();
//        writer.write("/home/michal/plik.txt");
        JSONFileReader jsonFileReader = new JSONFileReader();
        List<Person> persons = jsonFileReader.readPersonData("/home/michal/SDA/Java7/Projekty/J7_FileParsing/src/test/resources/persons.json");
        System.out.println(persons);
    }
}
