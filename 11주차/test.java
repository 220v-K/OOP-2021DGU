package assignment_week_11;

import java.util.*;

public class test {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);	//Scanner
		Help help = new Help();			//command help
		TV test_TV = new TV();		
		Dog test_dog = new Dog();
		Cat test_cat = new Cat();
		Microwave test_micro = new Microwave();
		Human test_human = new Human();
		Airplane test_air = new Airplane();
		int cmd = -1;
		
		System.out.println("��ɾ� ���� : 100 / ���α׷� ���� : 0");
		while(cmd != 0)
		{
			System.out.println("��ɾ� �Է�: ");
			cmd = sc.nextInt();
			switch(cmd)
			{
			case 100:	help.help_command();	break;
			case 11:	test_TV.on();	break;
			case 12:	test_TV.off();	break;
			case 13:	test_TV.change_channel();	break;
			case 14:	test_TV.print_channel();	break;
			case 15:	test_TV.change_volume();	break;
			case 16:	test_TV.change_brighten();	break;
			case 17:	test_TV.record();	break;
			case 21:	test_dog.front();	break;
			case 22:	test_dog.left();	break;
			case 23:	test_dog.back();	break;
			case 24:	test_dog.right();	break;
			case 25:	test_dog.jump();	break;
			case 26:	test_dog.godown();	break;
			case 27:	test_dog.eat();		break;
			case 28:	test_dog.sleep();	break;
			case 31:	test_cat.front();	break;
			case 32:	test_cat.left();	break;
			case 33:	test_cat.back();	break;
			case 34:	test_cat.right();	break;
			case 35:	test_cat.Meow();	break;
			case 36:	test_cat.Run();		break;
			case 37:	test_cat.eat();		break;
			case 38:	test_cat.sleep();	break;
			case 41:	test_micro.on();		break;
			case 42:	test_micro.off();		break;
			case 43:	test_micro.execute();	break;
			case 44:	test_micro.isON();		break;
			case 51:	test_human.front();	break;
			case 52:	test_human.left();	break;
			case 53:	test_human.back();	break;
			case 54:	test_human.right();	break;
			case 55:	test_human.eat();	break;
			case 56:	test_human.sleep();	break;
			case 57:	test_human.shout();	break;
			case 61:	test_air.front();	break;
			case 62:	test_air.left();	break;
			case 63:	test_air.back();	break;
			case 64:	test_air.right();	break;
			case 65:	test_air.goup();	break;
			case 66:	test_air.godown();	break;
			case 67:	test_air.gogo();	break;

			default:
				System.out.println("�˸��� ��ɾ �Է��ϼ���.");	break;
			}
		}
	}
}
class Help		//��ɾ� ���� ��� Ŭ����
{
	Scanner sc = new Scanner(System.in);	
	int cmd;
	public void help_command()
	{
		System.out.println("� Ŭ������ �޼ҵ��� ��ɾ ����Ͻðڽ��ϱ�?");
		System.out.println("1: TV / 2: Dog / 3: Cat / 4: Microwave / 5: Human / 6: Airplane");
		cmd = sc.nextInt();
		
		switch(cmd) {
		case 1: command_TV();
				break;
		case 2: command_Dog();
				break;
		case 3: command_Cat();
				break;
		case 4: command_Microwave();
				break;
		case 5: command_Human();
				break;
		case 6: command_Airplane();
				break;
		}
	}
	void command_TV()
	{
		System.out.println("11: �ѱ� / 12: ���� / 13: ä�� ����  / 14: ���� ä�� Ȯ�� / 15: ���� ���� / 16: ��� ���� / 17: TV ��ȭ");
	}
	void command_Dog()
	{
		System.out.println("21: ������ / 22: �������� / 23: �ڷ� / 24: ���������� / 25: ���� / 26: �������� / 27: �Ա� / 28: �ڱ�");
	}
	void command_Cat()
	{
		System.out.println("31: ������ / 32: �������� / 33: �ڷ� / 34: ���������� / 35: �����Ҹ� / 36: �ٱ� / 37: �Ա� / 38: �ڱ�");
	}
	void command_Microwave()
	{
		System.out.println("41: �ѱ� / 42: ���� / 43: ���� / 44: �����־�?");
	}
	void command_Human()
	{
		System.out.println("51: ������ / 52: �������� / 53: �ڷ� / 54: ���������� / 55: �Ա� / 56: �ڱ� / 57: �Ҹ�������");
	}
	void command_Airplane()
	{
		System.out.println("61: ������ / 62: �������� / 63: �ڷ� / 64: ���������� / 65: ���� / 66: �Ʒ��� / 67: ���");
	}
}
//--------------------------
//	    Interface part
//--------------------------
interface on_off
{
	void on();
	void off();
}
interface move
{
	void front();
	void left();
	void back();
	void right();
}
interface life
{
	void eat();
	void sleep();
}

//--------------------------
//		  class part
//--------------------------
class TV implements on_off		//TVŬ����. on_off �������̽� ��ӹ���.
{
	Scanner sc = new Scanner(System.in);
	int channel = 0;			//TV�� ���� ä��. ���� �־ ä���� ����. ä���� �ʱ� ������ 0.
	boolean TV_isON = false;	//���� TV ���� ����. �ʱ� ������ ���� ����(false).
	int volume = 10;			//TV�� ����.
	int brighten = 50;			//TV�� ���.
	boolean TV_record = false;	//TV ��ȭ
	
	public void on()				//TV on
	{
		System.out.println("TV�� �������ϴ�.");
		TV_isON = true;
	}
	public void off()				//TV off
	{
		System.out.println("TV�� �������ϴ�.");
		TV_isON = false;
	}
	public void change_channel()	//ä�� ����
	{
		if (TV_isON == true)
		{
		System.out.println("������ ä���� �Է��� �ּ���.");
		channel = sc.nextInt();
		System.out.println("ä���� " + channel + "(��)�� ����Ǿ����ϴ�.");
		}
		else
			System.out.println("Tv�� ���� �ֽ��ϴ�.");
	}
	public void print_channel()		//���� ä���� Ȯ��
	{
		if (TV_isON == true)
			System.out.println("���� ä���� " + channel + "�Դϴ�.");
		else
			System.out.println("Tv�� ���� �ֽ��ϴ�.");
	}
	public void change_volume()		//���� ����
	{
		if (TV_isON == true)
		{
			while(true)
			{
				System.out.println("������ ������ �Է��� �ּ���.(0~100) / ���� ���� : " + volume);
				volume = sc.nextInt();
				if (0 <= volume && volume <= 100)
				{
					System.out.println("������ " + volume + "(��)�� ����Ǿ����ϴ�.");
					break;
				}
				else
				{
					System.out.println("1~100 ������ ���ڸ� �Է��� �ּ���.");
				}
			}
		}
		else
			System.out.println("Tv�� ���� �ֽ��ϴ�.");
	}
	public void change_brighten()	//��� ����
	{
		if (TV_isON == true)
		{
			while(true)
			{
				System.out.println("������ ����� �Է��� �ּ���.(0~100) / ���� ��� : " + brighten);
				brighten = sc.nextInt();
				if (0 <= brighten && brighten <= 100)
				{
					System.out.println("��Ⱑ " + brighten + "(��)�� ����Ǿ����ϴ�.");
					break;
				}
				else
				{
					System.out.println("1~100 ������ ���ڸ� �Է��� �ּ���.");
				}
			}
		}
		else
			System.out.println("Tv�� ���� �ֽ��ϴ�.");
	}	
	public void record()			//TV ��ȭ
	{
		if(TV_record == false)
		{
			System.out.println("TV ��ȭ�� �����մϴ�.");
			TV_record = true;
		}
		else
		{
			System.out.println("TV ��ȭ�� �����մϴ�.");
			TV_record = false;
		}
	}
}
class Dog implements move, life
{
	int x=0, y=0, z=0;			//���� �ִ� ��ǥ
	int hungry = 5;		//����� ����(20 �ִ�)
	int sleep = 5;			//���� ����(20 �ִ�)
	
	public void front()		//������
	{
		if(hungry > 0 && sleep > 0)
		{
			y++;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void left()		//��������
	{
		if(hungry > 0 && sleep > 0)
		{
			x--;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void back()		//�ڷ�
	{
		if(hungry > 0 && sleep > 0)
		{
			y--;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void right()		//����������
	{
		if(hungry > 0 && sleep > 0)
		{
			x++;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void jump()		//����~
	{
		if(hungry > 0 && sleep > 0)
		{
			z++;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void godown()
	{
		if(hungry > 0 && sleep > 0)
		{
			z--;
			print_where();
			hungrydown();
			sleepdown();
		}
		else
		{
			if(hungry <= 0)
			{
				System.out.println("�� �ּ���.");
			}
			else if(sleep <= 0)
			{
				System.out.println("��� �ּ���.");
			}
			else
			{
				System.out.println("������..");
			}
		}
	}
	public void eat()		//����
	{
		if(hungry == 20)
			System.out.println("��ҷ� ���� ����.");
		else if(17 <= hungry && hungry <= 19)
		{
			hungry = 20;
			System.out.println("���� �Ծ� ������� 20�� �Ǿ����ϴ�.");
		}
		else
		{
			hungry += 3;
			System.out.println("���� �Ծ� ������� " + hungry + "�� �Ǿ����ϴ�.");
		}	
	}
	public void sleep()		//��
	{
		if(sleep == 20)
			System.out.println("�� ������.");
		else if(10 <= sleep && sleep <= 19)
		{
			sleep = 20;
			System.out.println("���� �ڰ� �߽��������. sleep : " + sleep);
		}
		else
		{
			sleep += 10;
			System.out.println("���� �ڰ� �߽��������. sleep : " + sleep);
		}
	}
	void print_where()
	{
		System.out.println("���� ��ġ x: " + x + " y: " + y + " z: " + z);
	}
	void hungrydown()	//�ൿ �� ����� ����
	{
		hungry -= 5;
	}
	void sleepdown()	//�ൿ �� sleep ����
	{
		sleep -= 3;
	}
}
class Cat implements move, life		//Cat class�� Dog���� �����ϰ� ������.
{
	int x=0, y=0, z=0;
	int hungry = 5;		//����� ����(20 �ִ�)
	int sleep = 5;			//���� ����(20 �ִ�)
	public void front()	//������
	{
		y++;
		print_where();
	}
	public void left()	//����
	{
		x--;
		print_where();
	}
	public void back()	//�ڷ�
	{
		y--;
		print_where();
	}
	public void right()	//������
	{
		x++;
		print_where();
	}
	public void Meow()	//�����Ҹ�
	{
		System.out.println("Meow~");
	}
	public void Run()	//�ٱ�
	{
		y += 3;
		print_where();
	}
	public void eat()	//�Ա�
	{
		if(hungry == 20)
			System.out.println("��ҷ� ���� ����.");
		else if(17 <= hungry && hungry <= 19)
		{
			hungry = 20;
			System.out.println("���� �Ծ� ������� 20�� �Ǿ����ϴ�.");
		}
		else
		{
			hungry += 3;
			System.out.println("���� �Ծ� ������� " + hungry + "�� �Ǿ����ϴ�.");
		}	
	}
	public void sleep()	//�ڱ�
	{
		if(sleep == 20)
			System.out.println("�� ������.");
		else if(10 <= sleep && sleep <= 19)
		{
			sleep = 20;
			System.out.println("���� �ڰ� �߽��������. sleep : " + sleep);
		}
		else
		{
			sleep += 10;
			System.out.println("���� �ڰ� �߽��������. sleep : " + sleep);
		}
	}
	void print_where()
	{
		System.out.println("���� ��ġ x: " + x + " y: " + y + " z: " + z);
	}
}
class Microwave implements on_off
{
	Scanner sc = new Scanner(System.in);
	boolean Microwave_isON = false;	//���� ���ڷ����� ���� ����. �ʱ� ������ ���� ����(false).
	int cel, time, color, isRightside;
	
	public void on()				//���ڷ��� �ѱ�
	{
		System.out.println("���ڷ������� �������ϴ�.");
		Microwave_isON = true;
	}
	public void off()				//���ڷ����� ����
	{
		System.out.println("���ڷ������� �������ϴ�.");
		Microwave_isON = false;
	}
	public void execute()			//���ڷ����� ����
	{
		if(Microwave_isON == true)
		{
			System.out.println("���ڷ����� ����. �µ�(����), �ð�(��, ����), ������ �� ����(0:����, 1:�ʷ�),"
								+ " ���ư��� ����(0:������, 1:����) ���ʴ�� �Է�.");
			cel = sc.nextInt();
			time = sc.nextInt();
			color = sc.nextInt();
			isRightside = sc.nextInt();
			if( (color == 0 || color == 1) && (isRightside == 0 || isRightside == 1) )
			{
				System.out.print("�µ�: " + cel);
				System.out.print(" �ð�: " + time + "��");
				if(color == 0)
					System.out.print(" ��: ����" );
				else
					System.out.print(" ��: �ʷ�" );
				if(isRightside == 0)
					System.out.print(" ����: ������");
				else
					System.out.println(" ����: ����");
			}
			else
				System.out.println("�������� ���� �Է°��Դϴ�.");		
		}
		else
			System.out.println("���ڷ����� ���� �־��.");

	}
	public void isON()				//���� �ִ��� Ȯ��
	{
		if(Microwave_isON == true)
			System.out.println("���ڷ������� ���� ����.");
		else
			System.out.println("���ڷ������� ���� ����.");
	}
}
class Human implements move, life
{
	int x=0,y=0,z=0;
	boolean isHungry = true;
	boolean isSleepy = true;
	public void front()	//������
	{
		y++;
		print_where();
	}
	public void left()	//����
	{
		x--;
		print_where();
	}
	public void back()	//�ڷ�
	{
		y--;
		print_where();
	}
	public void right()	//������
	{
		x++;
		print_where();
	}
	public void eat()	//�Ա�
	{
		if(isHungry == true)
		{
			System.out.println("�ΰ��� ���� �Ծ����.");
			isHungry = false;
		}
		else
			System.out.println("�ΰ��� �谡 �� ���Ŀ�.");
	}
	public void sleep()	//�ڱ�
	{
		if(isSleepy == true)
		{
			System.out.println("�ΰ��� ���� ����.");
			isSleepy = false;
		}
		else
			System.out.println("�ΰ��� �� ������.");
	}
	void print_where()	//����� ���
	{
		System.out.println("���� ��ġ x: " + x + " y: " + y + " z: " + z);
	}
	public void shout()	//�Ҹ�������
	{
		System.out.println("��!!!!!!!!!!!!!!!!!!!!!!!!!");
	}	
}	
class Airplane implements move
{
	Scanner sc = new Scanner(System.in);
	int x=0,y=0,z=0;
	int pass,empl;
	public void front()	//������
	{
		y++;
		print_where();
	}
	public void left()	//����
	{
		x--;
		print_where();
	}
	public void back()	//�ڷ�
	{
		y--;
		print_where();
	}
	public void right()	//������
	{
		x++;
		print_where();
	}
	public void goup()	//����
	{
		z++;
		print_where();
	}
	public void godown()//�Ʒ���
	{
		z--;
		print_where();
	}
	void print_where()	//����� ���
	{
		System.out.println("���� ��ġ x: " + x + " y: " + y + " z: " + z);
	}
	public void gogo()	//��߽� �°�, ���� ��
	{
		System.out.println("����մϴ�. �°�, ���� ���� ���ʷ� �Է��ϼ���.");
		pass = sc.nextInt();
		empl = sc.nextInt();
		System.out.println("�°� ���� : " + pass + " ���� ���� : " + empl);
	}
}











