import java.util.Scanner;

public class AddBinaryStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first binary string:");
        String s1 = scanner.nextLine();

        System.out.println("Enter the second binary string:");
        String s2 = scanner.nextLine();

        String result = addBinary(s1, s2);

        System.out.println("The sum of the binary strings is: " + result);

        scanner.close();
    }

    public static String addBinary(String s1, String s2) {
        int i = s1.length() - 1; 
        int j = s2.length() - 1; 
        int carry = 0;           
        StringBuilder result = new StringBuilder(); 

        while (i >= 0 || j >= 0 || carry > 0) {
            // Get the binary digit or 0 if index is out of bounds
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0;

            // Compute the sum of bits and carry
            int sum = bit1 + bit2 + carry;

            // Append the current bit to the result (sum % 2)
            result.append(sum % 2);

            // Update carry (sum / 2)
            carry = sum / 2;

            i--;
            j--;
        }

        // Reverse the result since we built it backward
        String finalResult = result.reverse().toString();

        // Remove leading zeros, if any
        int startIndex = 0;
        while (startIndex < finalResult.length() && finalResult.charAt(startIndex) == '0') {
            startIndex++;
        }

        // Return "0" if all are zeros, else the trimmed result
        return startIndex == finalResult.length() ? "0" : finalResult.substring(startIndex);
    }
}
