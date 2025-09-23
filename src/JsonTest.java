import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonTest {
    public static void main(String[] args) throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader("src/input.json"));

        JSONObject j = (JSONObject) o;

        String impModel = (String) j.get("model");
        Long impNumOfPas =  (Long) j.get("numOfPas");
        Long impWeight =  (Long) j.get("weight");
        Long impTypeOptions =  (Long) j.get("typeOptions");
        Long impMaxSpeed =  (Long) j.get("maxSpeed");



        System.out.println(impModel);
        System.out.println(impNumOfPas);
        System.out.println(impWeight);
        System.out.println(impTypeOptions);
        System.out.println(impMaxSpeed);



    }
}