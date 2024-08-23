import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoutCalculatorTest extends TestCase {

    /*
     *
     *                             Line 2; yellow
     *                                   L           F
     *                                   |           |
     *  line 1; red                A -- B/M -- C -- D/I
     *                                   |           |
     *                                   N           G
     *                                        line 3; green
     */
    List<Station> routeOneLine;
    List<Station> routeTwoLine;
    List<Station> routeThreeLine;

    StationIndex index;
    RouteCalculator calculator;

    Station a, b, c, d, l, m, n, f, i, g;

    @Override
    protected void setUp() throws Exception {
        //создаю маршрут на одной линии
        routeOneLine = new ArrayList<Station>();
        //создаю маршрут на двух линиях, с одной пересадкой
        routeTwoLine = new ArrayList<Station>();
        //создаю маршрут на трех линиях, с двумя пересадками
        routeThreeLine = new ArrayList<Station>();

        // создаю три линии
        Line red = new Line(1, "red");
        Line yellow = new Line(2, "yellow");
        Line green = new Line(3, "green");

        //создаю станции на первой линии
        a = new Station("A", red);
        b = new Station("B", red);
        c = new Station("C", red);
        d = new Station("D", red);

        //создаю станции на второй линии
        l = new Station("L", yellow);
        m = new Station("M", yellow);
        n = new Station("N", yellow);

        //создаю станции на третей линии
        f = new Station("F", green);
        i = new Station("I", green);
        g = new Station("G", green);

        //создаю и заполняю object StationIndex index
        index = new StationIndex();

        //добавляем линии в index
        Stream.of(red, yellow, green).forEach(index::addLine);

        //добавляем станции в index
        Stream.of(a, b, c, d, l, m, n, f, i, g)
                .peek(station -> station.getLine().addStation(station))
                .forEach(index::addStation);

        //добавляем в index места пересадки
        index.addConnection(Stream.of(b, m).collect(Collectors.toList()));
        index.addConnection(Stream.of(d, i).collect(Collectors.toList()));

        //получаем станции пересадки
        index.getConnectedStations(b);
        index.getConnectedStations(d);

        //добавляю станции на маршрут по одной линии, без пересадок a b c
        routeOneLine = Stream.of(a, b, c).collect(Collectors.toList());

        //добавляю станции на маршрут по двум линиям, одна пересадка a b-m l
        routeTwoLine = Stream.of(a, b, m, l).collect(Collectors.toList());

        //добавляю станции на маршрут по трем линиям, две пересадки n m-b c d-i f
        routeThreeLine = Stream.of(n, m, b, c, d, i, f).collect(Collectors.toList());

        //создаю объект RoutCalculator
        calculator = new RouteCalculator(index);

    }

    public void testCalculatorDurationOneLine() {
        double actual = calculator.calculateDuration(routeOneLine);
        double expected = 5.0;
        assertEquals(expected, actual);
    }

    public void testCalculatorDurationTwoLine() {
        double actual = calculator.calculateDuration(routeTwoLine);
        //a -(2.5min)- b -(3.5min)- m -(2.5min)- l; 2.5+3.5+2.5=8.5
        double expected = 8.5;

        assertEquals(expected, actual);
    }

    public void testCalculatorDurationThreeLine() {
        double actual = calculator.calculateDuration(routeThreeLine);
        //n -(2.5min)- m -(3.5min)- b -(2.5min)- c -(2.5min)- d -(3.5min)- i -(2.5min)- f
        //2.5+3.5+2.5+2.5+3.5+2.5=17
        double expected = 17.0;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOneLine() {
        List<Station> actualRoute = calculator.getShortestRoute(a, c);
        List<Station> expectedRoute = routeOneLine;
        assertEquals(expectedRoute, actualRoute);
    }

    public void testGetShortestRouteTwoLine() {
        List<Station> actualRoute = calculator.getShortestRoute(a, l);
        List<Station> expectedRoute = routeTwoLine;
        assertEquals(expectedRoute, actualRoute);
    }

    public void testGetShortestRouteThreeLine() {
        List<Station> actualRoute = calculator.getShortestRoute(n, f);
        List<Station> expectedRote = routeThreeLine;
        assertEquals(expectedRote, actualRoute);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
