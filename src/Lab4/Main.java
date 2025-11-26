package sta5on;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    static Car[][] parking;
    static int rows, cols;
    static Car[] lowConsum;
    static Car[] theNewest;

    static {
//        cols = (new Random()).nextInt(10) + 1;
//        rows = (new Random()).nextInt(10) + 1;
        cols = 7;
        rows = 7;
        parking = new Car[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parking[i][j] = new Car();
            }
        }
        theNewest = new Car[cols];
        lowConsum = new Car[rows];
    }

    public static void main(String[] args) {
        System.out.println("cols:" + cols + " rows:" + rows);
        System.out.println("Matrix: " + cols + "x" + rows);
        for (int i = 0; i < rows; i++) {
            System.out.print("Row: " + i + " ");
            for (int j = 0; j < cols; j++) {
                parking[i][j].shortPrint();
//                System.out.print(" [ " + parking[i][j].getModel() + " ] ");
            }
            System.out.println(" ");
        }

        List<Thread> threadsRows = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            Thread t = new Thread(new RowTask(i));
            t.start();
            threadsRows.add(t);
        }

        for (Thread t : threadsRows) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Results for rows: ");
        System.out.println("Lowest consumption!");
        for (int i = 0; i < (lowConsum.length); i++) {
            System.out.println("Row " + i);
            lowConsum[i].shortPrint();
            System.out.println();
        }

        List<Thread> threadsCols = new ArrayList<>();

        for (int i = 0; i < cols; i++) {
            Thread t = new Thread(new ColTask(i));
            t.start();
            threadsCols.add(t);
        }

        for (Thread t : threadsCols) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("\nResults for cols: ");
        System.out.println("Newest cars");
        for (int i = 0; i < (theNewest.length); i++) {
            System.out.println("Col " + i);
            theNewest[i].shortPrint();
            System.out.println();
        }



        int cache = 0;
        for (int j = 1; j < lowConsum.length; j++) {
            if (lowConsum[cache].getYearOfProd() > lowConsum[j].getYearOfProd()) {
                cache = j;
            }
        }
        System.out.println("Oldest car of lowest consumption is on: ");
        lowConsum[cache].shortPrint();

        System.out.printf("\n\n\n\n");

        cache = 0;
        for (int i = 1 ; i < theNewest.length; i++) {
            if (theNewest[cache].getFuelCons() < theNewest[i].getFuelCons()) {
                cache = i;
            }
        }
        System.out.println("Highest consumption of newest is on: ");
        theNewest[cache].shortPrint();
    }
}