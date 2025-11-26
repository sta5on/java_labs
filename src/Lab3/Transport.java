package sta5on;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sta5on.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Transport {
    private int id = numOfTrans;
    private ArrayList<Passenger> passengers;
    private int weight;
    private static int numOfTrans = 0;
    private String model;
    private String typeOf;
    private int typeOption;
    private String[] typeOptions = {"car", "autobus", "plane"};
    private int maxSpeed;

    public final static int maxWeight = 150;

    public Transport() {
        this.model = "tesla";
        this.typeOption = 0;
        this.typeOf = typeOptions[typeOption];
        numOfTrans++;
        this.id = numOfTrans;
        this.passengers = new ArrayList<>();
    }

    public Transport(Transport other) throws InvalidWeightException {
        this.model = other.model;
        this.typeOf = other.typeOf;
        this.typeOption = other.typeOption;
        this.weight = other.weight;
        this.maxSpeed = other.maxSpeed;
        this.passengers = new ArrayList<>();

        for (Passenger p : other.passengers) {
            this.passengers.add(new Passenger(p.getWeight(), p.getName()));
        }

        numOfTrans++;
        this.id = numOfTrans;
    }

    public Transport(String model, int typeOption, int maxSpeed) throws InvalidTransportTypeException {
        this.model = model;
        if (typeOption >= 0 && typeOption < typeOptions.length) {
            this.typeOf = typeOptions[typeOption];
            this.typeOption = typeOption;
        } else {
            throw new InvalidTransportTypeException(typeOption);
        }
        this.maxSpeed = maxSpeed;
        this.passengers = new ArrayList<>();
        numOfTrans++;
        this.id = numOfTrans;
    }

    public Transport(String model, String typeOf, ArrayList<Passenger> passengers, int weight, int maxSpeed) {
        this.model = model;
        this.typeOf = typeOf;
        this.passengers = new ArrayList<>(passengers);
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        numOfTrans++;
        this.id = numOfTrans;
    }


    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public int getTypeOption() {
        return typeOption;
    }

    public int getId() {
        return id;
    }

    public int getNumOfPas() {
        return passengers.size();
    }

    public Passenger getPassenger(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= passengers.size()) {
            throw new IndexOutOfBoundsException("Passenger index out of bounds: " + index);
        }
        return passengers.get(index);
    }

    public ArrayList<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void setNumOfPas(int num) {
        if (num <= 0 && this.getNumOfPas() != num) {
            System.out.println("Ошибка");
            return;
        }

        int currentSize = getNumOfPas();

        if (num < currentSize) {
            int toRemove = currentSize - num;
            for (int i = 0; i < toRemove; i++) {
                passengers.remove(0);
            }
            System.out.println("Удалено " + toRemove);

        } else if (num > currentSize) {
            int toAdd = num - currentSize;
            try {
                for (int i = 0; i < toAdd; i++) {
                    passengers.add(new Passenger(1, "NewPassenger_" + (i + 1)));
                }
                System.out.println("Новых " + toAdd + " pass");
            } catch (InvalidWeightException e) {
                System.err.println("Ошибка добавления пассажиров:");
                e.processing();
            }
        } else {
            System.out.println("Количество пассажиров уже равно " + num);
        }
    }


public void setWeight(int weight) throws InvalidWeightException {
    if (weight < 0) {
        throw new InvalidWeightException(weight);
    }
    this.weight = weight;
}

public void setModel(String model) {
    if (model == null || model.trim().isEmpty()) {
        this.model = "Unknown";
    } else {
        this.model = model;
    }
}

public void setTypeOfName(String typeOf) {
    this.typeOf = typeOf;
}

public void setTypeOfOption(int typeOfOption) throws InvalidTransportTypeException {
    if (typeOfOption < 0 || typeOfOption >= typeOptions.length) {
        throw new InvalidTransportTypeException(typeOfOption);
    }
    this.typeOf = typeOptions[typeOfOption];
    this.typeOption = typeOfOption;
}


public void setMaxSpeed(int maxSpeed) {
    if (maxSpeed > 0) {
        this.maxSpeed = maxSpeed;
    } else {
        System.out.println("Max speed must be greater than 0, now it is - 0");
        this.maxSpeed = 0;
    }
}

public void addPassenger(Passenger passenger) {
    try {
        if (passenger == null) {
            throw new EmptyTransportException(true);
        }
        passengers.add(passenger);
    } catch (EmptyTransportException e) {
        e.processing();
    }
}

public void addPassengerLazy(Passenger p) throws InvalidWeightException {
    if (p == null) {
        throw new InvalidWeightException(-1);
    }
    passengers.add(p);
}

public void addMultiplePassengers(int count) {
    try {
        try {
            if (count < 0) {
                throw new CapacityExceededException(count, 0);
            }

            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                int w = rand.nextInt(80) + 40;

                if (w <= 0 || w > maxWeight) {
                    throw new InvalidWeightException(w);
                }

                Passenger p = new Passenger(w, "RandomPassenger_" + (i + 1));
                passengers.add(p);
            }
            System.out.println("Добавлено " + count + " рандомных пассажиров");
        } catch (InvalidWeightException weightE) {
            throw new CapacityExceededException(new Exception("Weight error"));
        }
    } catch (CapacityExceededException e) {
        e.processing();
    }
}

public void removePassenger(int index) {
    try {
        if (passengers.isEmpty()) {
            throw new EmptyTransportException(true);
        }
        if (index < 0 || index >= passengers.size()) {
            throw new EmptyTransportException(new IndexOutOfBoundsException());
        }
        passengers.remove(index);
        System.out.println("Пассажир удалён");
    } catch (EmptyTransportException e) {
        e.processing();
    }
}

public void clearPassengers() {
    passengers.clear();
}

static String inString() {
    String str = "";
    BufferedReader box = new BufferedReader(new InputStreamReader(System.in));
    try {
        str = box.readLine();
    } catch (IOException e) {
        System.err.println("Error reading input: " + e.getMessage());
    }
    return str;
}

static int inInt() {
    try {
        return Integer.parseInt(inString());
    } catch (NumberFormatException e) {
        System.err.println("Invalid number format!");
        return 0;
    }
}

public void maxWeightCapacity() throws EmptyTransportException {
    if (passengers.isEmpty()) {
        throw new EmptyTransportException(true);
    }
    System.out.println("Количество пассажиров: " + passengers.size());
    System.out.println("Максимальная грузоподъемность: " + maxWeight * passengers.size() + " кг");
}


public static int maxWeightCapacityR(Transport A) {
    return maxWeight * A.passengers.size();
}

public void inputData() {
    int temp;

    System.out.print("Enter model: ");
    model = inString();

    while (true) {
        System.out.print("Enter num of passengers: ");
        temp = inInt();
        if (temp > 0) {
            break;
        }
        System.out.println("Passengers count must be greater than 0");
    }

    passengers.clear();
    System.out.println("Enter weight of every passenger:");

    for (int i = 0; i < temp; i++) {
        int pasWeight;
        while (true) {
            System.out.print("Passenger #" + (i + 1) + ": ");
            pasWeight = inInt();
            if (pasWeight > 0 && pasWeight <= maxWeight) {
                break;
            }
            System.out.println("Weight must be between 1 and " + maxWeight);
        }

        try {
            passengers.add(new Passenger(pasWeight, "Passenger_" + (i + 1)));
        } catch (InvalidWeightException e) {
            System.err.println("Error adding passenger: " + e.getMessage());
            i--;
        }
    }

    System.out.println("\nPassengers added:");
    int index = 1;
    for (Passenger p : passengers) {
        System.out.println("#" + index++ + " - " + p.getWeight() + " kg");
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

    System.out.print("Enter type of transport:\n1 - Car\n2 - Autobus\n3 - Plane\n");
    temp = inInt();

    while (true) {
        try {
            if (temp >= 1 && temp <= 3) {
                setTypeOfOption(temp - 1);
                break;
            }
            System.out.println("Invalid input, try again");
            temp = inInt();
        } catch (InvalidTransportTypeException e) {
            System.err.println(e.getMessage());
            temp = inInt();
        }
    }
}

public void setRandom() {
    Random rand = new Random();

    passengers.clear();
    int numPas = rand.nextInt(10) + 1;

    for (int i = 0; i < numPas; i++) {
        try {
            passengers.add(new Passenger());
        } catch (Exception e) {
            System.err.println("Error creating random passenger: " + e.getMessage());
        }
    }

    this.weight = rand.nextInt(3030);
    this.maxSpeed = rand.nextInt(280) + 1;

    int typeIndex = rand.nextInt(typeOptions.length);
    try {
        setTypeOfOption(typeIndex);
    } catch (InvalidTransportTypeException e) {
        System.err.println(e.getMessage());
    }
}

public void printAll() {
    System.out.println("\nTransport ID: " + this.id);
    System.out.println("Model: " + this.model);
    System.out.println("Type: " + this.typeOf);
    System.out.println("Weight: " + this.weight + " kg");
    System.out.println("Max speed: " + this.maxSpeed + " km/h");
    System.out.println("Number of passengers: " + passengers.size());

    if (!passengers.isEmpty()) {
        System.out.println("Passengers:");
        for (Passenger p : passengers) {
            p.display();
        }
    } else {
        System.out.println("No passengers");
    }
}

public void comparePasCount(Transport A) {
    if (this.passengers.size() > A.passengers.size()) {
        System.out.println("Transport " + this.id + " " + this.model +
                " has more passengers than " + A.id + " " + A.model);
        System.out.println("ID" + this.id + " - " + this.passengers.size() +
                "\nID" + A.id + " - " + A.passengers.size() + "\n");
    }
}

public static void compareWeightCapacity(Transport A, Transport B) {
    int capA = maxWeightCapacityR(A);
    int capB = maxWeightCapacityR(B);

    if (capA > capB) {
        System.out.println("Transport " + A.id + " " + A.model +
                " has more weight capacity than " + B.id + " " + B.model);
        System.out.println("ID" + A.id + " - " + capA + "\nID" + B.id + " - " + capB + "\n");
    } else {
        System.out.println("Transport " + B.id + " " + B.model +
                " has more weight capacity than " + A.id + " " + A.model);
        System.out.println("ID" + B.id + " - " + capB + "\nID" + A.id + " - " + capA + "\n");
    }
}

public static void showNumOfTrans() {
    System.out.println("Total amount of transport - " + numOfTrans);
}

public static void compareCapacityOf4(Transport A, Transport B, Transport C, Transport D) {
    int max1 = Math.max(A.passengers.size(), B.passengers.size());
    int max2 = Math.max(max1, C.passengers.size());
    int max3 = Math.max(max2, D.passengers.size());

    Transport maxTransport = null;
    if (max3 == A.passengers.size()) maxTransport = A;
    else if (max3 == B.passengers.size()) maxTransport = B;
    else if (max3 == C.passengers.size()) maxTransport = C;
    else if (max3 == D.passengers.size()) maxTransport = D;

    if (maxTransport != null) {
        System.out.println("Max is " + maxTransport.id + " - " + maxTransport.model);
        System.out.println("And this Transport has " + maxTransport.passengers.size() + " passengers");
    }
}

public static void CompareWeightCapacityOf4(Transport A, Transport B, Transport C, Transport D) {
    int max1 = Math.max(maxWeightCapacityR(A), maxWeightCapacityR(B));
    int max2 = Math.max(max1, maxWeightCapacityR(C));
    int max3 = Math.max(max2, maxWeightCapacityR(D));

    Transport maxTransport = null;
    if (max3 == maxWeightCapacityR(A)) maxTransport = A;
    else if (max3 == maxWeightCapacityR(B)) maxTransport = B;
    else if (max3 == maxWeightCapacityR(C)) maxTransport = C;
    else if (max3 == maxWeightCapacityR(D)) maxTransport = D;

    if (maxTransport != null) {
        System.out.println("Max is " + maxTransport.id + " - " + maxTransport.model);
        System.out.println("And this Transport has " + maxWeightCapacityR(maxTransport) +
                " max weight capacity");
    }
}

public record TransportData(String model, int weight, int typeOptions,
                            int maxSpeed, ArrayList<Integer> weightOfPas) {
}

public static TransportData parseJson(String path) throws Exception {
    try {
        JSONObject j = (JSONObject) new JSONParser().parse(new FileReader(path));

        String model = (String) j.get("model");
        int weight = ((Long) j.get("weight")).intValue();
        int typeOptions = ((Long) j.get("typeOptions")).intValue();
        int maxSpeed = ((Long) j.get("maxSpeed")).intValue();

        JSONArray arr = (JSONArray) j.get("weightOfPas");
        ArrayList<Integer> weightOfPas = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            weightOfPas.add(((Long) arr.get(i)).intValue());
        }

        return new TransportData(model, weight, typeOptions, maxSpeed, weightOfPas);
    } catch (FileNotFoundException e) {
        throw new Exception("JSON file not found: " + path, e);
    } catch (Exception e) {
        throw new Exception("Error parsing JSON: " + e.getMessage(), e);
    }
}

public static void exportJson(String name, Transport t) {
    try {
        JSONObject j = new JSONObject();
        j.put("id", t.getId());
        j.put("model", t.getModel());
        j.put("weight", t.getWeight());
        j.put("typeOf", t.getTypeOf());
        j.put("maxSpeed", t.getMaxSpeed());
        j.put("typeOption", t.getTypeOption());

        JSONArray arr = new JSONArray();

        for (Passenger p : t.passengers) {
            arr.add(p.getWeight());
        }

        j.put("weightOfPas", arr);
        j.put("numOfPassengers", t.passengers.size());

        File dir = new File("./exported-data/");

        try (FileWriter fileWriter = new FileWriter("./exported-data/" + name + ".json")) {
            fileWriter.write(j.toJSONString());
        }
    } catch (IOException e) {
        System.err.println("Error exporting JSON: " + e.getMessage());
    }
}
}