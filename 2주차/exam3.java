package assignment_week_1;
import java.util.Scanner;


public class exam3 {
	
	int num1, num2;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("���� x�� �Է����ּ��� : ");		// x, y �Է¹���
		int x = sc.nextInt();
		System.out.print("���� y�� �Է����ּ��� : ");
		int y = sc.nextInt();
		
		double x2 = x;								// ������ ���� x�� double�� ������ ����
		
		System.out.println("\"" + x + "/" + y + "�� ���� " + x2/y + "�Դϴ�.\"");
		
		System.out.println("\"" + x + "/" + y + "�� ���� " + x/y + "�̰� �������� " + x%y + "�Դϴ�.\"");
		
	}

}
