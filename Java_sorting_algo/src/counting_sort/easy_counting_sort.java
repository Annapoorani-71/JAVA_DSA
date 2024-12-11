package counting_sort;

//refer the jennys lecture
public class easy_counting_sort {
   public static void main(String[] args) {
	int[] arr= {1,2,3,3,4,4,5,3,2,1};
	int n=arr.length;
	int[] count=new int[10];
	int k=5;   //max value
	for(int i=0;i<n;i++)
	{
		++count[arr[i]];
	}
	System.out.println("counting the countable array");
	for(int i=0;i<count.length;i++)
	{
		System.out.print(count[i]+" "+i);
		System.out.println();
	}

	for(int i=1;i<=k;i++)
	{
		count[i]=count[i]+count[i-1];
	}
	System.out.println("reallocating the couting array to find out the position");
	for(int i=0;i<count.length;i++)
	{
		System.out.print(count[i]+" "+i);
		System.out.println();
	}
	int[] brr=new int[n];
	for(int i=n-1;i>=0;i--)
	{
		brr[--count[arr[i]]]=arr[i];
	}
	
	System.out.println("printing the sorted array");
	for(int i=0;i<brr.length;i++)
	{
		System.out.print(brr[i]+" "+i);
		System.out.println();
	}
	
	for(int i=0;i<n;i++)
	{
		arr[i]=brr[i];
	}
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
}


//time complexity-> O(n+k)
//space complexity-> 
