import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader("src/input.json"));

        JSONObject j = (JSONObject) o;

        String Model = (String) j.get("model");



        System.out.println(Model);



    }
}