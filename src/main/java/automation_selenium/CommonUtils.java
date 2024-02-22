package automation_selenium;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonUtils {

    private static Faker faker = new Faker();
    private CommonUtils(){}

    public static String getRandomDateInMMYY(int yearsFromNow){
        LocalDate currentDate = LocalDate.now();
        // Add 7 years to the current date
        LocalDate futureDate = currentDate.plusYears(yearsFromNow);
        // Generate a random month within the range [1, 12]
        int randomMonth = new Random().nextInt(12) + 1;
        // Set the day to 1 (you can choose any day)
        LocalDate randomDate = LocalDate.of(futureDate.getYear(), randomMonth, 1);
        // Format the date as MM/yy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/YY");
        String formattedDate = randomDate.format(formatter);
        return formattedDate;
    }

    public static int generateRandomNumber(int min, int max) {
        // Ensure that the range is valid
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }
        // Generate a random number within the specified range
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static String generateRandomCardNumber(int index){
        String cardNumber = faker.business().creditCardNumber().replace("-","");
        if (index == 0 || index == 1){
            return cardNumber;
        }else if (index == 2){
            return cardNumber.substring(0, cardNumber.length()-1);
        }else{
            throw new IllegalArgumentException("Invalid Card Index");
        }
    }




    public static void main(String[] args) {
        System.out.println(generateRandomNumber(0,2));
    }
}
