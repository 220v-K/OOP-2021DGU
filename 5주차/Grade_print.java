package assignment_week_5;

import java.util.*; 

public class Grade_print 
{
	public static class Student
	{
		String u_name[];
		int u_score[];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student a = new Student();
		
		int size = 3;
		a.u_name = new String[size];
		a.u_score = new int[size];
		int i;
		
		for(i = 0; i < size; i++)
		{
			System.out.println("이름을 입력해주세요 : ");
			a.u_name[i] = sc.nextLine();
		}
		
		for(i = 0; i < size; i++)
		{
			System.out.println("점수를 입력해주세요 : ");
			a.u_score[i] = sc.nextInt();
		}
		
		for(i = 0; i < size; i++)
		{
			switch(a.u_score[i] / 10)
			{
				case 10 :
				case 9 :
					System.out.println(a.u_name[i] + " grade is A");
					break;
				case 8 :
					System.out.println(a.u_name[i] + " grade is B");
					break;
				case 7 :
					System.out.println(a.u_name[i] + " grade is C");
					break;
				default :
					System.out.println(a.u_name[i] + " grade is D");
			}			
		}
	}
}
