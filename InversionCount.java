import java.util.Scanner;

class InversionCount {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    // Helper function to perform merge sort and count inversions.
    static int mergeSortAndCount(int arr[], int temp[], int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            // Count inversions in the left half.
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half.
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions while merging the two halves.
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }
    // Function to merge two sorted halves and count inversions.
    static int mergeAndCount(int arr[], int temp[], int left, int mid, int right) {
        int i = left;   // Starting index for left subarray.
        int j = mid + 1; // Starting index for right subarray.
        int k = left;   // Starting index to be merged.
        int invCount = 0;
        // Compare elements from both subarrays and merge them.
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in the left subarray form inversions with arr[j].
                invCount += (mid - i + 1);
            }
        }
        // Copy the remaining elements from the left subarray, if any.
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Copy the remaining elements from the right subarray, if any.
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // Copy the merged subarray back into the original array.
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt(); 

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }

        int result = inversionCount(arr);
        System.out.println("Inversion Count: " + result);

        sc.close();
    }
}
