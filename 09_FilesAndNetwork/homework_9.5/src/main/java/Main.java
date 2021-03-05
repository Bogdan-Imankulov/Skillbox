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
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String pathToJson = "D:/Skillbox/SonGit/Skillbox/09_FilesAndNetwork/" +
            "homework_9.5/src/main/resources/JsonFile.json";
    private static final ArrayList<String> nums = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Map<String, Object> map;
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
            File file = new File(pathToJson);
            if (file.exists()) {
                file.delete();
            }
            //приравниваю переменной map значение json файла
            map = jsonFileObject.toMap();
            writeJsonFile(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeJsonFile(Map<String, Object> linesMap) {
        try {
            //закоментированный код в этом методе можете не читать
            FileWriter fileWriter = new FileWriter(pathToJson);
//            String[] tabs = {"\t", "\t\t", "\t\t\t", "\t\t\t\t"};
            String toWrite = linesMap.toString()
                    .replaceAll("=", ":")
//                    .replaceFirst("\\{", "{\n" + tabs[0])
                    .replaceAll(":", ": ")
                    /*.replaceAll(" \\[", " \\[\n" + tabs[0])
                    .replaceAll(tabs[1] + "\\[", tabs[0] + "[\n" + tabs[1])
                    .replaceAll("\",\"", "\",\n" + tabs[2] + "\"")
                    .replaceAll("\"}, ", "\"\n" + tabs[1] + "},\n" + tabs[1])
                    .replaceAll("\"}", "\"\n" + tabs[1] + "}\n" + tabs[0])
                    .replaceAll("\\{\"", tabs[0] + "{\n" + tabs[2] + "\"")
                    .replaceAll("]]", "]\n" + tabs[0] + "]")
                    .replaceAll("]}", "]\n}")
                    .replaceAll(tabs[2] + "\\{", tabs[1] + "{\n" + tabs[2])*/;
            fileWriter.write(toWrite);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private static JSONArray fillLinesJsonFile(Element element) {
        int i = -1;
        JSONArray linesArr = new JSONArray();
        for (Element innerElement : element.getAllElements()) {
            i++;
            if (i == 0) {
                continue;
            }
            Elements spans = innerElement.getElementsByTag("span");
            if (spans.size() == 0 || i % 2 != 0) {
                continue;
            }
            String lineName = spans.get(0).text();
            String lineNumber = spans.get(0).attr("data-line");
            if (lineNumber.equalsIgnoreCase("")) {
                continue;
            }
            JSONObject object = new JSONObject();
            object.put("number", lineNumber);
            nums.add(lineNumber);
            object.put("name", lineName);
            linesArr.put(object.toString());
        }
        return linesArr;
    }

    private static JSONObject fillStationsJsonFile(Elements elements) {

        //выбираю все элементы тега "а"
        elements = elements.select("a");
        List<String> stationNames = new ArrayList<>();
        //разделяю станции по линиям
        elements.forEach(element -> {
            String text = element.text();
            if (text.contains("Подробно о линии")) {
                text = "\n";
            }
            stationNames.add("\"" + text + "\"");
        });
        //значение ключа "stations"
        JSONObject stationsValue = new JSONObject();
        int keyNum = 0;
        //внутренний массив, значение ключей по типу: "1" : "Лесопарковая"
        JSONArray objectValue = new JSONArray();
        for (String stationName : stationNames) {
            //убираю номер станции из имени "1. Лесопарковая" в "Лесопарковая"
            stationName = stationName.replaceAll("\\d*\\.*\\s*", "");
            //проверка: встретилось ли разделение по линиям
            if (stationName.equalsIgnoreCase("\"\"")) {
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
}
