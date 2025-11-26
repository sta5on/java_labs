import com.sun.jdi.connect.Transport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Functions {
    static String inString() {
        String str = "";
        BufferedReader box = new BufferedReader(new InputStreamReader(System.in));

        try {
            str = box.readLine();
        } catch (IOException e) {
        }
        return str;
    }

    static int inInt() {
        return (Integer.valueOf(inString())).intValue();
    }


    static double inDouble() {
        return (Double.valueOf(inString())).doubleValue();
    }


    static float inFloat() {
        return (Float.valueOf(inString())).floatValue();
    }

    public static boolean isInstanceOf(Object obj, Class<?> cls) {
        return cls.isInstance(obj);
    }

    public static void exportJson(String fileName, Unit u) {
        JSONObject j = new JSONObject();

        j.put("name", u.name);
        j.put("teamInt", u.teamInt);
        j.put("team", u.team);
        j.put("hp", u.hp);
        j.put("maxHp", u.maxHp);
        j.put("attackPower", u.attackPower);
        j.put("shootPower", u.shootPower);

        try (FileWriter fileWriter = new FileWriter("./exported-data/" + fileName + ".json")) {
            fileWriter.write(j.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
