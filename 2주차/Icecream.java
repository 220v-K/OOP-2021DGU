package assignment_week_1;

import java.util.Scanner;

public class Icecream {

	public String name;
	public int price;
	public int Numberoficecream;
	
	Scanner sc = new Scanner(System.in);
	
	public void Setinfo() 								// ���� �Է�
	{
		System.out.print("Icecream name : ");
		name = sc.nextLine();
		System.out.print("Icecream price : ");
		price = sc.nextInt();
		System.out.print("Number of icecreams : ");
		Numberoficecream = sc.nextInt();
	}
	
	public void Printinfo()								// ���� ���
	{
		System.out.println("Icecream name is " + name);
		System.out.println("Icecream price is " + price);
		System.out.println("There is " + Numberoficecream + " icecreams");
	}
}
