import java.util.Scanner;

public class StockBuySell {
    public static int maximumProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
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
