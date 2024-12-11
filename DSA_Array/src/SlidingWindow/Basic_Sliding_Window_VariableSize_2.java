package SlidingWindow;

public class Basic_Sliding_Window_VariableSize_2 {
    public static int maxSumVariableWindow(int[] arr, int maxSum) {
        int currentSum = 0;
        int left = 0;
        int max_sum = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right]; // Add the rightmost element to the current sum

            // Shrink the window from the left if the current sum exceeds maxSum
            while (currentSum > maxSum && left <= right) {
                currentSum -= arr[left]; // Remove the leftmost element
                left++; // Move the left pointer to the right
            }

            // Update the maximum sum found so far
            max_sum = Math.max(max_sum, currentSum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int maxSum = 7; // Set maximum sum limit
        System.out.println("Maximum sum of subarray with variable size: " + maxSumVariableWindow(arr, maxSum));
    }
}
