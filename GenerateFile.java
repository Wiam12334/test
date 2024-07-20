import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateFile {
    public static void main(String[] args) {
        String fileName = "data.txt";
        String[] cities = { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix" };
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 1000000; i++) {
                Date date = new Date(System.currentTimeMillis() - (long) random.nextInt(365 * 24 * 60 * 60 * 1000));
                String city = cities[random.nextInt(cities.length)];
                int temperature = random.nextInt(61) - 10; // Random temperature between -10 and 50
                writer.write(dateFormat.format(date) + "," + city + "," + temperature);
                writer.newLine();
            }
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
