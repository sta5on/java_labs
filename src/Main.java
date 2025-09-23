import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Random;
import java.util.Vector;

class Transport {
    int id = numOfTrans;
    int numOfPas;
    int[] weightOfPas;
    int weight;
    static int numOfTrans = 0;
    String model;
    String typeOf;
    int typeOption;
    String[] typeOptions = {"car", "autobus", "plane"};
    int maxSpeed;

    final static int maxWeight = 150;

    //' '(java.lang.String, int, int, int, int, int[])'
    // return new TransportData(model, numOfPas, weight, typeOptions, maxSpeed, weightOfPas);
    public Transport(String model, int numOfPas, int weight, int typeOption, int maxSpeed, int[] weightOfPas) {
        this.model = model;
        this.numOfPas = numOfPas;
        this.weight = weight;
        this.typeOf = typeOptions[typeOption];
        this.typeOption = typeOption;
        this.maxSpeed = maxSpeed;
        this.weightOfPas = weightOfPas;
    }

    public Transport() {
        this.model = "tesla";
        this.typeOption = 0;
        this.typeOf = typeOptions[typeOption];
        numOfTrans++;
        this.id = numOfTrans;
        this.numOfPas = 0;
        this.weightOfPas = new int[0];
    }

    public Transport(Transport other) {
        this.model = other.model;
        this.typeOf = other.typeOf;
        this.typeOption = other.typeOption;
        this.numOfPas = other.numOfPas;
        this.weight = other.weight;
        this.maxSpeed = other.maxSpeed;
        this.weightOfPas = new int[this.numOfPas];
        for (int i = 0; i < this.numOfPas; i++) {
            this.weightOfPas[i] = other.weightOfPas[i];
        }
        numOfTrans++;
        this.id = numOfTrans;
    }

    public Transport(String model, int typeOption, int maxSpeed) {
        this.model = model;
        if (typeOption >= 0 && typeOption < typeOptions.length) {
            this.typeOf = typeOptions[typeOption];
            this.typeOption = typeOption;
        } else {
            this.typeOf = typeOptions[0];
            this.typeOption = 0;
        }
        this.maxSpeed = maxSpeed;
        numOfTrans++;
        this.id = numOfTrans;
    }

    public Transport(String model, String typeOf, int numOfPas, int[] weightOfPas, int weight, int maxSpeed) {
        this.model = model;
        this.typeOf = typeOf;
        this.numOfPas = numOfPas;
        this.weight = weight;
        this.maxSpeed = maxSpeed;

        if (weightOfPas != null && weightOfPas.length == numOfPas) {
            this.weightOfPas = new int[numOfPas];
            for (int i = 0; i < numOfPas; i++) {
                this.weightOfPas[i] = weightOfPas[i];
            }
        } else {
            this.weightOfPas = new int[numOfPas];
        }

        numOfTrans++;
        this.id = numOfTrans;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    // сделать + | сет и + | гет для веса пассажиров ( конкретно для одного, передается два параметра кого меняем и на что меняем)
    // с гет тоже самое с конкретным пассом

    public int getWeightOfPas(int Num) {
        return this.weightOfPas[Num];
    }

    void setWeightOfPas(int Num, int Weight) {
        this.weightOfPas[Num] = Weight;
    }

    // + | getNumOfPas
    // + | setWeight
    // + | getWeight
    // + | setModel
    // + | setTypeOf
    // + | getTypeOf

    int getTypeOption() {
        return this.typeOption;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    void setModel(String model) {
        this.model = model;
    }

    void setTypeOfName(String typeOf) {
        this.typeOf = typeOf;
    }

    void setTypeOfOption(int typeOfOption) {
        this.typeOf = typeOptions[typeOfOption];
    }

    public int getNumOfPas() {
        return numOfPas;
    }

    public int getWeight() {
        return weight;
    }

    public String getTypeOf() {
        return typeOf;
    }

    // typeOf = typeOptions[x];

    // + | сделать что бы не могло быть отрицательным
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.out.println("Max speed must be greater than 0, now it is - 0");
            this.maxSpeed = 0;
        }
    }

    // + сохр старые веса, потому тчо теряются
    public void setNumOfPas(int numOfPas) {
        this.numOfPas = numOfPas;
        int[] cache = this.weightOfPas;
        this.weightOfPas = new int[numOfPas];
        for (int i = 0; i < Math.min(cache.length, numOfPas); i++) {
            this.weightOfPas[i] = cache[i];
        }
    }

    public int getId() {
        return id;
    }


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

    void maxWeightCapacity() {
        System.out.println("Count of pas " + numOfPas);
        System.out.println("Max weight capacity of this transport: " + maxWeight * numOfPas);
    }

    static int maxWeightCapacityR(Transport A) {
        return (maxWeight * A.numOfPas);
    }

    void inputData() {
        int temp;
        while (true) {
            System.out.print("Enter model: ");
            model = inString();
            if (true) {

            }
            break;
        }
        while (true) {
            System.out.print("Enter num of passengers: ");
            numOfPas = inInt();
            if (numOfPas > 0) {
                break;
            }
            System.out.println("Passengers count must be greater than 0");

        }
        //+ проверку что бы не было отрицательным do while
        //+ проверку что бы не было отрицательным do while
        //+ проверку что бы не было отрицательным do while

        this.weightOfPas = new int[numOfPas];
        System.out.print("Enter weight of every passenger: \n");
        for (int i = 0; i < numOfPas; i++) {
            while (true) {
                temp = inInt();
                if (temp > 0) {
                    break;
                }
                System.out.println("Weight must be greater than 0");
            }
            this.weightOfPas[i] = temp;
        }
        for (int i = 0; i < numOfPas; i++) {
            System.out.print("#" + (i+1) + " - " + weightOfPas[i] + " ");
        }

        while (true) {
            System.out.print("\nEnter weight of your transport: ");
            weight = inInt();
            if (weight > 0) {
                break;
            }
            System.out.println("Weight must be greater than 0");

        }
        while (true) {
            System.out.print("Enter max speed: ");
            maxSpeed = inInt();
            if (maxSpeed > 0) {
                break;
            }
            System.out.println("Max speed must be greater than 0");

        }
        System.out.print("Enter type of transport: ");
        System.out.print("\n1 - Car\n2 - Autobus\n3 - Plane\n");
        temp = inInt();

        while (true) {
            switch (temp) {
                case 1:
                    typeOf = typeOptions[0];
                    break;
                case 2:
                    typeOf = typeOptions[1];
                    break;
                case 3:
                    typeOf = typeOptions[2];
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    temp = inInt();
            }
            if (temp == 1 || temp == 2 || temp == 3) {
                break;
            }
        }
    }

    void setRandom() {
        Random rand = new Random();
        int x = rand.nextInt(10) + 1;
        this.numOfPas = x;
        this.weightOfPas = new int[numOfPas];
        x = rand.nextInt(3030);
        this.weight = x;
        for (int i = 0; i < numOfPas; i++) {
            x = rand.nextInt(80);
            this.weightOfPas[i] = x;
        }
        x = rand.nextInt(280) + 1;
        this.maxSpeed = x;
        x = rand.nextInt(typeOptions.length);
        typeOf = typeOptions[x];
    }

    public void printAll() {
        System.out.println("ID: " + this.id);
        System.out.println("Number of pass " + this.numOfPas);
        for (int i = 0; i < this.numOfPas; i++) {
            System.out.println("Passenger #" + (i + 1) + " " + weightOfPas[i]);
        }
        System.out.println("Weight " + this.weight);
        System.out.println("Model: " + this.model);
        System.out.println("Type: " + this.typeOf);
        System.out.println("Max speed: " + this.maxSpeed);
    }

    void comparePasCount(Transport A) {
        if (this.numOfPas > A.numOfPas) {
            System.out.println("Transport " + this.id + " " + this.model + " has more passengers than " + A.id + " " + A.model);
            System.out.println("ID" + this.id + " - " + this.numOfPas + "\n" + "ID" + A.id + " - " + A.numOfPas + "\n");
        }
    }

    static void compareWeightCapacity(Transport A, Transport B) {
        if (maxWeightCapacityR(A) > maxWeightCapacityR(B)) {
            System.out.println("Transport " + A.id + " " + A.model + " has more weight capacity than " + B.id + " " + B.model);
            System.out.println("ID" + A.id + " - " + maxWeightCapacityR(A) + "\n" + "ID" + B.id + " - " + maxWeightCapacityR(B) + "\n");
        } else {
            System.out.println("Transport " + B.id + " " + B.model + " has more weight capacity than " + A.id + " " + A.model);
            System.out.println("ID" + B.id + " - " + maxWeightCapacityR(B) + "\n" + "ID" + A.id + " - " + maxWeightCapacityR(A) + "\n");

        }
    }

    static void showNumOfTrans() {
        System.out.println("Total amount of transport - " + numOfTrans);
    }

    static void compareCapacityOf4(Transport A, Transport B, Transport C, Transport D) {
        int max1 = Math.max(A.numOfPas, B.numOfPas);
        int max2 = Math.max(max1, C.numOfPas);
        int max3 = Math.max(max2, D.numOfPas);
        if (max3 == A.numOfPas) {
            System.out.println("Max is " + A.id + " - " + A.model);
            System.out.println("And this Transport has " + A.numOfPas + " passengers");
        } else if (max3 == B.numOfPas) {
            System.out.println("Max is " + B.id + " - " + B.model);
            System.out.println("And this Transport has " + B.numOfPas + " passengers");
        } else if (max3 == C.numOfPas) {
            System.out.println("Max is " + C.id + " - " + C.model);
            System.out.println("And this Transport has " + C.numOfPas + " passengers");
        }  else if (max3 == D.numOfPas) {
            System.out.println("Max is " + D.id + " - " + D.model);
            System.out.println("And this Transport has " + D.numOfPas + " passengers");
        }
    }

    static void CompareWeightCapacityOf4(Transport A, Transport B, Transport C, Transport D) {
        int max1 = Math.max(maxWeightCapacityR(A), maxWeightCapacityR(B));
        int max2 = Math.max(max1, maxWeightCapacityR(C));
        int max3 = Math.max(max2, maxWeightCapacityR(D));

        if (max3 == maxWeightCapacityR(A)) {
            System.out.println("Max is " + A.id + " - " + A.model);
            System.out.println("And this Transport has " + maxWeightCapacityR(A) + " max weight capacity");
        } else if (max3 == maxWeightCapacityR(B)) {
            System.out.println("Max is " + B.id + " - " + B.model);
            System.out.println("And this Transport has " + maxWeightCapacityR(B) + " max weight capacity");
        } else if (max3 == maxWeightCapacityR(C)) {
            System.out.println("Max is " + C.id + " - " + C.model);
            System.out.println("And this Transport has " + maxWeightCapacityR(C) + " max weight capacity");
        }  else if (max3 == maxWeightCapacityR(D)) {
            System.out.println("Max is " + D.id + " - " + D.model);
            System.out.println("And this Transport has " + maxWeightCapacityR(D) + " max weight capacity");
        }
    }

    public record TransportData(String model, int numOfPas, int weight, int typeOptions, int maxSpeed, int[] weightOfPas) {}

    public static TransportData parseJson(String path) throws Exception {
        JSONObject j = (JSONObject) new JSONParser().parse(new FileReader(path));

        String model = (String) j.get("model");
        int numOfPas = ((Long) j.get("numOfPas")).intValue();
        int weight = ((Long) j.get("weight")).intValue();
        int typeOptions = ((Long) j.get("typeOptions")).intValue();
        int maxSpeed = ((Long) j.get("maxSpeed")).intValue();

        JSONArray arr = (JSONArray) j.get("weightOfPas");
        int[] weightOfPas = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            weightOfPas[i] = ((Long) arr.get(i)).intValue();
        }

        return new TransportData(model, numOfPas, weight, typeOptions, maxSpeed, weightOfPas);
    }

    public static void exportJson(String name, Transport t) {
        // JSON String
        JSONObject j = new JSONObject();
        j.put("id", t.getId());
        j.put("model", t.getModel());
        j.put("weight", t.getWeight());
        j.put("typeOf", t.getTypeOf());
        j.put("maxSpeed", t.getMaxSpeed());
        j.put("typeOption", t.getTypeOption());

        // JSON Array
        JSONArray arr = new JSONArray();

        for (int i = 0; i < t.numOfPas; i++) {
            arr.add(t.weightOfPas[i]);
        }

        j.put("weightOfPas", arr);

        try (FileWriter fileWriter = new FileWriter(name + ".json")) {
            fileWriter.write(j.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception {
        Transport bmw = new Transport("BMW", 2, 259);
        System.out.println(bmw.getId() + " id ");
        System.out.println(numOfTrans + " count of transport");


        Transport audi = new Transport("Audi", 0, 259);
        System.out.println(audi.getId() + " id");
        System.out.println(numOfTrans + " count of transport");

        Transport empty = new Transport();
        System.out.println(empty.getId() + " id");
        System.out.println(numOfTrans + " count of transport");
        Transport clone = new Transport(bmw);
        System.out.println(clone.getId() + " id");


        System.out.println(numOfTrans + " count of transport");

        audi.printAll();

        Transport fromKeyboard = new Transport();
//
//        fromKeyboard.inputData();
//        fromKeyboard.printAll();

        Transport randomValues = new Transport();

        randomValues.setRandom();
        randomValues.printAll();
        Transport randomValues1 = new Transport();
        randomValues1.setRandom();

        randomValues.maxWeightCapacity();

        randomValues.comparePasCount(bmw);

        compareWeightCapacity(randomValues, randomValues1);

        Transport plane = new Transport("Boeing 747", "plane", 4, new int[]{70, 80, 90, 88}, 18000, 950);
        plane.printAll();

        plane.setNumOfPas(6);

        plane.printAll();

        System.out.println(bmw.getTypeOf());
        bmw.setTypeOfOption(0);
        bmw.printAll();

        plane.setWeightOfPas(1, 50);
        plane.setWeightOfPas(5, 99);
        plane.setWeightOfPas(4, 50);
        plane.printAll();
        System.out.println("pas 1 has " + plane.getWeightOfPas(1) + " weight");

        compareCapacityOf4(plane, bmw, audi, randomValues);

        CompareWeightCapacityOf4(plane, bmw, audi, randomValues);


        //+ сделать вектор из эрей лист
        Vector<Transport> transportList = new Vector<>();

        Transport transport1 = new Transport();
        transportList.add(transport1);

        transportList.add(new Transport());
        transportList.add(new Transport("Tesla", 0, 250));
        transportList.add(new Transport("Bus Mercedes", 1, 140));
        transportList.add(new Transport("Boeing 737", 2, 900));

        for (int i = 0; i < transportList.size(); i++) {
            System.out.println((i + 1) + ". " + transportList.get(i).getModel() + " (" + transportList.get(i).typeOf + ")");
        }


        TransportData data = parseJson("src/input.json");
        Transport t = new Transport(data.model(), data.numOfPas(), data.weight(), data.typeOptions(), data.maxSpeed(), data.weightOfPas());

        t.printAll();

        showNumOfTrans();

        for (int i = 0; i < transportList.size(); i++) {
            exportJson("unnamed" + i, transportList.get(i));
        }

        exportJson("t", t);
    }

}

public class Main {

}
