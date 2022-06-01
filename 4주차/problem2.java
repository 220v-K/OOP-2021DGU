package assignment_week_4;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class inputwords
{
	Scanner sc = new Scanner(System.in);
	String[] arr = new String[20];
	static int index = 0;
	
	public void scan()
	{
	    System.out.println("단어를 입력해 주세요 : ");
	    this.arr[index] = sc.nextLine();
	    index++;
	}
}

public class problem2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		inputwords cc = new inputwords();
		int select_mode = 0;
	
		while(true)
		{
			System.out.println("select menu");
			System.out.println("1: 오름차순 출력");
			System.out.println("2: 내림차순 출력");
			System.out.println("3: 단어 추가(20개 max)");
			System.out.println("4: 프로그램 종료");
			
			select_mode = sc.nextInt();
			
			switch(select_mode)
			{
				case 1:
					Arrays.sort(cc.arr, 0, cc.index);
					for(int i = 0; i < cc.index; i++)
					{
						System.out.print("[" + cc.arr[i] + "]");
					}
					System.out.println();
					System.out.println();
					break;
				case 2:
					Arrays.sort(cc.arr, 0, cc.index, Collections.reverseOrder());
					for(int i = 0; i < cc.index; i++)
					{
						System.out.print("[" + cc.arr[i] + "]");
					}
					System.out.println();
					System.out.println();
					break;
				case 3:
					cc.scan();
					System.out.println();
					break;
				case 4:
					break;
			}
			
			if (select_mode == 4)
				break;
		}
	}
}
