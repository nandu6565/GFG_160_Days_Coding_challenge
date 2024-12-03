import java.util.Scanner;

class MinCharPalindrome {
    public static int minChar(String s) {
        int n = s.length();
        // Reverse the string
        String reversedS = new StringBuilder(s).reverse().toString();
        // Concatenate original and reversed string with a special character
        String concat = s + "#" + reversedS;
        // Compute LPS array for the concatenated string
        int[] lps = computeLPS(concat);
        // The minimum characters to add
        return n - lps[concat.length() - 1];
    }
    
    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Backtrack
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        int result = minChar(input);
        System.out.println("Minimum characters to add to make the string a palindrome: " + result);
        scanner.close();
    }
}
