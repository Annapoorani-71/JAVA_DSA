package Insertion;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean wordEnd = false;
}

class Insertion {
    static void insertKey(TrieNode root, String key) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.child[c - 'a'] = newNode;
            }
            curr = curr.child[c - 'a'];
        }
        curr.wordEnd = true;
    }

    static boolean searchKey(TrieNode root, String key) {

        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.child[c - 'a'] == null) 
                return false;
            curr = curr.child[c - 'a'];
        }
        return curr.wordEnd;
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        List<String> arr = Arrays.asList(
            "and", "ant");
        for (String s : arr) {
            insertKey(root, s);
        }
        List<String> searchKeys = 
              Arrays.asList("do", "gee", "bat","ant");
        for (String s : searchKeys) {
            System.out.println("Key : " + s);
            if (searchKey(root, s)) 
                System.out.println("Present");
            else 
                System.out.println("Not Present");        
        }
    }
}
