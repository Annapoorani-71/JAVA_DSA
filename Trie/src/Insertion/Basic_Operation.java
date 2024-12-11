package Insertion;

public class Basic_Operation {
    static TrieNode root;

    public Basic_Operation() {
        root = new TrieNode();
    }

    // Insert method
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.wordEnd = true;
    }

    // Search method
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return current.wordEnd;
    }

    // StartsWith method
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return true;
    }

    // Read (DFS) - Returns a list of words from the Trie
    public void read() {
        StringBuilder word = new StringBuilder();
        DFS(root, word);
    }

    private void DFS(TrieNode node, StringBuilder word) {
        if (node == null) return;

        // If the node represents the end of a word, print the word
        if (node.wordEnd) {
            System.out.println(word.toString());
        }

        // Traverse all possible children (26 letters)
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                word.append((char) (i + 'a')); // Add the current character to the word
                DFS(node.child[i], word); // Recurse for the child node
                word.deleteCharAt(word.length() - 1); // Backtrack by removing the last character
            }
        }
    }

    // Update method - Changes an existing word
    public void update(String oldWord, String newWord) {
        // First delete the old word if it exists
        delete(oldWord);

        // Then insert the new word
        insert(newWord);
    }

    // Delete method - Removes a word from the Trie
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (node == null) {
            return false; // If node is null, the word doesn't exist
        }

        // If we've reached the end of the word
        if (index == word.length()) {
            if (!node.wordEnd) {
                return false; // Word doesn't exist
            }
            node.wordEnd = false; // Mark the word as not ending here

            // Check if the current node has any children. If no children, we can delete it.
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    return false; // If it has children, don't delete this node
                }
            }
            return true; // Node can be deleted
        }

        // Continue to delete recursively
        int charIndex = word.charAt(index) - 'a';
        boolean shouldDeleteCurrentNode = delete(node.child[charIndex], word, index + 1);

        // If the child node can be deleted, remove the reference from this node
        if (shouldDeleteCurrentNode) {
            node.child[charIndex] = null;

            // Check if the current node has any children or is an end of any word
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    return false; // If it has children, don't delete the current node
                }
            }

            // If no children and it's not an end of another word, it can be deleted
            return !node.wordEnd;
        }

        return false; // If we couldn't delete the current node, return false
    }

    // Main method to test the Trie functionality
    public static void main(String[] args) {
        Basic_Operation t = new Basic_Operation();
        t.insert("hello");
        t.insert("catch");
        t.insert("cat");

        System.out.println(t.search("cat")); // true
        System.out.println(t.search("code")); // false
        System.out.println(t.startsWith("hell")); // true

        System.out.println("All words in the Trie:");
        t.read(); // Prints all words in the Trie using DFS

        // Test update and delete operations
        t.update("catch", "catcher");
        System.out.println("After updating 'catch' to 'catcher':");
        t.read(); // Prints updated Trie

        t.delete("cat");
        System.out.println("After deleting 'cat':");
        t.read(); // Prints remaining words
    }
}
