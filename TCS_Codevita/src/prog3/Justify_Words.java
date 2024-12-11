package prog3;
import java.util.*;

public class Justify_Words {
    static int K;
    static List<String> words = new ArrayList<>();
    static int N, M;
    static Map<String, Integer> wordIndices = new HashMap<>();
    static int[] wordLengths;
    static int maxWordsPerLine;
    static List<int[]> possibleLineCombinations = new ArrayList<>();
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        K = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < K; i++) {
            words.add(scanner.nextLine().strip());
        }

        String[] nm = scanner.nextLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        // Remove words longer than M
        words.removeIf(word -> word.length() > M);

        if (words.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Assign indices to words
        wordIndices.clear();
        for (int i = 0; i < words.size(); i++) {
            wordIndices.put(words.get(i), i);
        }

        wordLengths = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            wordLengths[i] = words.get(i).length();
        }

        maxWordsPerLine = M;

        // Generate all possible combinations of words that can fit into a line
        for (int r = 1; r <= words.size(); r++) {
            if (r > M) break;
            for (int[] combo : combinations(words.size(), r)) {
                int totalLength = 0;
                for (int i : combo) {
                    totalLength += wordLengths[i];
                }
                totalLength += combo.length - 1; // For spaces
                if (totalLength <= M) {
                    int comboMask = 0;
                    for (int i : combo) {
                        comboMask |= (1 << i);
                    }
                    possibleLineCombinations.add(new int[] { comboMask, combo.length });
                }
            }
        }

        // Use DFS with memoization
        int maxTotalWords = dfs(0, 0);
        System.out.println(maxTotalWords);
    }

    // Function to generate combinations of indices
    public static List<int[]> combinations(int n, int r) {
        List<int[]> result = new ArrayList<>();
        int[] data = new int[r];
        combinationsUtil(n, r, 0, data, result);
        return result;
    }

    // Helper function to generate combinations
    private static void combinationsUtil(int n, int r, int index, int[] data, List<int[]> result) {
        if (index == r) {
            result.add(data.clone());
            return;
        }
        for (int i = (index == 0 ? 0 : data[index - 1] + 1); i < n; i++) {
            data[index] = i;
            combinationsUtil(n, r, index + 1, data, result);
        }
    }

    // DFS with memoization
    public static int dfs(int currentLine, int usedWordsMask) {
        if (currentLine == N) {
            return 0;
        }

        String key = currentLine + "," + usedWordsMask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxWords = 0;

        // Try all possible line combinations
        for (int[] combo : possibleLineCombinations) {
            int comboMask = combo[0];
            int wordCount = combo[1];
            if ((comboMask & usedWordsMask) == 0) {
                int newUsedWordsMask = usedWordsMask | comboMask;
                int totalWords = wordCount + dfs(currentLine + 1, newUsedWordsMask);
                maxWords = Math.max(maxWords, totalWords);
            }
        }

        // Option to leave the line empty
        int totalWords = dfs(currentLine + 1, usedWordsMask);
        maxWords = Math.max(maxWords, totalWords);

        memo.put(key, maxWords);
        return maxWords;
    }
}