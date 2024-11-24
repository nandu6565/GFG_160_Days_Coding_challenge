import java.util.Scanner;

public class MaxSubarraySum {
    public static int maxSubarraySum(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
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

        int result = maxSubarraySum(arr);
        System.out.println("Maximum subarray sum is: " + result);

        sc.close();
    }
}
