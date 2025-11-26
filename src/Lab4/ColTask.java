package sta5on;

import static sta5on.Main.*;

public class ColTask extends Thread {
    int id;
    Car car;


    // находим самую новую в столбце
    public ColTask(int id) {
        this.id = id;
        this.car = parking[0][id];
    }


    @Override
    public void run() {
        System.out.println("work with thread " + id);

        for (int i = 1; i < rows; i++) {
            if (car.getYearOfProd() < parking[i][id].getYearOfProd()) {
                car = parking[i][id];
            }
        }
        theNewest[id] = car;
    }
}
