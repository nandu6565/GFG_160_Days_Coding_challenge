import java.util.Scanner;

public class MaxProductSubarray {
    public static int maxProduct(int[] arr) {
        int pre = 1;
        int suff = 1;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0) {
                pre = 1;
            }
            if (suff == 0) {
                suff = 1;
            }

            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;
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

        int result = maxProduct(arr);
        System.out.println("Maximum product of subarray is: " + result);

        sc.close();
    }
}
