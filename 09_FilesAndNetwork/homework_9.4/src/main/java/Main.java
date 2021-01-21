import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String images = "D:\\Skillbox\\SonGit\\Skillbox\\09_FilesAndNetwork\\homework_9.4\\images\\";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(" https://lenta.ru").get();
            Elements links = doc.select("img");
            final int[] i = {0};
            links.forEach(link -> {
                try {
                    String imageSrc = link.attr("src");
                    URL url = new URL(imageSrc);
                    InputStream inpStream = url.openStream();
                    File f = new File(images + i[0] + "image.jpg");
                    if (f.createNewFile()) {
                        OutputStream outStream = new FileOutputStream(images + i[0] + "image.jpg");
                        byte[] bytes = new byte[2048];
                        int length;
                        while ((length = inpStream.read(bytes)) != -1) {
                            outStream.write(bytes, 0, length);
                        }
                        inpStream.close();
                        outStream.close();
                        i[0]++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
