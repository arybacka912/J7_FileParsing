package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader {

    public List<Person> readPersonData(String filePath) throws IOException {
        List<Person> result = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);

        String rootKey = jsonObject.keySet().iterator().next();

        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValue : rawValues) {
            JSONObject value = new JSONObject(rawValue.toString());
            String name = value.get("name").toString();
            String lastName = value.get("lastName").toString();
            Integer age = Integer.parseInt(value.get("age").toString());

            Person person = new Person();
            person.setName(name);
            person.setLastName(lastName);
            person.setAge(age);

            result.add(person);
        }
        return result;
    }

}
