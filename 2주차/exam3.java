package assignment_week_1;
import java.util.Scanner;


public class exam3 {
	
	int num1, num2;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 x를 입력해주세요 : ");		// x, y 입력받음
		int x = sc.nextInt();
		System.out.print("정수 y를 입력해주세요 : ");
		int y = sc.nextInt();
		
		double x2 = x;								// 나눗셈 위해 x를 double형 변수로 저장
		
		System.out.println("\"" + x + "/" + y + "의 값은 " + x2/y + "입니다.\"");
		
		System.out.println("\"" + x + "/" + y + "의 몫은 " + x/y + "이고 나머지는 " + x%y + "입니다.\"");
		
	}

}
