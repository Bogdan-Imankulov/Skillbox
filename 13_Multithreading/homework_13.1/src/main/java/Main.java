import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        String srcFolder = "/users/sortedmap/Desktop/src";
        String dstFolder = "/users/sortedmap/Desktop/dst";
        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        int arraysCount = files.length / availableProcessors;
        int eachArrLength = files.length / arraysCount;
        for (int i = 0; i < arraysCount; i = i + eachArrLength) {
            File[] fileArr = new File[eachArrLength];
            System.arraycopy(files, i, fileArr, 0, eachArrLength);
            ImgResizer resizer = new ImgResizer(fileArr, dstFolder);
            resizer.start();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
