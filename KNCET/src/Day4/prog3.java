package Day4;

public class prog3 {

	public static void main(String[] args)
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(j>3)
				{
					return;
				}
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
}
