import java.util.Arrays;
import java.util.Scanner;

public class SortArray012 {
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], then increment both
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    // Move to the next element
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], then decrement high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array (only 0s, 1s, and 2s):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < 0 || arr[i] > 2) {
                System.out.println("Invalid input! Please enter only 0, 1, or 2.");
                i--; // Retry current index
            }
        }

        sortArray(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        scanner.close();
    }
}
