package sta5on;

public class InvalidWeightException extends Exception {
    int weight = -1;
    Exception err = null;

    InvalidWeightException(int w) {
        this.weight = w;
    }

    InvalidWeightException(Exception e) {
        this.err = e;
    }

    void processing() {
        if (weight <= 0) {
            System.out.println("Ошибка: вес должен быть больше 0! Введено: " + weight);
        }
        if (weight > 150) {
            System.out.println("Ошибка: вес превышает максимум 150 кг! Введено: " + weight);
        }
        if (err instanceof NumberFormatException) {
            System.out.println("Ошибка: некорректный формат числа для веса");
        }
    }
}