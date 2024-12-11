package Rabin_Karp_Algo;

public class Rabin_Karp_Algo_1
{
    private static final int d = 26; // Base value of alphabets (number of characters)
    private static final int p = 5381; // Large prime number

    public static void search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int patHash = 0; // Hash value of pattern
        int txtHash = 0; // Hash value of current text window
        int h = 1;

        // The value of h would be "pow(d, M-1) % p"
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % p;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < M; i++) {
            patHash = (d * patHash + (pat.charAt(i) - 'A' + 1)) % p;
            txtHash = (d * txtHash + (txt.charAt(i) - 'A' + 1)) % p;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {

            // Check if the current window's hash matches the pattern's hash
            if (patHash == txtHash) {
                // Check character by character in case of hash collision
                boolean found = true;
                for (int j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Update the hash for the next window of text:
            if (i < N - M) {
                txtHash = (d * (txtHash - (txt.charAt(i) - 'A' + 1) * h) + (txt.charAt(i + M) - 'A' + 1)) % p;

                // We might get a negative value of txtHash, converting it to positive
                if (txtHash < 0) {
                    txtHash = (txtHash + p);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        String txt = "AABAACBAA";
        String pat = "BAA";

        search(pat, txt);
    }
}
