import java.util.Scanner;

class StringToInt {
    public static int myAtoi(String s) {
        int index = 0, sign = 1, n = s.length();
        long result = 0;

        // Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Check for '+' or '-' sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        //Parse digits and handle overflow
        while (index < n && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');

            // Clamp to 32-bit integer bounds
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        return (int) (result * sign);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string to convert to an integer: ");
        String input = scanner.nextLine();

        // Convert string to integer using myAtoi
        int result = myAtoi(input);

        // Print the result
        System.out.println("Converted integer: " + result);

        scanner.close();
    }
}
