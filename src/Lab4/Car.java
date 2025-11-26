package sta5on;

import com.sun.jdi.connect.Transport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Car {
//    дана матрица типа машина, класс машина с полями марка объем год выпуска топливо,
//    макс скорость, расход топлива
//
//    в классе автомобили написать деф конструктор с рандомом полей,
//    вывод в сокращеном виде(как в борделе у герл)

    String make;
    String model;
    int volume;
    String[] fuelOptions
            = {"gas", "diesel", "gas-hybrid", "diesel-hybrid", "electric"};
    int fuelOption;
    String fuel;
    int yearOfProd;
    int maxSpeed;
    double fuelCons;

    static Map<String, List<String>> carData = new HashMap<>();

    static {
        carData.put("BMW", Arrays.asList("X5", "M5", "i8", "320i"));
        carData.put("Toyota", Arrays.asList("Camry", "Corolla", "Land Cruiser"));
        carData.put("Tesla", Arrays.asList("Model S", "Model 3", "Model X"));
        carData.put("Mercedes", Arrays.asList("C Class", "E Class", "S Class", "Sprinter"));
    }

    List<String> keys = new ArrayList<>(carData.keySet());

    Random random = new Random();

    public Car() {
        this.make = keys.get(random.nextInt(keys.size()));
        List<String> models = carData.get(make);
        this.model = models.get(random.nextInt(models.size()));
        this.yearOfProd = (random.nextInt(15) + 2010);
        if (make.equals("Tesla") || model.equals("i8")) {
            this.volume = 0;
        } else {
            this.volume = (random.nextInt(1500) + 1500);
        }
        if (make.equals("Tesla") || model.equals("i8")) {
            this.fuelOption = (fuelOptions.length) - 1;
        } else {
            this.fuelOption = (random.nextInt(fuelOptions.length ) - 1);
            if (fuelOption == -1) {
                fuelOption = 0;
            }
        }
        this.fuel = fuelOptions[fuelOption];
        if (make.equals("Tesla") || model.equals("i8")) {
            this.fuelCons = 0;
        } else {
            this.fuelCons = (random.nextDouble(6) + 5);
        }
        this.maxSpeed = (random.nextInt(150) + 150);
    }

    public String getFuel() {
        return fuel;
    }

    public double getFuelCons() {
        return fuelCons;
    }

    public int getFuelOption() {
        return fuelOption;
    }

    public String getMake() {
        return make;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getVolume() {
        return volume;
    }

    public int getYearOfProd() {
        return yearOfProd;
    }

    public void setFuelCons(double fuelCons) {
        this.fuelCons = fuelCons;
    }

    public void setFuelOption(int fuelOption) {
        this.fuelOption = fuelOption;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    void shortPrint() {
        System.out.println(this.make + " " + this.model + " " + this.yearOfProd + " " + this.fuel + " " + String.format("%.1f", this.fuelCons) + " l/100km " + this.maxSpeed + "km/h");
    }
}
