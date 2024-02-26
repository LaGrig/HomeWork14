import com.mobile.store.Smartphone;
import com.mobile.store.brand.Apple;
import com.mobile.store.brand.Huawei;
import com.mobile.store.brand.Samsung;
import com.mobile.store.brand.Xiaomi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    private static final String FILE_NAME = "src/main/resources/smartphones100.csv";

    private static Logger logger;

    static String[] readFileWithBufferReader(String filename) {
        ArrayList<String> data = new ArrayList<>();

        try (FileReader reader = new FileReader(filename);
             BufferedReader br = new BufferedReader(reader)) {
            String newLine;
            while ((newLine = br.readLine()) != null) {
                data.add(newLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Arrays.copyOf(data.toArray(), data.size(), String[].class);
    }

    private static List<Smartphone> createSmartphoneObject(String[] data) {
        List<Smartphone> smartphones = new ArrayList<>();
        phonesListObject(data, smartphones);
        return smartphones;
    }

    public static void phonesListObject(String[] data, List<Smartphone> smartphones) {
        for (int c = 1; c < data.length; c++) {
            String[] pieces = data[c].split(",");
            Smartphone currentSmartphone = createSmartphone(pieces);
            smartphones.add(currentSmartphone);
        }
    }

    public static Smartphone createSmartphone(String[] pieces) {
        Smartphone currentSmartphone = null;
        switch (pieces[0].toLowerCase()) {
            case "apple":
                currentSmartphone = new Apple(pieces[0], pieces[1], pieces[2], Integer.parseInt(pieces[3]),
                        Double.parseDouble(pieces[4]), Integer.parseInt(pieces[5]), pieces[6],
                        Boolean.parseBoolean(pieces[7]), Integer.parseInt(pieces[8]),
                        Integer.parseInt(pieces[9]), Integer.parseInt(pieces[10]));
                logger.log(Level.SEVERE, "Create Apple smartphone: " + currentSmartphone);
                break;
            case "samsung":
                currentSmartphone = new Samsung(pieces[0], pieces[1], pieces[2], Integer.parseInt(pieces[3]),
                        Double.parseDouble(pieces[4]), Integer.parseInt(pieces[5]), pieces[6],
                        Boolean.parseBoolean(pieces[7]), Integer.parseInt(pieces[8]),
                        Integer.parseInt(pieces[9]), Integer.parseInt(pieces[10]));
                logger.log(Level.WARNING, "Create Samsung smartphone: " + currentSmartphone);
                break;
            case "huawei":
                currentSmartphone = new Huawei(pieces[0], pieces[1], pieces[2], Integer.parseInt(pieces[3]),
                        Double.parseDouble(pieces[4]), Integer.parseInt(pieces[5]), pieces[6],
                        Boolean.parseBoolean(pieces[7]), Integer.parseInt(pieces[8]), Integer.parseInt(pieces[9]), Integer.parseInt(pieces[10]));
                logger.log(Level.INFO, "Create Huawei smartphone: " + currentSmartphone);
                break;
            case "xiaomi":
                currentSmartphone = new Xiaomi(pieces[0], pieces[1], pieces[2], Integer.parseInt(pieces[3]),
                        Double.parseDouble(pieces[4]), Integer.parseInt(pieces[5]), pieces[6],
                        Boolean.parseBoolean(pieces[7]), Integer.parseInt(pieces[8]), Integer.parseInt(pieces[9]), Integer.parseInt(pieces[10]));
                logger.log(Level.FINE, "Create Xiaomi smartphone: " + currentSmartphone);
                break;
        }
        return currentSmartphone;
    }

    public static void main(String[] args) {
    System.setProperty("java.util.logging.config.file", System.getenv("LOG_CONFIG_FILE"));

        logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.CONFIG, "Going to read DATA fom file:" + FILE_NAME);

        long timerStart = System.currentTimeMillis();
        Set<Smartphone> currentSmartphone = new LinkedHashSet<>();
        long importFileTimerStart = System.currentTimeMillis();
        String[] data = readFileWithBufferReader(FILE_NAME);
        long importFileTimerEnd = System.currentTimeMillis();
        long createObjectTimerStart = System.currentTimeMillis();
        List<Smartphone> smartphones = createSmartphoneObject(data);
        long createObjectTimerEnd = System.currentTimeMillis();

        Stream<Smartphone> smartphoneStream1 = smartphones.stream();
        Stream<Smartphone> smartphoneStream2 = smartphones.stream();
        Stream<Smartphone> smartphoneStream3 = smartphones.stream();

        System.out.println("********************************");
        System.out.println("Hryhorii Lakiza" + " / " + "Collection -> LinkedHashSet" + " / " + "SortOrder -> зменшення"
                + " / " + "SortSkip->16" + " / " + "SortOut->24" + " / " + "FilterOut->21");
        System.out.println("********************************");
        System.out.println("1) Sorted Smartphones (by provided conditions):");
        System.out.println("********************************");

        smartphoneStream1
                .sorted((s1, s2) -> Integer.compare(s2.getYearReleased(), s1.getBuildInMemoryStorage()))
                .skip(16)
                .limit(24)
                .forEach(System.out::println);

        System.out.println("********************************");
        System.out.println("2) Filtered Smartphones (By Brand Name):");
        System.out.println("********************************");
        smartphoneStream2
                .filter(s -> s.toString().contains("Apple"))
                .limit(21)
                .forEach(System.out::println);

        System.out.println("********************************");
        System.out.println("3) Mapped Smartphones (id + OS):");
        System.out.println("********************************");
        smartphoneStream3
                .map(smartphone -> smartphone.getId() + " " + smartphone.getOperationSystem())
                .forEach(System.out::println);

        Long globalTimerFinish = System.currentTimeMillis() - timerStart;
        System.out.println("**********************************************");
        System.out.println("Object creation time: " + (createObjectTimerEnd - createObjectTimerStart) + " ms");
        System.out.println("Import file time: " + (importFileTimerEnd - importFileTimerStart) + " ms");
        System.out.println("All processes duration " + globalTimerFinish + "ms");
        System.out.println("**********************************************");
        LocalDateTime startDate = LocalDateTime.of(2023, 10, 22, 18, 00);
        LocalDateTime endDate = LocalDateTime.of(2024, 03, 07, 01, 00);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long hours = ChronoUnit.HOURS.between(startDate, endDate) % 24;

        System.out.println("Вычисление промежутка между датами");
        System.out.println("Начальная дата:" + startDate);
        System.out.println("Конечная дата:" + endDate);
        System.out.println("Промежуток: " + days + " дней и " + hours + " часов");
    }
}