/*
 �������б� 2020112046 �����
 ��ü�������α׷��� 3���� �ǽ�
 */

package assignment_week_2;

import java.util.Scanner;

public class calculator {
	
	int num1;
	int num2;
	Scanner sc = new Scanner(System.in);
	
	public calculator()
	{
		num1 = 1;					//���� �Է¹��� ���� ����
		num2 = 1;
	}
	
	public void addition()			//���� �޼ҵ�
	{
		System.out.println("[Addition]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 + num2 = " + (num1+num2));
	}
	public void subtraction()		//���� �޼ҵ�
	{
		System.out.println("[Subtraction]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 - num2 = " + (num1-num2));
	}
	public void multiply()			//���� �޼ҵ�
	{
		System.out.println("[Multiply]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 * num2 = " + (num1*num2));
	}
	public void division()			//������ �޼ҵ�
	{
		System.out.println("[Division]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		if(num2 == 0)				//0���� ������ �õ� ���� ����ó��
		{
			System.out.println("Cannot be divided by 0");
		}
		else
		{
			System.out.println("num1 / num2 = " + ((num1*1.000)/num2));		//������ ����� �Ǽ��� ǥ���ϱ� ���� 1.000 �����ֱ�
		}
	}
	
	
	public static void main(String[] args) 		//���� �޼ҵ�
	{
		calculator cc = new calculator();
		int select_mode = 0;
		
		while(true)								//5�� �Է��� ������ �ݺ� ���� �޴�
		{
			System.out.println("select menu");
			System.out.println("1: addition");
			System.out.println("2: subtraction");
			System.out.println("3: multiply");
			System.out.println("4: division");
			System.out.println("5: exit");
			
			select_mode = cc.sc.nextInt();		//������ �޴� �Է�
			
			switch(select_mode)
			{
				case 1:
					cc.addition();
					break;
				case 2:
					cc.subtraction();
					break;
				case 3:
					cc.multiply();
					break;
				case 4:
					cc.division();
					break;
				case 5:
					System.out.println("Program exit");		//5 �Է� �� ����
					System.exit(0);
					break;
			}
		}
	}
}
