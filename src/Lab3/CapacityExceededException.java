package sta5on;

public class CapacityExceededException extends Exception {
    int current = 0;
    int limit = 0;
    Exception err = null;

    CapacityExceededException(int current, int limit) {
        this.current = current;
        this.limit = limit;
    }

    CapacityExceededException(Exception e) {
        this.err = e;
    }

    void processing() {
        if (current > limit) {
            System.out.println("Ошибка: превышена вместимость! Текущее: " + current + ", Лимит: " + limit);
        }
        if (err instanceof IllegalStateException) {
            System.out.println("Ошибка: некорректное состояние при проверке вместимости");
        }
    }
}