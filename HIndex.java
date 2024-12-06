import java.util.Arrays;
import java.util.Scanner;

class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int hIndex = 0;

        // Iterate from the end of the array to find the largest h-index
        for (int i = 0; i < n; i++) {
            // Check the number of papers with at least (n - i) citations
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of papers: ");
        int n = scanner.nextInt();

        int[] citations = new int[n];

        System.out.println("Enter the citations for each paper:");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        int result = hIndex(citations);
        System.out.println("The H-Index is: " + result);

        scanner.close();
    }
}
