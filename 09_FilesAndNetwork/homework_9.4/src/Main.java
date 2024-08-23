import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

import java.net.URL;
import java.util.ArrayList;

public class Main {
    private static final String path = "D:\\Skillbox\\Module3\\Dad\\java_basics\\09_FilesAndNetwork\\" +
            "homework_9.4\\imageFromWeb";

    public static void main(String[] args) {
        String url = "https://lenta.ru/";
        //список ссылок на изображения на сайте
        ArrayList<String> urlImage = connectToWeb(url);
        //список имен изображений
        ArrayList<String> fileName = new ArrayList<>();
        //перебираем ссылки на изображения
        urlImage.forEach(imageUrl -> {
            try {
                //сохраняем файлы изображений
                saveImage(imageUrl);
                //имена файлов сохраняем в список
                fileName.add(getNameImage(imageUrl));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //распечатываем список имен
        fileName.forEach(System.out::println);
    }

    // метод возвращающий список ссылок на изображения img
    public static ArrayList<String> connectToWeb(String url) {
        Document doc = null;
        try {
            // подключаемся к WebSite
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //получаем все теги  img
        Elements imgTag = doc.select("img");
        //создаю список типа String для хранения ссылок на каждую img
        ArrayList<String> urlImg = new ArrayList<>();
        imgTag.forEach(img -> {
            urlImg.add(img.attr("src"));
        });
        return urlImg;
    }

    //метод возвращающий имя изображения img
    public static String getNameImage(String urlImg) {
        String[] urlImgSplit = urlImg.split("/");
        return urlImgSplit[urlImgSplit.length - 1];
    }

    // метод сохраняющий изображения jpg, в заданном месте
    public static void saveImage(String urlImg) throws IOException {
        URL url = new URL(urlImg);
        InputStream inputStream = url.openStream();
        File fileImg = new File(path +"\\"+ getNameImage(urlImg));
        if (fileImg.exists()) {
            fileImg.delete();
        }
        if (fileImg.createNewFile()) {
            OutputStream outputStream = new FileOutputStream(path +"\\"+ getNameImage(urlImg));

            byte[] bytes = new byte[2048];
            int length;

            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
