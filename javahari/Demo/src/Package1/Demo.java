package Package1;

public class Demo {

   public static void main(String[] args) {
	   int[] arr= {1,3,4,5,6};
	   
	   int[] arr1=new int[10];
	   int sum=0;
	   
	   for(int i=0;i<arr.length;i++)
	   {
		   sum+=arr[i];
		   System.out.println(sum);
	   }
	   
   }
}
