package assignment_week_1;

import java.util.Scanner;

public class exam4 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭 ũ�⸦ �Է����ּ��� : ");
		int size = sc.nextInt();					// a, b, c�迭�� ũ�� ����
		
		int a[] = new int[size];
		int b[] = new int[size];
		int c[] = new int[size*2];
		
		System.out.print("�迭A :");
		
		for(int i = 0; i < a.length; i++)	// a �迭 ũ�� ����, �Ҵ�, ���
		{
			a[i] = (i+1) * 2 - 1;
			System.out.print(a[i] + " ");
		}
		System.out.println();
			
		System.out.print("�迭B :");			// b �迭 ũ�� ����, �Ҵ�, ���
		
		for(int i = 0; i < b.length; i++)
		{
			b[i] = (i+1) * 2;
			System.out.print(b[i] + " ");
		}
		System.out.println();
			
		System.out.print("�迭C :");
		
		for(int i = 0; i < size; i++)		// c �迭 �Ҵ�
		{
			c[a[i]-1] = a[i];				// a, b �迭���� �����ư��� c�迭�� �ֱ�
			c[b[i]-1] = b[i];
		}
		
		for(int i=0; i < c.length; i++) 	// c �迭 ���
		{
			System.out.print(c[i] + " ");
		}
		
		System.out.println();
	}
}




