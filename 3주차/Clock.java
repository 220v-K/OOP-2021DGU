/*
 �������б� 2020112046 �����
 ��ü�������α׷��� 3���� �ǽ�
 */

package assignment_week_2;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Clock {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat form1 = new SimpleDateFormat("HH:mm:ss");		//Data Form ����
		
		int select_mode = 0;
		int out_key = 0;
		long time1, time2;
		
		while(true)				//3 �Է½� ���� ���� ���� �޴�
		{
			System.out.println("select menu");
			System.out.println("1: current time");
			System.out.println("2: timer");
			System.out.println("3: exit");
			
			select_mode = sc.nextInt();		//������ �޴��� �Է�
			
			switch(select_mode)
			{
				case 1:						//1�� �Է� �� ���� �ð� ���
					System.out.println("���� �ð��� " + form1.format(System.currentTimeMillis()) + "�Դϴ�.");
					System.out.println();
					break;
					
				case 2:						//2�� �Է� �� Ÿ�̸� �۵�
					System.out.println("1�� �Է��ϸ� Ÿ�̸Ӱ� ����ϴ�.");
					time1 = System.currentTimeMillis();		//Ÿ�̸� ����
					while(out_key != 1)						//1�� �Է��ϱ� �������� Ÿ�̸Ӹ� �������� ����
					{
						out_key = sc.nextInt();
					}
					time2 = System.currentTimeMillis();
					System.out.println("�ð� ����" + (time2-time1)/1000.000 + "�� �Դϴ�.");
					out_key = 0;							//Ÿ�̸Ӹ� �ٽ� �������� ��, out_key�� 1�̸� �ٷ� ����ǹǷ�, 0���� �ʱ�ȭ
					break;
					
				case 3:						//3�� �Է� �� ���α׷� ����
					System.out.println("Program exit");
					System.exit(0);
					break;
			}
		}
	}
}
