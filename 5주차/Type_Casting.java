package assignment_week_5;

public class Type_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Type_Casting exam = new Type_Casting();
		
		//������ ����ȯ
		System.out.println("������ ����ȯ ����");
		int a = 1;
		System.out.println("int�� : " + a);
		
		double b;	
		b = a;		//a�� �� 1�� �ڵ����� double������ ����ȯ(������ ����ȯ)�Ǿ� b�� �����.
		System.out.println("double�� : " + b);
		
		//����� ����ȯ
		System.out.println("����� ����ȯ ����");
		int c = 1000000000;
		System.out.println("int�� : " + c);
		
		double d;
		d = (double)c;
		System.out.println("double�� : " + d);
		
		short e;
		e = (short)c;
		//short���� ǥ�� ������ -32,768 ~ 32,767�̹Ƿ�, overflow�� �Ͼ ��.
		System.out.println("short�� : " + e);
		
		double f=2.44;
		int g;
		g = (int)f;
		System.out.println("");
		System.out.println("double -> int : " + g);
	}

}
