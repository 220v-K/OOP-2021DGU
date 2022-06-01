/*
 동국대학교 2020112046 이재원
 객체지향프로그래밍 3주차 실습
 */

package assignment_week_2;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Clock {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat form1 = new SimpleDateFormat("HH:mm:ss");		//Data Form 수정
		
		int select_mode = 0;
		int out_key = 0;
		long time1, time2;
		
		while(true)				//3 입력시 까지 무한 실행 메뉴
		{
			System.out.println("select menu");
			System.out.println("1: current time");
			System.out.println("2: timer");
			System.out.println("3: exit");
			
			select_mode = sc.nextInt();		//실행할 메뉴를 입력
			
			switch(select_mode)
			{
				case 1:						//1번 입력 시 현재 시간 출력
					System.out.println("현재 시간은 " + form1.format(System.currentTimeMillis()) + "입니다.");
					System.out.println();
					break;
					
				case 2:						//2번 입력 시 타이머 작동
					System.out.println("1을 입력하면 타이머가 멈춥니다.");
					time1 = System.currentTimeMillis();		//타이머 시작
					while(out_key != 1)						//1을 입력하기 전까지는 타이머를 종료하지 않음
					{
						out_key = sc.nextInt();
					}
					time2 = System.currentTimeMillis();
					System.out.println("시간 차는" + (time2-time1)/1000.000 + "초 입니다.");
					out_key = 0;							//타이머를 다시 실행했을 때, out_key가 1이면 바로 종료되므로, 0으로 초기화
					break;
					
				case 3:						//3번 입력 시 프로그램 종료
					System.out.println("Program exit");
					System.exit(0);
					break;
			}
		}
	}
}
