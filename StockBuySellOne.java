import java.util.Scanner;

public class StockBuySellOne {
    public static int maximumProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();

        System.out.println("Enter the stock prices:");
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxProfit = maximumProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
