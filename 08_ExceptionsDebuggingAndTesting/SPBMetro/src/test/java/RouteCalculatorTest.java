import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {
    Line green;
    Line blue;
    Line purple;
    List<Station> route;
    StationIndex stationIndex = new StationIndex();
    ArrayList<Station> bAndF;
    ArrayList<Station> dAndI;
    ArrayList<Station> noTransfer;
    ArrayList<Station> oneTransfer;
    ArrayList<Station> twoTransfer;
    RouteCalculator routeCalculator;
    Station a, b, c, d, e, f, g, h, i, j;

    @Override
    protected void setUp() throws Exception {
        /*
         *                        Line 2 - Blue       Line 3 - Purple
         *                               E             H
         *                               |             |
         *      Line 1 - Green;   A --- B/F --- C --- D\I
         *                               |             |
         *                               G             J
         */
        route = new ArrayList<>();
        green = new Line(1, "Зеленая");
        blue = new Line(2, "Синяя");
        purple = new Line(3, "Фиолетовая");
        noTransfer = new ArrayList<>();
        oneTransfer = new ArrayList<>();
        twoTransfer = new ArrayList<>();


        a = new Station("A", green);
        b = new Station("B", green);
        c = new Station("C", green);
        d = new Station("D", green);
        e = new Station("E", blue);
        f = new Station("F", blue);
        g = new Station("G", blue);
        h = new Station("H", purple);
        i = new Station("I", purple);
        j = new Station("J", purple);

        green.addStation(a);
        green.addStation(b);
        green.addStation(c);
        green.addStation(d);
        blue.addStation(e);
        blue.addStation(f);
        blue.addStation(g);
        purple.addStation(h);
        purple.addStation(i);
        purple.addStation(j);

        //==============================================================================
        noTransfer.addAll(blue.getStations());
        oneTransfer.addAll(Stream.of(e, f, b, c).collect(Collectors.toList()));
        twoTransfer.addAll(Stream.of(e, f, b, c, d, i, j).collect(Collectors.toList()));

        //добавляем линии в StationIndex
        Stream.of(green, blue, purple).forEach(stationIndex::addLine);
        //добавляем станции этих линий в StationIndex
        //создаем Stream<Line>
        Stream.of(green, blue, purple)
                //переводим в Stream<List<Station>>
                .map(Line::getStations)
                //Прогоняем Stream, stations - List<Station>
                .forEach(stations -> stations
                        //Добавляем каждый элемент List в StationIndex
                        .forEach(station -> stationIndex.addStation(station)));
        bAndF = new ArrayList<>();
        dAndI = new ArrayList<>();
        bAndF.add(blue.getStations().get(1));
        dAndI.add(purple.getStations().get(1));
        bAndF.add(green.getStations().get(1));
        dAndI.add(green.getStations().get(3));
        stationIndex.addConnection(bAndF);
        stationIndex.addConnection(dAndI);
        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDurationNoTransfer() {
        double actual = RouteCalculator.calculateDuration(noTransfer);
        double expected = 5.0;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationOneTransfer() {
        double actual = RouteCalculator.calculateDuration(oneTransfer);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationTwoTransfer() {
        double actual = RouteCalculator.calculateDuration(twoTransfer);
        double expected = 17;
        assertEquals(expected, actual);
    }

    public void testShortestRouteNoTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(e, g);
        List<Station> expected = noTransfer;
        assertEquals(expected, actual);
    }

    public void testShortestRouteOneTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(e, c);
        List<Station> expected = oneTransfer;
        assertEquals(expected, actual);
    }

    public void testShortestRouteTwoTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(e, j);
        List<Station> expected = twoTransfer;
        assertEquals(expected, actual);
    }
}
