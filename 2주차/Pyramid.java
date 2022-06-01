package assignment_week_1;
import java.util.Scanner;

public class Pyramid {
	
	char ss = '*';
	int num = 3;
	
	Scanner sc = new Scanner(System.in);
	
	public void Printstar()
	{
		for (int i=0; i<num; i++)				// 입력받은 문자와 숫자(행 수)로 피라미드 출력하는 반복문
		{
			for (int j = 1; j < num - i; j++)
			{
				System.out.print(" ");
			}
			for (int k=0; k < i * 2 + 1; k++)
			{
				System.out.print(ss);
			}
			System.out.println();
		}
	}
	
	public void Setinfo() 						// 입력 안내문 출력
	{
		System.out.print("Input character : ");
		ss= sc.nextLine().charAt(0);
		System.out.print("Input line number : ");
		num = sc.nextInt();
	}
}
