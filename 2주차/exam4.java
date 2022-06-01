package assignment_week_1;

import java.util.Scanner;

public class exam4 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열 크기를 입력해주세요 : ");
		int size = sc.nextInt();					// a, b, c배열의 크기 결정
		
		int a[] = new int[size];
		int b[] = new int[size];
		int c[] = new int[size*2];
		
		System.out.print("배열A :");
		
		for(int i = 0; i < a.length; i++)	// a 배열 크기 배정, 할당, 출력
		{
			a[i] = (i+1) * 2 - 1;
			System.out.print(a[i] + " ");
		}
		System.out.println();
			
		System.out.print("배열B :");			// b 배열 크기 배정, 할당, 출력
		
		for(int i = 0; i < b.length; i++)
		{
			b[i] = (i+1) * 2;
			System.out.print(b[i] + " ");
		}
		System.out.println();
			
		System.out.print("배열C :");
		
		for(int i = 0; i < size; i++)		// c 배열 할당
		{
			c[a[i]-1] = a[i];				// a, b 배열값을 번갈아가며 c배열에 넣기
			c[b[i]-1] = b[i];
		}
		
		for(int i=0; i < c.length; i++) 	// c 배열 출력
		{
			System.out.print(c[i] + " ");
		}
		
		System.out.println();
	}
}




