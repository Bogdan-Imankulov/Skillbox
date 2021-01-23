import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {
    private static final String images = "D:\\Skillbox\\SonGit\\Skillbox\\09_FilesAndNetwork\\" +
            "homework_9.4\\images\\";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(" https://lenta.ru").get();
            Elements links = doc.select("img");
            final int[] imageNumber = {0};
            links.forEach(link -> {
                try {
                    String imageSrc = link.attr("abs:src");
                    String[] srcSplit = imageSrc.split("/");
                    String imageName = srcSplit[srcSplit.length-1];
                    URL url = new URL(imageSrc);
                    InputStream inpStream = url.openStream();
                    File f = new File(images +
                            /*imageSrc + ".jpg"*/
                            /*imageNumber[0] + "image.jpg"*/
                            imageName/* + ".jpg"*/);
                    if (f.exists()) {
                        f.delete();
                    }
                    if (f.createNewFile()) {
                        OutputStream outStream = new FileOutputStream(images +
                                imageName
                                /*imageSrc + ".jpg"*/
                                /*imageName + ".jpg"*/
                                /*imageNumber[0] + "image.jpg"*/);
                        byte[] bytes = new byte[2048];
                        int length;
                        while ((length = inpStream.read(bytes)) != -1) {
                            outStream.write(bytes, 0, length);
                        }
                        inpStream.close();
                        outStream.close();
                        imageNumber[0]++;
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
