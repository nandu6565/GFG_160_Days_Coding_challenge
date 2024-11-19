import java.util.Scanner;

class NextPermutation {
    public void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: Find the first decreasing element from the end
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If such an element is found, find the smallest element larger than arr[i]
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 4: Reverse the segment to the right of i
        reverse(arr, i + 1, n - 1);
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
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

        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(arr);

        System.out.println("The next permutation is:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
