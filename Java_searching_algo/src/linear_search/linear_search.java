package linear_search;

public class linear_search {

	public static void main(String[] args) {
		int key=10;
		int arr[]= {10,20,30,40,50};
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==key)
			{
				index=i+1;
				System.out.println("key found in the index: "+index);
				return;
			}
		}
		System.out.println("key not found in the index: "+index);
	}
}
