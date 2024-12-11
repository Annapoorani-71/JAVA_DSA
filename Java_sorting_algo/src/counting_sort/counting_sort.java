package counting_sort;

public class counting_sort {
	 public static void countingSort(int[] arr) {
	        int n = arr.length;
	        int max = 0;
	        for (int num : arr) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        int[] count = new int[max + 1];  // 0 1 2 3 4 5
	        int[] output = new int[n];   // 0 1 2 3 

	        for (int num : arr) {
	            count[num]++;          
	        }
	        for (int i = 1; i <= max; i++) {
	            count[i] += count[i - 1];
	        }
	        for (int i = n - 1; i >= 0; i--) {
	            output[count[arr[i]] - 1] = arr[i];
	            count[arr[i]]--;
	        }
	        for (int i = 0; i < n; i++) {
	            arr[i] = output[i];
	        }
	        
	    }

	    public static void main(String[] args) {
	        int[] arr = { 5, 1, 4, 2};
	        countingSort(arr);
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
}
