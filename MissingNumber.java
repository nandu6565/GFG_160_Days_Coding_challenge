import java.util.Scanner;

class MissingNumber {
    public static int missingNumber(int[] arr) {
        int n = arr.length;

        // Place each number at its correct position
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] to its correct position
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // The missing number
            }
        }

        // If all numbers are in their correct positions
        return n + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = missingNumber(arr);
        System.out.println("The smallest positive missing number is: " + result);

        scanner.close();
    }
}
