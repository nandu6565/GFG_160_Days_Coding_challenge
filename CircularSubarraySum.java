import java.util.Scanner;

public class CircularSubarraySum {

    public static int circularSubarraySum(int arr[]) {
        int n = arr.length;
        int maxLinearSum = kadane(arr, n);
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxInvertedSum = kadane(arr, n);

        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }

        int maxCircularSum = totalSum + maxInvertedSum;

        if (maxCircularSum == 0) {
            return maxLinearSum;
        }

        return Math.max(maxLinearSum, maxCircularSum);
    }

    private static int kadane(int arr[], int n) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < n; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = circularSubarraySum(arr);
        System.out.println("Maximum circular subarray sum is: " + result);

        sc.close();
    }
}
