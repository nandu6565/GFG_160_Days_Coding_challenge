import java.util.Scanner;

public class AnagramCheck {

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency array for lowercase letters
        int[] frequency = new int[26];

        // Count character frequencies
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++; 
            frequency[s2.charAt(i) - 'a']--; 
        }

        // Check if all frequencies are zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String s1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String s2 = scanner.nextLine();

        if (isAnagram(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }
}
