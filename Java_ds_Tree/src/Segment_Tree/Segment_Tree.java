package Segment_Tree;

class Segment_Tree {
    private int[] tree; // The segment tree array
    private int n;      // Size of the original array

    // Constructor to build the segment tree
    public Segment_Tree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // A segment tree can require up to 4*n space
        build(arr, 0, 0, n - 1);
    }

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start]; // Leaf node will have a single element
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);      // Left child
            build(arr, 2 * node + 2, mid + 1, end);    // Right child
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // Internal node will have the sum of both children
        }
    }

    // Range sum query from l to r
    public int rangeSum(int l, int r) {
        return rangeSum(0, 0, n - 1, l, r);
    }

    // Recursive function to get the sum in range
    private int rangeSum(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // Range represented by a node is completely outside the given range
        }
        if (l <= start && end <= r) {
            return tree[node]; // Range represented by a node is completely inside the given range
        }
        // Range is partially inside and partially outside
        int mid = (start + end) / 2;
        int sumLeft = rangeSum(2 * node + 1, start, mid, l, r);
        int sumRight = rangeSum(2 * node + 2, mid + 1, end, l, r);
        return sumLeft + sumRight;
    }

    // Point update in the segment tree
    public void update(int index, int value) {
        update(0, 0, n - 1, index, value);
    }

    // Recursive function to update a value in the segment tree
    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value; // Leaf node
        } else {
            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                update(2 * node + 1, start, mid, index, value);
            } else {
                update(2 * node + 2, mid + 1, end, index, value);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // Update the current node's sum
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        Segment_Tree segmentTree = new Segment_Tree(arr);

        System.out.println("Sum of values in range [1, 3]: " + segmentTree.rangeSum(1, 3)); // Output: 15
        segmentTree.update(1, 10); // Update arr[1] to 10
        System.out.println("Sum of values in range [1, 3]: " + segmentTree.rangeSum(1, 3)); // Output: 22
    }
}
