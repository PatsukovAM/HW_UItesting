package lesson4;

public class NegativeSideExeption extends Exception {
    public NegativeSideExeption() {
        System.out.println("Введено отрицательное значение сторон(ы)");
    }
}
