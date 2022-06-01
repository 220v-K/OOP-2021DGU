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
		
		System.out.println("명령어 도움말 : 100 / 프로그램 종료 : 0");
		while(cmd != 0)
		{
			System.out.println("명령어 입력: ");
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
				System.out.println("알맞은 명령어를 입력하세요.");	break;
			}
		}
	}
}
class Help		//명령어 도움말 출력 클래스
{
	Scanner sc = new Scanner(System.in);	
	int cmd;
	public void help_command()
	{
		System.out.println("어떤 클래스의 메소드의 명령어를 출력하시겠습니까?");
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
		System.out.println("11: 켜기 / 12: 끄기 / 13: 채널 변경  / 14: 현재 채널 확인 / 15: 볼륨 변경 / 16: 밝기 변경 / 17: TV 녹화");
	}
	void command_Dog()
	{
		System.out.println("21: 앞으로 / 22: 왼쪽으로 / 23: 뒤로 / 24: 오른쪽으로 / 25: 점프 / 26: 내려가기 / 27: 먹기 / 28: 자기");
	}
	void command_Cat()
	{
		System.out.println("31: 앞으로 / 32: 왼쪽으로 / 33: 뒤로 / 34: 오른쪽으로 / 35: 울음소리 / 36: 뛰기 / 37: 먹기 / 38: 자기");
	}
	void command_Microwave()
	{
		System.out.println("41: 켜기 / 42: 끄기 / 43: 실행 / 44: 켜져있어?");
	}
	void command_Human()
	{
		System.out.println("51: 앞으로 / 52: 왼쪽으로 / 53: 뒤로 / 54: 오른쪽으로 / 55: 먹기 / 56: 자기 / 57: 소리지르기");
	}
	void command_Airplane()
	{
		System.out.println("61: 앞으로 / 62: 왼쪽으로 / 63: 뒤로 / 64: 오른쪽으로 / 65: 위로 / 66: 아래로 / 67: 출발");
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
class TV implements on_off		//TV클래스. on_off 인터페이스 상속받음.
{
	Scanner sc = new Scanner(System.in);
	int channel = 0;			//TV의 현재 채널. 꺼져 있어도 채널은 유지. 채널의 초기 설정은 0.
	boolean TV_isON = false;	//현재 TV 전원 상태. 초기 설정은 꺼져 있음(false).
	int volume = 10;			//TV의 볼륨.
	int brighten = 50;			//TV의 밝기.
	boolean TV_record = false;	//TV 녹화
	
	public void on()				//TV on
	{
		System.out.println("TV가 켜졌습니다.");
		TV_isON = true;
	}
	public void off()				//TV off
	{
		System.out.println("TV가 꺼졌습니다.");
		TV_isON = false;
	}
	public void change_channel()	//채널 변경
	{
		if (TV_isON == true)
		{
		System.out.println("변경할 채널을 입력해 주세요.");
		channel = sc.nextInt();
		System.out.println("채널이 " + channel + "(으)로 변경되었습니다.");
		}
		else
			System.out.println("Tv가 꺼져 있습니다.");
	}
	public void print_channel()		//현재 채널을 확인
	{
		if (TV_isON == true)
			System.out.println("현재 채널은 " + channel + "입니다.");
		else
			System.out.println("Tv가 꺼져 있습니다.");
	}
	public void change_volume()		//볼륨 변경
	{
		if (TV_isON == true)
		{
			while(true)
			{
				System.out.println("변경할 볼륨을 입력해 주세요.(0~100) / 현재 볼륨 : " + volume);
				volume = sc.nextInt();
				if (0 <= volume && volume <= 100)
				{
					System.out.println("볼륨이 " + volume + "(으)로 변경되었습니다.");
					break;
				}
				else
				{
					System.out.println("1~100 사이의 숫자를 입력해 주세요.");
				}
			}
		}
		else
			System.out.println("Tv가 꺼져 있습니다.");
	}
	public void change_brighten()	//밝기 변경
	{
		if (TV_isON == true)
		{
			while(true)
			{
				System.out.println("변경할 밝기을 입력해 주세요.(0~100) / 현재 밝기 : " + brighten);
				brighten = sc.nextInt();
				if (0 <= brighten && brighten <= 100)
				{
					System.out.println("밝기가 " + brighten + "(으)로 변경되었습니다.");
					break;
				}
				else
				{
					System.out.println("1~100 사이의 숫자를 입력해 주세요.");
				}
			}
		}
		else
			System.out.println("Tv가 꺼져 있습니다.");
	}	
	public void record()			//TV 녹화
	{
		if(TV_record == false)
		{
			System.out.println("TV 녹화를 시작합니다.");
			TV_record = true;
		}
		else
		{
			System.out.println("TV 녹화를 종료합니다.");
			TV_record = false;
		}
	}
}
class Dog implements move, life
{
	int x=0, y=0, z=0;			//개가 있는 좌표
	int hungry = 5;		//배고픈 정도(20 최대)
	int sleep = 5;			//졸린 정도(20 최대)
	
	public void front()		//앞으로
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
			}
		}
	}
	public void left()		//왼쪽으로
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
			}
		}
	}
	public void back()		//뒤로
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
			}
		}
	}
	public void right()		//오른쪽으로
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
			}
		}
	}
	public void jump()		//점프~
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
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
				System.out.println("밥 주세요.");
			}
			else if(sleep <= 0)
			{
				System.out.println("재워 주세요.");
			}
			else
			{
				System.out.println("오륜데..");
			}
		}
	}
	public void eat()		//먹음
	{
		if(hungry == 20)
			System.out.println("배불러 먹지 못함.");
		else if(17 <= hungry && hungry <= 19)
		{
			hungry = 20;
			System.out.println("밥을 먹어 배고픔이 20이 되었습니다.");
		}
		else
		{
			hungry += 3;
			System.out.println("밥을 먹어 배고픔이 " + hungry + "이 되었습니다.");
		}	
	}
	public void sleep()		//잠
	{
		if(sleep == 20)
			System.out.println("안 졸려요.");
		else if(10 <= sleep && sleep <= 19)
		{
			sleep = 20;
			System.out.println("잠을 자고 쌩쌩해졌어요. sleep : " + sleep);
		}
		else
		{
			sleep += 10;
			System.out.println("잠을 자고 쌩쌩해졌어요. sleep : " + sleep);
		}
	}
	void print_where()
	{
		System.out.println("현재 위치 x: " + x + " y: " + y + " z: " + z);
	}
	void hungrydown()	//행동 후 배고픔 감소
	{
		hungry -= 5;
	}
	void sleepdown()	//행동 후 sleep 감소
	{
		sleep -= 3;
	}
}
class Cat implements move, life		//Cat class는 Dog보단 간단하게 구현함.
{
	int x=0, y=0, z=0;
	int hungry = 5;		//배고픈 정도(20 최대)
	int sleep = 5;			//졸린 정도(20 최대)
	public void front()	//앞으로
	{
		y++;
		print_where();
	}
	public void left()	//왼쪽
	{
		x--;
		print_where();
	}
	public void back()	//뒤로
	{
		y--;
		print_where();
	}
	public void right()	//오른쪽
	{
		x++;
		print_where();
	}
	public void Meow()	//울음소리
	{
		System.out.println("Meow~");
	}
	public void Run()	//뛰기
	{
		y += 3;
		print_where();
	}
	public void eat()	//먹기
	{
		if(hungry == 20)
			System.out.println("배불러 먹지 못함.");
		else if(17 <= hungry && hungry <= 19)
		{
			hungry = 20;
			System.out.println("밥을 먹어 배고픔이 20이 되었습니다.");
		}
		else
		{
			hungry += 3;
			System.out.println("밥을 먹어 배고픔이 " + hungry + "이 되었습니다.");
		}	
	}
	public void sleep()	//자기
	{
		if(sleep == 20)
			System.out.println("안 졸려요.");
		else if(10 <= sleep && sleep <= 19)
		{
			sleep = 20;
			System.out.println("잠을 자고 쌩쌩해졌어요. sleep : " + sleep);
		}
		else
		{
			sleep += 10;
			System.out.println("잠을 자고 쌩쌩해졌어요. sleep : " + sleep);
		}
	}
	void print_where()
	{
		System.out.println("현재 위치 x: " + x + " y: " + y + " z: " + z);
	}
}
class Microwave implements on_off
{
	Scanner sc = new Scanner(System.in);
	boolean Microwave_isON = false;	//현재 전자레인지 전원 상태. 초기 설정은 꺼져 있음(false).
	int cel, time, color, isRightside;
	
	public void on()				//전자렌지 켜기
	{
		System.out.println("전자레인지가 켜졌습니다.");
		Microwave_isON = true;
	}
	public void off()				//전자레인지 끄기
	{
		System.out.println("전자레인지가 꺼졌습니다.");
		Microwave_isON = false;
	}
	public void execute()			//전자레인지 실행
	{
		if(Microwave_isON == true)
		{
			System.out.println("전자레인지 가동. 온도(정수), 시간(초, 정수), 나오는 빛 색깔(0:보라, 1:초록),"
								+ " 돌아가는 방향(0:오른쪽, 1:왼쪽) 차례대로 입력.");
			cel = sc.nextInt();
			time = sc.nextInt();
			color = sc.nextInt();
			isRightside = sc.nextInt();
			if( (color == 0 || color == 1) && (isRightside == 0 || isRightside == 1) )
			{
				System.out.print("온도: " + cel);
				System.out.print(" 시간: " + time + "초");
				if(color == 0)
					System.out.print(" 색: 보라" );
				else
					System.out.print(" 색: 초록" );
				if(isRightside == 0)
					System.out.print(" 방향: 오른쪽");
				else
					System.out.println(" 방향: 왼쪽");
			}
			else
				System.out.println("적절하지 않은 입력값입니다.");		
		}
		else
			System.out.println("전자레인지 꺼져 있어요.");

	}
	public void isON()				//켜져 있는지 확인
	{
		if(Microwave_isON == true)
			System.out.println("전자레인지가 켜져 있음.");
		else
			System.out.println("전자레인지가 꺼져 있음.");
	}
}
class Human implements move, life
{
	int x=0,y=0,z=0;
	boolean isHungry = true;
	boolean isSleepy = true;
	public void front()	//앞으로
	{
		y++;
		print_where();
	}
	public void left()	//왼쪽
	{
		x--;
		print_where();
	}
	public void back()	//뒤로
	{
		y--;
		print_where();
	}
	public void right()	//오른쪽
	{
		x++;
		print_where();
	}
	public void eat()	//먹기
	{
		if(isHungry == true)
		{
			System.out.println("인간이 밥을 먹었어요.");
			isHungry = false;
		}
		else
			System.out.println("인간이 배가 안 고파요.");
	}
	public void sleep()	//자기
	{
		if(isSleepy == true)
		{
			System.out.println("인간이 잠을 잤어요.");
			isSleepy = false;
		}
		else
			System.out.println("인간이 안 졸려요.");
	}
	void print_where()	//어딘지 출력
	{
		System.out.println("현재 위치 x: " + x + " y: " + y + " z: " + z);
	}
	public void shout()	//소리지르기
	{
		System.out.println("야!!!!!!!!!!!!!!!!!!!!!!!!!");
	}	
}	
class Airplane implements move
{
	Scanner sc = new Scanner(System.in);
	int x=0,y=0,z=0;
	int pass,empl;
	public void front()	//앞으로
	{
		y++;
		print_where();
	}
	public void left()	//왼쪽
	{
		x--;
		print_where();
	}
	public void back()	//뒤로
	{
		y--;
		print_where();
	}
	public void right()	//오른쪽
	{
		x++;
		print_where();
	}
	public void goup()	//위로
	{
		z++;
		print_where();
	}
	public void godown()//아래로
	{
		z--;
		print_where();
	}
	void print_where()	//어딘지 출력
	{
		System.out.println("현재 위치 x: " + x + " y: " + y + " z: " + z);
	}
	public void gogo()	//출발시 승객, 직원 수
	{
		System.out.println("출발합니다. 승객, 직원 수를 차례로 입력하세요.");
		pass = sc.nextInt();
		empl = sc.nextInt();
		System.out.println("승객 수는 : " + pass + " 직원 수는 : " + empl);
	}
}











