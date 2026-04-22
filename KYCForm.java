import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KYCForm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            LocalDate signup = LocalDate.parse(input[0], formatter);
            LocalDate current = LocalDate.parse(input[1], formatter);

            if (signup.isAfter(current)) {
                System.out.println("No range");
                continue;
            }

            // Find anniversary in current year
            LocalDate anniversary = signup.withYear(current.getYear());

            if (anniversary.isAfter(current)) {
                anniversary = anniversary.minusYears(1);
            }

            // Calculate window
            LocalDate start = anniversary.minusDays(30);
            LocalDate end = anniversary.plusDays(30);

            // Adjust end date
            if (end.isAfter(current)) {
                end = current;
            }

            System.out.println(start.format(formatter) + " " + end.format(formatter));
        }

        sc.close();
    }
}