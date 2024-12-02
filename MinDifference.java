import java.util.*;

public class MinDifference {
    public static  int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int result = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            int maxHeight = Math.max(largest, arr[i] + k);
            int minHeight = Math.min(smallest, arr[i + 1] - k);

            // Skip if the minimum height becomes negative
            if (minHeight < 0) continue;

            // Update the result with the minimized difference
            result = Math.min(result, maxHeight - minHeight);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of towers: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the heights of the towers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        int result = getMinDiff(arr, k);
        System.out.println("Minimum difference is: " + result);

        sc.close();
    }
}
