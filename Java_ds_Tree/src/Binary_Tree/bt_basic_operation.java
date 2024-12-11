package Binary_Tree;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Insert a node into the binary tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search a node in the binary tree
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // Delete a node from the binary tree
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
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

    // Find the minimum value node in the tree
    public int findMin() {
        return findMin(root);
    }

    private int findMin(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Find the maximum value node in the tree
    public int findMax() {
        return findMax(root);
    }

    private int findMax(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    // Get the height of the binary tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count the number of nodes in the binary tree
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    // Find the successor of a given node in the binary tree
    public Node getSuccessor(Node node) {
        if (node.right != null) {
            return findMinNode(node.right);
        }
        Node successor = null;
        Node ancestor = root;
        while (ancestor != node) {
            if (node.data < ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    private Node findMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void display() {
        inorder();
        System.out.println();
    }
}


public class bt_basic_operation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.display();

        System.out.println("Pre-order traversal:");
        tree.preorder();
        System.out.println();

        System.out.println("Post-order traversal:");
        tree.postorder();
        System.out.println();

        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());

        System.out.println("Height of tree: " + tree.height());

        System.out.println("Total number of nodes: " + tree.countNodes());

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 90: " + tree.search(90));

        System.out.println("Deleting node 20");
        tree.delete(20);
        System.out.println("In-order traversal after deletion:");
        tree.display();

        Node successor = tree.getSuccessor(tree.root.left);
        System.out.println("Successor of " + tree.root.left.data + " is " + (successor != null ? successor.data : "null"));
    }
}
