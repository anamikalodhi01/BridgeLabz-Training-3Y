import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2025, 8, 31); // Example input date

        // Add 7 days, 1 month, 2 years
        LocalDate modifiedDate = inputDate.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        LocalDate finalDate = modifiedDate.minusWeeks(3);

        System.out.println("Original Date: " + inputDate);
        System.out.println("After Adding (7 days, 1 month, 2 years): " + modifiedDate);
        System.out.println("After Subtracting 3 weeks: " + finalDate);
    }
}
