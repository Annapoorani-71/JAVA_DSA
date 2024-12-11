package PrefixSum;

public class PrefixSum_1Darray {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		int result[]=new int[arr.length];
		result[0]=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			result[i]=result[i-1]+arr[i];
		}
		
		for(int i:result)
		{
			System.out.print(i+" ");
		}
	}
	
//	public static void main(String[] args) {
//		  int n = 6;
//	        int[] a = { 3, 6, 2, 8, 9, 2 };
//	        int[] result = new int[n+1];
//	        result[0] = 0;//unwanted line itself
//	        for (int i = 0; i < n; i++) {
//	        	result[i + 1] = result[i] + a[i];
//	        }
//	        for(int i:result)  //better go for normal for loop
//	        {
//	        	System.out.println(i);
//	        }
//	}
//	
	
	
	
	
}
