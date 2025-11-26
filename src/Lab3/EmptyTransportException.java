package sta5on;

public class EmptyTransportException extends Exception {
    boolean isEmpty = false;
    Exception err = null;

    EmptyTransportException(boolean empty) {
        this.isEmpty = empty;
    }

    EmptyTransportException(Exception e) {
        this.err = e;
    }

    void processing() {
        if (isEmpty) {
            System.out.println("Ошибка: транспорт пустой, нет пассажиров для удаления");
        }
        if (err instanceof IndexOutOfBoundsException) {
            System.out.println("Ошибка: выход за пределы списка пассажиров");
        }
    }
}
