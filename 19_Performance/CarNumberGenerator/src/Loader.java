import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Loader {

    public static void main(String[] args) throws Exception {
        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int availableProcessorsCount = Runtime.getRuntime().availableProcessors();
        int threadCount = availableProcessorsCount > 12 ? 12 : letters.length / availableProcessorsCount;
        int eachArrLen = letters.length / threadCount;
        int threadNum = 0;
        long duration = 0;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < letters.length; i+=eachArrLen) {
            char[] newLetters = new char[eachArrLen];
            System.arraycopy(letters, i, newLetters, 0, eachArrLen);
            CallableImpl callable = new CallableImpl(newLetters, threadNum);
            Future<Long> future = service.submit(callable);
            duration += future.get();
            threadNum++;
        }
        service.shutdown();
        System.out.println(duration + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }

        return numberStr.toString();
    }

    static class CallableImpl implements Callable<Long> {

        private final char[] letters;
        private final FileOutputStream writer;
        private final StringBuilder builder;

        public CallableImpl(char[] letters, int threadNum) throws FileNotFoundException {
            this.letters = letters;
            File file = new File("res/numbers" + threadNum + ".txt");
            if (file.exists()) file.delete();
            this.writer = new FileOutputStream(file);
            this.builder = new StringBuilder();
        }

        @Override
        public Long call() throws Exception {
            long currentMillis = System.currentTimeMillis();
            for (int number = 1; number < 1000; number++) {
                int regionCode = 199;
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append('\n');
                        }
                    }
                }
            }
            writer.write(builder.toString().getBytes());
            writer.flush();
            writer.close();
            return System.currentTimeMillis() - currentMillis;
        }
    }
}
