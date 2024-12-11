package selection_sort;

public class selection_sort {
	public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;//minindex=0
            for (int j = i + 1; j < n; j++) {//j=
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; }}
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 2, 1 };
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
