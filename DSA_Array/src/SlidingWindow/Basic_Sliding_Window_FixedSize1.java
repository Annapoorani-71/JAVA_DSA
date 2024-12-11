//Sliding Window Maximum (Maximum of all subarrays of size K)
//Input: arr[] = {1, 2, 3, 1, 4, 5}, K = 3 
//Output: 3 3 4 5
//Explanation: Maximum of 1, 2, 3 is 3
//                       Maximum of 2, 3, 1 is 3
//                       Maximum of 3, 1, 4 is 4
//                       Maximum of 1, 4, 5 is 5

package SlidingWindow;

public class Basic_Sliding_Window_FixedSize1 {
	
		 static void printKMax(int arr[], int N, int K)
		 {
		     int j, max;
		
		     for (int i = 0; i <= N - K; i++) {
		
		         max = arr[i];
		
		         for (j = 1; j < K; j++) {
		             if (arr[i + j] > max)
		                 max = arr[i + j];
		         }
		         System.out.print(max + " ");
		     }
		 }

	 public static void main(String args[])
	 {
	     int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	     int K = 3;
	     printKMax(arr, arr.length, K);
	 }
}

