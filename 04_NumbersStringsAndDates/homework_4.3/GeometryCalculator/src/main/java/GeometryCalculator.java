public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        radius = Math.abs(radius);
        return Math.PI*Math.pow(radius,2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        radius = Math.abs(radius);
        return (4 * Math.PI * Math.pow(radius,3))/3 ;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if(a <= 0 || b <= 0 || c <= 0)
            return false;
        else if((a + b) > c && (a + c) < b && (b + c) >a)
            return true;
        else
        return false;
        /* else if((a + b) > c || (a + c) > b || (b + c) > a)
            return true;
        else
        return false;
        Вопрос  1)почему заккоментированный код не проходит тест, где a = 1; b = 20; c = 40
                2) если в коде который прошел тест входящие данные будет (а + b) == c
                то тогда не будет треугольника, а условие прошло тест */
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c) == false)
            return -1;
        double p = (a + b + c)/ 2; // полупериметр треугольника

        return Math.sqrt(p * (p -a) * (p - b) * (p - c));
    }
}
