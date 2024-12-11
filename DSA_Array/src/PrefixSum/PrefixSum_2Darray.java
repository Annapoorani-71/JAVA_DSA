package PrefixSum;

public class PrefixSum_2Darray {
   public static void main(String[] args) {
	   
	   
	   int n = 6;  
	   int[] pf = new int[n + 2];  
	   
	   int[][] q = { { 2, 3 }, 
			         { 4, 6 }, 
			         { 1, 5 }, 
			         { 3, 6 } };
	   
	  
	   for (int i = 1; i <= n; i++) {
	       pf[i] = pf[i - 1] + i;  
	   }
	   
	  
	   for (int i = 0; i < q.length; i++) {
	       int l = q[i][0];
	       int r = q[i][1];

	       System.out.print(pf[r] - pf[l - 1] + "\n");
	   }
	   
	   System.out.println("Prefix sum array:");
	   for (int i = 0; i < pf.length; i++) {
	       System.out.print(pf[i] + " ");
	   }
   }
}
