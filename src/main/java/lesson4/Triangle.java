package lesson4;

public class Triangle {

    public static double calculateSquare(double a, double b, double c) throws NegativeSideExeption,
            WrongTriangleExeption, StackOverflowError {

        if (a <= 0 || b <= 0 || c <= 0) throw new NegativeSideExeption();
        if ((a + b < c) || (a + c) < b || (b + c) < a) throw new WrongTriangleExeption();

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
