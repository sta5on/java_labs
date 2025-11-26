package sta5on;

import static sta5on.Main.*;

public class RowTask implements Runnable {

    int id;
    Car car;

    public RowTask(int id) {
        this.id = id;
        this.car = parking[id][0];
    }


    @Override
    public void run() {
        System.out.println("task with row " + id);
        for (int j = 1; j < cols; j++) {
            if (car.getFuelCons() > parking[id][j].getFuelCons()) {
                car = parking[id][j];
            }
        }
        lowConsum[id] = car;
    }
}
