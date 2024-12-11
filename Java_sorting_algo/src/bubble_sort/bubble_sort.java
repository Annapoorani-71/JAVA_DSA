package bubble_sort;

public class bubble_sort {
	    public static void bubbleSort(int[] arr) {
	        int n = arr.length;// 5
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = { 3, 1, 4, 2, 5 };
	        bubbleSort(arr);
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	

}
