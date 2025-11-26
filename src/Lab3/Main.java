package sta5on;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transport> transportList = new ArrayList<>();

        Transport input = new Transport();

        input.inputData();

        input.printAll();

        input.setNumOfPas(4);

        input.printAll();
        try {

            System.out.println(" Создание транспортов");
            Transport bmw = new Transport("BMW", 0, 259);
            System.out.println("Создан: " + bmw.getModel() + " (ID: " + bmw.getId() + ")");
            transportList.add(bmw);

            Transport audi = new Transport("Audi", 0, 250);
            System.out.println("Создан: " + audi.getModel() + " (ID: " + audi.getId() + ")");
            transportList.add(audi);

            Transport empty = new Transport();
            System.out.println("Создан: " + empty.getModel() + " (ID: " + empty.getId() + ")");
            transportList.add(empty);
            
            Transport clone = new Transport(bmw);
            System.out.println("Создан клон BMW (ID: " + clone.getId() + ")");
            transportList.add(clone);

            Transport.showNumOfTrans();
            System.out.println();
            
            System.out.println("\nДобавление пассажиров в BMW (Классический тип)");
            Passenger p1 = new Passenger(70, "John");
            Passenger p2 = new Passenger(65, "Mary");
            Passenger p3 = new Passenger(80, "Bob");
            
            bmw.addPassenger(p1);
            bmw.addPassenger(p2);
            bmw.addPassenger(p3);
            
            bmw.printAll();
            
            System.out.println("\nНекорректный вес, отрицательный");
            try {
                Passenger invalid1 = new Passenger(-50, "InvalidNegative");
            } catch (InvalidWeightException e) {
                System.out.println("Поймано исключение:");
                e.processing();
            }

            System.out.println("\nНекорректный вес, сверх лимита");
            try {
                Passenger invalid2 = new Passenger(200, "InvalidHeavy");
            } catch (InvalidWeightException e) {
                System.out.println("Поймано исключение:");
                e.processing();
            }
            
            System.out.println("\nСоздание транспорта с рандомными");
            Transport randomTransport = new Transport();
            randomTransport.setRandom();
            randomTransport.printAll();
            transportList.add(randomTransport);

            
            System.out.println("\nСоздание самолёта с пассажирами (Ленивый тип)");
            Transport plane = new Transport("Boeing 747", 2, 950);

            try {
                plane.addPassengerLazy(new Passenger(70, "Pilot"));
                plane.addPassengerLazy(new Passenger(80, "Copilot"));
                plane.addPassengerLazy(new Passenger(90, "Attendant_1"));
                plane.addPassengerLazy(new Passenger(88, "Attendant_2"));
                System.out.println("Все пассажиры добавлены");
            } catch (InvalidWeightException e) {
                System.out.println("Ошибка при добавлении:");
                e.processing();
            }
            
            plane.printAll();
            transportList.add(plane);

            System.out.println("\nПроверка максимальной грузоподъёмности");
            try {
                plane.maxWeightCapacity();
            } catch (EmptyTransportException e) {
                e.processing();
            }

            System.out.println("\nУдаление пассажира из plane");
            plane.removePassenger(0);
            plane.printAll();

            System.out.println("\nПопытка удалить из пустого транспорта");
            empty.removePassenger(0);

            System.out.println("\nСравнение транспортов");
            bmw.comparePasCount(audi);
            Transport.compareWeightCapacity(bmw, plane);
            
            System.out.println("\nПоиск транспорта с максимальной грузоподъёмностью (for)");
            if (!transportList.isEmpty()) {
                Transport maxCapacityTransport = transportList.get(0);
                int maxCapacity = Transport.maxWeightCapacityR(maxCapacityTransport);

                for (int i = 1; i < transportList.size(); i++) {
                    int currentCapacity = Transport.maxWeightCapacityR(transportList.get(i));
                    if (currentCapacity > maxCapacity) {
                        maxCapacity = currentCapacity;
                        maxCapacityTransport = transportList.get(i);
                    }
                }
                
                System.out.println("Максимальная грузоподъёмность у: " + 
                                 maxCapacityTransport.getModel() + 
                                 " (" + maxCapacity + " кг)");
            }

            System.out.println("\nСписок всех транспортов (forEach)");
            int counter = 1;
            for (Transport t : transportList) {
                System.out.println(counter++ + ". " + t.getModel() + 
                                 " (" + t.getTypeOf() + ") - " + 
                                 t.getNumOfPas() + " пассажиров");
            }
            
            System.out.println("\nДобавление дополнительных транспортов");
            transportList.add(new Transport());
            transportList.add(new Transport("Tesla Model S", 0, 250));
            transportList.add(new Transport("Mercedes Bus", 1, 140));
            System.out.println("Добавлено 3 транспорта");
            
            System.out.println("\nНекорректный тип транспорта");
            try {
                Transport invalidType = new Transport("Invalid", 99, 200);
            } catch (InvalidTransportTypeException e) {
                System.out.println("Поймано исключение:");
                e.processing();
            }
            
            System.out.println("\nДобавление нескольких пассажиров");
            Transport testTransport = new Transport("Test Bus", 1, 120);
            testTransport.addMultiplePassengers(3);
            testTransport.printAll();
            transportList.add(testTransport);
            
            System.out.println("\nПопытка чтения из JSON");
            try {
                Transport.TransportData data = Transport.parseJson("src/input.json");
                Transport fromJson = new Transport();
                fromJson.setModel(data.model());
                fromJson.setWeight(data.weight());
                fromJson.setMaxSpeed(data.maxSpeed());

                for (Integer weight : data.weightOfPas()) {
                    try {
                        fromJson.addPassengerLazy(new Passenger(weight, "Passenger_JSON"));
                    } catch (InvalidWeightException e) {
                        System.err.println("Ошибка при добавлении пассажира из JSON:");
                        e.processing();
                    }
                }
                
                transportList.add(fromJson);
                System.out.println("Транспорт загружен из JSON");
                fromJson.printAll();
            } catch (Exception e) {
                System.out.println("JSON файл не найден: " + e.getMessage());
            }
            
            System.out.println("\nЭкспорт всех транспортов в JSON (for)");
            for (int i = 0; i < transportList.size(); i++) {
                Transport.exportJson(
                    transportList.get(i).getModel().replaceAll(" ", "_") + "_" + (i + 1),
                    transportList.get(i)
                );
                System.out.println((i + 1) + ". " + transportList.get(i).getModel() + " → exported");
            }
            System.out.println("\nВсего экспортировано: " + transportList.size() + " файлов JSON");
            
            
            Transport.showNumOfTrans();
            System.out.println("Транспортов в списке: " + transportList.size());
            
            int totalPassengers = 0;
            for (Transport t : transportList) {
                totalPassengers += t.getNumOfPas();
            }
            System.out.println("Всего пассажиров во всех транспортах: " + totalPassengers);
            
            System.out.println("\nДоступ к конкретному пассажиру");
            try {
                if (bmw.getNumOfPas() > 0) {
                    Passenger firstPassenger = bmw.getPassenger(0);
                    System.out.println("Первый пассажир в BMW:");
                    firstPassenger.display();
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка доступа к пассажиру: " + e.getMessage());
            }

        } catch (InvalidTransportTypeException e) {
            System.err.println("Ошибка типа транспорта:");
            e.processing();
        } catch (InvalidWeightException e) {
            System.err.println("Ошибка валидации веса:");
            e.processing();
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
