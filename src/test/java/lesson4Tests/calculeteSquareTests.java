package lesson4Tests;

import lesson4.NegativeSideExeption;
import lesson4.WrongTriangleExeption;
import org.junit.jupiter.api.*;

import static lesson4.Triangle.calculateSquare;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class calculeteSquareTests {
    static double result;

    @Order(1)
    @Test
    void positiveCalculeteTest() throws WrongTriangleExeption, NegativeSideExeption {
        result = calculateSquare(3, 4, 5);
        Assertions.assertEquals(result, 6);
    }

    @Order(2)
    @Test
    void negativeSideExeptionTest() {
        Assertions.assertThrows(NegativeSideExeption.class, () -> calculateSquare(-3, 4, 5));
    }

    @Order(3)
    @Test
    void wrongTriangleExeptionTest() {
        Assertions.assertThrows(WrongTriangleExeption.class, () -> calculateSquare(4, 4, 9));
    }

}
