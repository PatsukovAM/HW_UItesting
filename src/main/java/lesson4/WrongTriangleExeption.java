package lesson4;

public class WrongTriangleExeption extends Exception {
    public WrongTriangleExeption() {
        System.out.println("Сумма 2х сторон треугольника меньше 3й");
    }
}
