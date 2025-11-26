package sta5on;

import java.util.Random;

public class Passenger {
    private int id;
    private int weight;
    private String name;
    private static int passengerCount = 0;

    public Passenger() {
        Random rand = new Random();
        this.id = ++passengerCount;
        this.weight = rand.nextInt(80) + 40;
        this.name = "Passenger_" + this.id;
    }

    public Passenger(int weight, String name) throws InvalidWeightException {
        if (weight <= 0) {
            throw new InvalidWeightException(weight);
        }
        if (weight > sta5on.Transport.maxWeight) {
            throw new InvalidWeightException(weight);
        }
        this.id = ++passengerCount;
        this.weight = weight;
        this.name = name;
    }

    public Passenger(int weight) throws InvalidWeightException {
        this(weight, "Passenger_" + (passengerCount + 1));
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) throws InvalidWeightException {
        if (weight <= 0) {
            throw new InvalidWeightException(weight);
        }
        if (weight > sta5on.Transport.maxWeight) {
            throw new InvalidWeightException(weight);
        }
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("  Passenger #" + id + ": " + name + " - " + weight + " kg");
    }

    @Override
    public String toString() {
        return "Passenger{id=" + id + ", name='" + name + "', weight=" + weight + " kg}";
    }
}
