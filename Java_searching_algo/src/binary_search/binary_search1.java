package binary_search;

public class binary_search1 {

	 public static int binarySearch(int[] arr, int x) {
	        int left = 0;
	        int right = arr.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
//	            int mid=(left+right)/2;
	            if (arr[mid] == x) {
	                return mid; 
	            }
	            if (arr[mid] < x) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return -1; 
	    }

	    public static void main(String[] args) {
	        int[] arr = { 1, 2, 4, 5, 8 }; 
	        int x = 4;
	        int result = binarySearch(arr, x);
	        if (result == -1) {
	            System.out.println("Element not found");
	        } else {
	            System.out.println("Element found at index: " + result);
	        }
	    }
}
