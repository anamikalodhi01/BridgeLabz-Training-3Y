import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

            if (arr[i] > 0) {
                if (arr[i] % 2 == 0)
                    System.out.println(arr[i] + " is Positive and Even");
                else
                    System.out.println(arr[i] + " is Positive and Odd");
            } else if (arr[i] < 0) {
                System.out.println(arr[i] + " is Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (arr[0] == arr[4]) {
            System.out.println("First and Last elements are Equal");
        } else if (arr[0] > arr[4]) {
            System.out.println("First element is Greater than Last");
        } else {
            System.out.println("Last element is Greater than First");
        }
    }
}
