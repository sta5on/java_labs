//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Arrays;
//
//
//public class JsonTest {
//    public record TransportData(String model, int numOfPas, int weight, int typeOptions, int maxSpeed, int[] weightOfPas) {}
//
//    public static TransportData parseJson(String path) throws Exception {
//        JSONObject j = (JSONObject) new JSONParser().parse(new FileReader(path));
//
//        String model = (String) j.get("model");
//        int numOfPas = ((Long) j.get("numOfPas")).intValue();
//        int weight = ((Long) j.get("weight")).intValue();
//        int typeOptions = ((Long) j.get("typeOptions")).intValue();
//        int maxSpeed = ((Long) j.get("maxSpeed")).intValue();
//
//        JSONArray arr = (JSONArray) j.get("weightOfPas");
//        int[] weightOfPas = new int[arr.size()];
//        for (int i = 0; i < arr.size(); i++) {
//            weightOfPas[i] = ((Long) arr.get(i)).intValue();
//        }
//
//        return new TransportData(model, numOfPas, weight, typeOptions, maxSpeed, weightOfPas);
//    }
//    }
//
//    public static void main(String[] args) throws IOException, ParseException {
//        Object o = new JSONParser().parse(new FileReader("src/input.json"));
//
//        JSONObject j = (JSONObject) o;
//
//        String impModel = (String) j.get("model");
//        Integer impNumOfPas =  ((Long) j.get("numOfPas")).intValue();
//        Integer impWeight =  ((Long) j.get("weight")).intValue();
//        Integer impTypeOptions =  ((Long) j.get("typeOptions")).intValue();
//        Integer impMaxSpeed =  ((Long) j.get("maxSpeed")).intValue();
//        JSONArray weightArray = (JSONArray) j.get("weightOfPas");
//        long[] tempWeightOfPas = new long[weightArray.size()];
//        int[] impWeightOfPas = new int[weightArray.size()];
//
//        for (int i = 0; i < weightArray.size(); i++) {
//            impWeightOfPas[i] = ((Long) weightArray.get(i)).intValue();
//        }
//
//
//        System.out.println(impModel);
//        System.out.println(impNumOfPas);
//        System.out.println(impWeight);
//        System.out.println(impTypeOptions);
//        System.out.println(impMaxSpeed);
//        System.out.println(Arrays.toString(impWeightOfPas));
//    }
//}