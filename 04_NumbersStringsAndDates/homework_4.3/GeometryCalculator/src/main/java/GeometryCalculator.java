import net.sf.saxon.expr.Component;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(Math.abs(radius), 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (Math.pow(2, 2) / 3) * Math.PI * Math.pow(Math.abs(radius), 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean isTrianglePossible;
        if (a == 0 || b == 0 || c == 0)
        {
            return false;
        }
        if (a + b < c || a + c <  b || b + c < a) {
            return false;
        }else {
            return true;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        if (a == 0 || b == 0 || c == 0)
        {
            return -1.0;
        }
        if (a + b < c || a + c < b || b + c < a) {
            return -1.0;
        }
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }
}
