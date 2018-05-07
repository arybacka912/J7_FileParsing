package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Set;

public class JsonParsingTest {

    @Test
    public void jsonTest() {
        String json =
                "{" +
                "\"klucz1\" : {" +
                        "\"zagniezdzonyKlucz1\" : \"zagniezdzonaWartosc1\"," +
                        "\"zagniezdzonyKlucz2\" : \"zagniezdzonaWartosc2\"" +
                        "}," +
                "\"klucz2\" : \"wartość2\"" +
                "}";

        JSONObject jsonObject = new JSONObject(json);


        System.out.println(jsonObject.get("klucz1"));
        System.out.println(jsonObject.get("klucz2"));

        JSONObject nestedJsonObject = new JSONObject(jsonObject.get("klucz1").toString());
        System.out.println(nestedJsonObject.get("zagniezdzonyKlucz1"));
        System.out.println(nestedJsonObject.get("zagniezdzonyKlucz2"));
    }

    @Test
    public void jsonTest2() {
        String json = "{\"values\":[" +
                "{\"klucz\":\"wartosc1\"}," +
                "{\"klucz\":\"wartosc2\"}]}";

        JSONObject jsonObject = new JSONObject(json);

        JSONArray jsonArray = new JSONArray(jsonObject.get("values").toString());

        JSONObject jsonFromArray = new JSONObject(jsonArray.get(0).toString());
        System.out.println(jsonFromArray.get("klucz"));
    }


}
