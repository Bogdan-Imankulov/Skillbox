import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    //путь к json файлу
    private static final String pathToJson = "D:\\Skillbox\\Module3\\Dad\\java_basics" +
            "\\09_FilesAndNetwork\\homework_9.5\\src\\main\\resources\\JsonFile.json";
    //list содержащий номера станций
    private static final ArrayList<String> nums = new ArrayList<>();

    public static void main(String[] args) {
        try {
            TreeMap<String, Object> map;
            //создаю переменную для будующего Json файла
            JSONObject jsonFileObject = new JSONObject();
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines")
                    .maxBodySize(0).get();
            //беру элементы из тега div в котором находится информация о системе метро
            Elements divs = doc.getAllElements().select("div");
            List<Element> metroData = divs.stream().filter(el ->
                    el.attr("id").equalsIgnoreCase("metrodata"))
                    .collect(Collectors.toList());
            divs = new Elements(metroData);
            //Добавляем линии и станции в переменную для json файла
            jsonFileObject.put("\"lines\"", fillLinesJsonFile(metroData.get(0)));
            jsonFileObject.put("\"stations\"", fillStationsJsonFile(divs));
            jsonFileObject.put("\"connections\"", fillConnectionsJsonFile(divs));
            //Создаю файл формата .json по указанному пути, если существует, удаляю
            map = new TreeMap<>(jsonFileObject.toMap());
            File file = new File(pathToJson);
            if (file.exists()) {
                file.delete();
            }
            writeJsonFile(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeJsonFile(TreeMap<String, Object> map) {
        try {
            //создаю "писателя", который будет писать мой Json файл
            FileWriter fileWriter = new FileWriter(pathToJson);
            String toWrite = map.toString().replaceAll("=", ": ");
            //Записываю переменую в файл
            fileWriter.write(toWrite);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private static JSONArray fillLinesJsonFile(Element element) {
        //замена i в fori цикле, значение -1 из-за того что инкремент происходит в начале каждой итерации
        int i = -1;
        //окончательный результат, значение ключа "lines"
        JSONArray linesArr = new JSONArray();
        //прохожу по внутреннему блоку <div> внутре тега <div id="metrodata">, далее див
        for (Element innerElement : element.getAllElements()) {
            i++;
            //пропуск первой итерации, т.к. в файле Json дубликат Сокольнической линии с номером 1
            if (i == 0) {
                continue;
            }
            //выбираю все теги <span> из дива, в данных тегах находится информация о линии
            Elements spans = innerElement.getElementsByTag("span");
            if (spans.size() == 0 || i % 2 != 0) {
                continue;
            }
            //беру значение тега <span>
            String lineName = spans.get(0).text();
            //беру значение аттрибута data-line тега <span>, в нем находится номер линии
            //Переменная класса String т.к. номера некоторых линий содержат буквы
            String lineNumber = spans.get(0).attr("data-line");
            if (lineNumber.equalsIgnoreCase("")) {
                continue;
            }
            //создаю объект, добавляю туда номер и имя линии
            JSONObject lineData = new JSONObject();
            lineData.put("number", lineNumber);
            //добавляю в список номеров линий, для дальнейшего использования в парсинге станций;
            nums.add(lineNumber);
            lineData.put("name", lineName);
            linesArr.put(lineData.toString());
        }
        return linesArr;
    }

    private static JSONObject fillStationsJsonFile(Elements elements) {

        //выбираю все элементы тега "а"
        elements = elements.select("a");
        List<String> stationNames = new ArrayList<>();
        //разделяю станции по линиям
        elements.forEach(element -> {
            //если встречается "Подробно о линии", то это станции другой линии.
            String text = element.text();
            if (text.contains("Подробно о линии")) {
                text = "==";
            }
            //окружаю имя станции кавычками, для более легкой записи в дальнейшем
            stationNames.add("\"" + text + "\"");
        });
        //значение ключа "stations"
        JSONObject stationsValue = new JSONObject();
        int keyNum = -1;
        //внутренний массив, значение ключей например: "1" : "Лесопарковая"
        JSONArray objectValue = new JSONArray();
        for (String stationName : stationNames) {
            if (keyNum == -1) {
                keyNum++;
                continue;
            }
            //убираю номер станции из имени пример: из "1. Лесопарковая" в "Лесопарковая"
            stationName = stationName.replaceAll("\\d+\\.+\\s+", "");
            //проверка: встретилось ли разделение по линиям
            if (stationName.equalsIgnoreCase("\"==\"")) {
                keyNum++;
                //добавляю в stations внутренний массив
                stationsValue.put("\"" + nums.get(keyNum - 1) + "\"", objectValue);
                //обновляю внутренний массив
                objectValue = new JSONArray();
                continue;
            }
            objectValue.put(stationName);
        }
        return stationsValue;
    }

    private static JSONArray fillConnectionsJsonFile(Elements elements) {
        List<Element> list = elements.select("a");
        JSONArray connectionsValue = new JSONArray();
        for (Element a : list) {
            JSONArray innerValue = new JSONArray();
            Element upperDiv = a.parent().parent();
            String currentLineNum = upperDiv.attr("data-line").trim();
            Elements spans = a.getElementsByTag("span");
            String currentStationName = spans.text().trim();
            List<Element> spanList = spans.stream().filter(span -> !span.attr("title")
                    .equals("")).collect(Collectors.toList());

            spans = new Elements(spanList);
            JSONObject connection = new JSONObject();
            if (!currentStationName.equals("") || spanList.size() != 0) {
                connection.put("\"line\"", "\"" + currentLineNum + "\"");
                connection.put("\"station\"", ("\"" + currentStationName
                        .replaceAll("null", "") + "\"")
                        .replaceAll("\\d+\\.+\\s+", ""));
                innerValue.put(connection);
            }
            connection = new JSONObject();
            for (Element span : spans) {
                String classAttr = span.attr("class");
                classAttr = classAttr.replaceAll("t-icon-metroln ln-", "");
                String title = span.attr("title");
                title = title.replaceAll("переход на станцию «", "");
                String connectionStationName = ("\"" + splitString(title,
                        title.indexOf("»"))[0] + "\"").replaceAll("null", "");
                connection.put("\"line\"", ("\"" + classAttr + "\"").trim());
                connection.put("\"station\"", connectionStationName.trim());
                if (!connection.equals(new JSONObject())) {
                    innerValue.put(connection);
                }
                connection = new JSONObject();
            }
            if (innerValue.length() > 1) {
                connectionsValue.put(innerValue);
            }
        }
        return connectionsValue;
    }

    private static String[] splitString(CharSequence sequence, int separatorIndex) {
        String[] result = new String[2];
        for (int i = 0; i < separatorIndex; i++) {
            char c = sequence.charAt(i);
            result[0] += Character.toString(c);
        }
        for (int i = separatorIndex; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            result[1] += Character.toString(c);
        }
        return result;
    }
}
