import java.util.Scanner;

public class BMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // personData[i][0] -> weight, [i][1] -> height, [i][2] -> BMI
        double[][] personData = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            double weight = sc.nextDouble();
            if (weight <= 0) { 
                System.out.println("Invalid weight. Enter again.");
                i--; continue; 
            }

            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            double height = sc.nextDouble();
            if (height <= 0) { 
                System.out.println("Invalid height. Enter again.");
                i--; continue; 
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] <= 18.4) status[i] = "Underweight";
            else if (personData[i][2] <= 24.9) status[i] = "Normal";
            else if (personData[i][2] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + " -> Weight: " + personData[i][0] +
                               " kg, Height: " + personData[i][1] +
                               " m, BMI: " + personData[i][2] +
                               ", Status: " + status[i]);
        }
    }
}
