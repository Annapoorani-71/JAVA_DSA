package PrefixSum;
//KMP ALGORITHM
import java.util.ArrayList;
import java.util.List;

public class KMP_Knuth_Morris_Pratt {

    public static List<Integer> prefixFunction(String s) {
        int n = s.length();
        List<Integer> pi = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            pi.add(0); 

            for (int j = 0; j < i; j++) {
                
                if (s.substring(0, j + 1).equals(s.substring(i - j, i + 1))) {
                    pi.set(i, j + 1); 
                }
            }
        }

        return pi;
    }

    // Driver Code
    public static void main(String[] args) {
        String s = "abcabcabc";
        List<Integer> result = prefixFunction(s);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}


