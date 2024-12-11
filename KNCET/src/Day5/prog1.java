package Day5;

import java.util.Scanner;

public class prog1 {

	public static void main(String[] args) {
	
   Scanner scan=new Scanner(System.in);
   String name=scan.next();//aadham
   String reverse="";
   for(int i=name.length()-1;i>=0;i--)
   {
	   reverse=reverse+name.charAt(i);
   }
   if(name.equals(reverse))
   {
	   System.out.println("Palindrome");
   }
   else
   {
	   System.out.println("Not palindrome");
   }
  
   
   
   
	   
	}
}
