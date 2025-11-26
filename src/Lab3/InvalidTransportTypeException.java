package sta5on;

public class InvalidTransportTypeException extends Exception {
    int typeIndex = -1;
    Exception err = null;

    InvalidTransportTypeException(int idx) {
        this.typeIndex = idx;
    }

    InvalidTransportTypeException(Exception e) {
        this.err = e;
    }

    void processing() {
        if (typeIndex < 0 || typeIndex > 2) {
            System.out.println("Ошибка: некорректный тип транспорта! Введено: " + typeIndex + " (допустимо: 0-2)");
        }
        if (err instanceof ArrayIndexOutOfBoundsException) {
            System.out.println("Ошибка: выход за пределы массива типов транспорта");
        }
    }
}