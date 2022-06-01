package assignment_week_5;

public class Type_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Type_Casting exam = new Type_Casting();
		
		//묵시적 형변환
		System.out.println("묵시적 형변환 에시");
		int a = 1;
		System.out.println("int형 : " + a);
		
		double b;	
		b = a;		//a의 값 1이 자동으로 double형으로 형변환(묵시적 형변환)되어 b에 저장됨.
		System.out.println("double형 : " + b);
		
		//명시적 형변환
		System.out.println("명시적 형변환 예시");
		int c = 1000000000;
		System.out.println("int형 : " + c);
		
		double d;
		d = (double)c;
		System.out.println("double형 : " + d);
		
		short e;
		e = (short)c;
		//short형의 표현 범위는 -32,768 ~ 32,767이므로, overflow가 일어날 것.
		System.out.println("short형 : " + e);
		
		double f=2.44;
		int g;
		g = (int)f;
		System.out.println("");
		System.out.println("double -> int : " + g);
	}

}
