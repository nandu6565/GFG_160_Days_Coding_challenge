import java.util.*;

public class MajorityElementII {
    public static List<Integer> majorityElementOptimal(int[] arr) {
        int n = arr.length;

        // Step 1: Finding potential candidates
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == candidate1) { // Increment count for candidate1
                count1++;
            } else if (num == candidate2) { // Increment count for candidate2
                count2++;
            } else if (count1 == 0) { // Assign candidate1 if count1 is 0
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) { // Assign candidate2 if count2 is 0
                candidate2 = num;
                count2 = 1;
            } else { // Decrement both counts if num matches neither candidate
                count1--;
                count2--;
            }
        }

        // Step 2: Validate the candidates
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1); // Add candidate1 if valid
        if (count2 > n / 3) result.add(candidate2); // Add candidate2 if valid

        // Step 3: Ensure the result is sorted in ascending order
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<Integer> result = majorityElementOptimal(arr);

        System.out.println("Majority elements (more than n/3 times): " + result);
    }
}
