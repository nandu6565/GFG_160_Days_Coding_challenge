import java.util.ArrayList;
import java.util.Scanner;

class SearchPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text string: ");
        String txt = sc.nextLine();

        
        System.out.print("Enter the pattern string: ");
        String pat = sc.nextLine();

        SearchPattern solution = new SearchPattern();
        
        ArrayList<Integer> result = solution.search(pat, txt);

       
        if (result.isEmpty()) {
            System.out.println("No occurrences found.");
        } else {
            System.out.println("Pattern found at indices: " + result);
        }

        sc.close(); 
    }

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length(); 
        int n = txt.length(); 
        
        int[] lps = computeLPSArray(pat, m);
        
        int i = 0; 
        int j = 0; 
        
        while (i < n) {
            // If characters match, move both pointers
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            // If a complete match is found
            if (j == m) {
                result.add(i - j); // Store the starting index
                j = lps[j - 1]; // Reset j to the last matched prefix
            } 
            // If characters do not match and j > 0, use LPS to avoid unnecessary comparisons
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    // Helper function to compute the LPS (Longest Prefix Suffix) array
    private int[] computeLPSArray(String pat, int m) {
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character
        
        lps[0] = 0; // First character has no proper prefix or suffix
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++; // Increment the length of the prefix suffix
                lps[i] = len; // Update LPS for position i
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Reset len using the previous LPS value
                } else {
                    lps[i] = 0; // No prefix suffix for position i
                    i++;
                }
            }
        }
        
        return lps;
    }
}
