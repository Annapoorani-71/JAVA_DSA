package Day4;
import java.util.Scanner;
//product of digits in a number
public class Prog1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		
		int pro=1;
		while(num>0)
		{
			int b=num%10;
			pro=pro*b;
			num=num/10;
		}
		
		System.out.println(pro);
		
		
		
		
		
	}

}
