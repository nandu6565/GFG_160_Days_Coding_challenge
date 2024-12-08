import java.util.*;

class MergeOverlap {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Sort intervals based on the start times
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = arr[0];
        merged.add(currentInterval);

        // Iterate through the intervals
        for (int i = 1; i < arr.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];

            // Check for overlap
            if (currentEnd >= nextStart) {
                // Merge intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval
                currentInterval = arr[i];
                merged.add(currentInterval);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        int[][] arr = new int[n][2];
        System.out.println("Enter the intervals (start and end):");

        // Take the intervals as input
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        MergeOverlap solution = new MergeOverlap();
        List<int[]> result = solution.mergeOverlap(arr);

        // Print the merged intervals
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

        scanner.close();
    }
}
