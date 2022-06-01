/*
 동국대학교 2020112046 이재원
 객체지향프로그래밍 3주차 실습
 */

package assignment_week_2;

import java.util.Scanner;

public class calculator {
	
	int num1;
	int num2;
	Scanner sc = new Scanner(System.in);
	
	public calculator()
	{
		num1 = 1;					//값을 입력받을 변수 선언
		num2 = 1;
	}
	
	public void addition()			//덧셈 메소드
	{
		System.out.println("[Addition]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 + num2 = " + (num1+num2));
	}
	public void subtraction()		//뺄셈 메소드
	{
		System.out.println("[Subtraction]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 - num2 = " + (num1-num2));
	}
	public void multiply()			//곱셈 메소드
	{
		System.out.println("[Multiply]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		System.out.println("num1 * num2 = " + (num1*num2));
	}
	public void division()			//나눗셈 메소드
	{
		System.out.println("[Division]");
		System.out.print("Input num1:");
		num1 = sc.nextInt();
		System.out.print("Input num2:");
		num2 = sc.nextInt();
		if(num2 == 0)				//0으로 나누기 시도 시의 예외처리
		{
			System.out.println("Cannot be divided by 0");
		}
		else
		{
			System.out.println("num1 / num2 = " + ((num1*1.000)/num2));		//나눗셈 결과를 실수로 표현하기 위한 1.000 곱해주기
		}
	}
	
	
	public static void main(String[] args) 		//메인 메소드
	{
		calculator cc = new calculator();
		int select_mode = 0;
		
		while(true)								//5를 입력할 때까지 반복 실행 메뉴
		{
			System.out.println("select menu");
			System.out.println("1: addition");
			System.out.println("2: subtraction");
			System.out.println("3: multiply");
			System.out.println("4: division");
			System.out.println("5: exit");
			
			select_mode = cc.sc.nextInt();		//실행할 메뉴 입력
			
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
					System.out.println("Program exit");		//5 입력 시 종료
					System.exit(0);
					break;
			}
		}
	}
}
