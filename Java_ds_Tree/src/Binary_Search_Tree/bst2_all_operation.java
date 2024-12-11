package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {

    // Insert a node into the BST
    public BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Search for a node in the BST
    public boolean search(BSTNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return data < root.data ? search(root.left, data) : search(root.right, data);
    }

    // Delete a node from the BST
    public BSTNode deleteRec(BSTNode root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    // Find the minimum value in the BST
    public int findMin(BSTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Find the maximum value in the BST
    public int findMax(BSTNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Get the height of the BST
    public int height(BSTNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count the number of nodes in the BST
    public int countNodes(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // In-order traversal (left-root-right)
    public void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal (root-left-right)
    public void preorder(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal (left-right-root)
    public void postorder(BSTNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Breadth-First Search (BFS) traversal
    public void bfs(BSTNode root) {
        if (root == null) {
            return;
        }
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Depth-First Search (DFS) traversal
    public void dfs(BSTNode root) {
        if (root == null) {
            return;
        }
        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTNode current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
}

// Testing the BinarySearchTree
public class bst2_all_operation {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode root = null;

        // Insert nodes into the BST using insertRec
        root = bst.insertRec(root, 50);
        root = bst.insertRec(root, 30);
        root = bst.insertRec(root, 70);
        root = bst.insertRec(root, 20);
        root = bst.insertRec(root, 40);
        root = bst.insertRec(root, 60);
        root = bst.insertRec(root, 80);

        System.out.println("In-order traversal:");
        bst.inorder(root);
        System.out.println();

        System.out.println("Pre-order traversal:");
        bst.preorder(root);
        System.out.println();

        System.out.println("Post-order traversal:");
        bst.postorder(root);
        System.out.println();

        System.out.println("Breadth-First Search (BFS):");
        bst.bfs(root);
        System.out.println();

        System.out.println("Depth-First Search (DFS):");
        bst.dfs(root);
        System.out.println();

        System.out.println("Minimum value: " + bst.findMin(root));
        System.out.println("Maximum value: " + bst.findMax(root));
        System.out.println("Height of the tree: " + bst.height(root));
        System.out.println("Total number of nodes: " + bst.countNodes(root));

        System.out.println("Search 40: " + bst.search(root, 40));
        System.out.println("Search 90: " + bst.search(root, 90));

        System.out.println("Deleting node 20");
        root = bst.deleteRec(root, 20);
        System.out.println("In-order traversal after deletion:");
        bst.inorder(root);
        System.out.println();
    }
}
