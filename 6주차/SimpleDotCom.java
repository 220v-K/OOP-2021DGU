package assignment_week_6;

import java.util.*;

public class SimpleDotCom
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int maxNum_toHit;
		System.out.print("최대 좌표 입력 횟수를 설정(50~70) : ");
		while(true)
		{
			maxNum_toHit = sc.nextInt();
			if(maxNum_toHit < 50 || maxNum_toHit > 70)
			{
				System.out.println("50~70 사이의 횟수를 입력해 주십시오 : ");
				continue;
			}
			break;
		}
		
		SimpleDotCom_Set test = new SimpleDotCom_Set();
		
		test.DotComDicise();
		test.SimpleDotCom_show();	//채점용 .com 위치 출력
		
		for (int i = 0; i < test.num_of_DotCom; i++)
		{
			System.out.println("You have to kill .Com - [" + i + "]");
		}
		
		SimpleDotCom_DidYouHit hit = new SimpleDotCom_DidYouHit();
		
		int num_of_left = test.num_of_DotCom;			//.Com의 남은 갯수
		int num_of_hit;									//한번에 kill한 .Com의 개수
		
		int[] killornot = new int[test.num_of_DotCom];	//.Com을 Kill했는지 여부
		
		while(hit.shot_count != maxNum_toHit)
		{
			hit.Enter_matrix();			//좌표 입력
			
			num_of_hit = hit.Hit();
			
			if (num_of_hit == 1)
			{
				System.out.println("Hit!");
			}
			else if (num_of_hit == 2)
			{
				System.out.println("Double Hit!");
			}
			else if (num_of_hit == 3)
			{
				System.out.println("Triple Hit!");
			}
			else if (num_of_hit == 4)
			{
				System.out.println("Quadra Hit!");
			}
			else if (num_of_hit == 5)
			{
				System.out.println("Penta Hit!");
			}
			else
			{
				System.out.println("Missed!");
			}
			
			System.out.println("Left chance to hit : " + (maxNum_toHit - hit.shot_count)); 	//남은 좌표 입력 횟수 출력

			

			for (int i = 0; i < test.num_of_DotCom; i++)
			{			
				if (killornot[i] == 8)
				{
					continue;
				}
				else
				{
					killornot[i] = 0;		//반복 시마다 계속 쌓이면 안되므로 0으로 초기화
					
					for (int j = 0; j < 10; j++)
					{
						for (int k = 0; k < 10; k++)
						{
							killornot[i] = killornot[i] + test.DotCom[i][j][k];
						}
					}
					
					if (killornot[i] == 8)
					{
						System.out.println("You killed .Com - " + "[" + i + "]");
						num_of_left--;		//남은 .com의 개수 1 줄임.
					}
				}
			}
			
			System.out.println(); 			//출력 시 깔끔하게 그냥..
				
			if (num_of_left == 0)							//.Com이 남지 않아 승리하면, 승리문구 출력 후 프로그램 종료.
			{
				System.out.println(" ★★★ Victory ★★★ ");
				break;
			}
		}
		
		if(hit.shot_count == maxNum_toHit)
		{
			System.out.println(" ★ You Lose! ★ ");		//실행 횟수를 모두 소모해 while문을 빠져나왔다면, 패배문구 출력 후 프로그램 종료.
		}
	}	
}

class SimpleDotCom_DidYouHit
{
	Scanner sc = new Scanner(System.in);
	SimpleDotCom_Set a = new SimpleDotCom_Set();

	
	int shot_count = 0;			//좌표 입력한 횟수
	int row; int column;
	
	void Enter_matrix()		//사용자에게 좌표 입력받음
	{
		row = -1; column = -1;
		
		while (row == -1)			//행 좌표값 입력. 0~9 외 입력 시 예외처리 후 다시 입력.
		{
			System.out.print("입력할 좌표의 행(0~9) : ");
			row = sc.nextInt();
			if (row < 0 || row > 9)
			{
				System.out.println("0부터 9 사이의 숫자를 입력하세요.");
				row = -1;	//while문을 다시 돌리기 위해
			}
		}
		while (column == -1)			//열 좌표값 입력. 0~9 외 입력 시 예외처리 후 다시 입력.
		{
			System.out.print("입력할 좌표의 열(0~9) : ");
			column = sc.nextInt();
			if (column < 0 || column > 9)
			{
				System.out.println("0부터 9 사이의 숫자를 입력하세요.");
				column = -1;
			}
		}	
		shot_count++;
	}

	int DotComvalue;
	int Num_of_Hit;
	int Hit()
	{
		Num_of_Hit = 0;		//한 번에 몇개 Hit했는지이므로, 반복할 때마다 초기화
		
		for (int i = 0; i < a.num_of_DotCom; i++)
		{
			DotComvalue = a.DotCom[i][row][column];
			if (DotComvalue == 1)					//만약 .Com을 맞췄다면
			{
				Num_of_Hit++;
				a.DotCom[i][row][column] = 2;		//그 칸을 삭제 (2로 바꾸어, 나중에 총합이 8이 되면 KILL 출력할 것.)	
			}
		}
		
		return Num_of_Hit;		//Hit한 개수 return.
	}
}


class SimpleDotCom_Set
{

	int[][] background = new int[10][10];	//2차원 배열을 선언, 10x10 형태의 판을 구성.
	static Random random = new Random();	//랜덤랜덤
	
	public SimpleDotCom_Set()		//생성자. background 배열 초기화.
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				background[i][j] = 0;
			}
		}
	}
	
	public static int num_of_DotCom = random.nextInt(3) + 3;				//.Com의 개수
	boolean horizontal_vertical;				//true(1)면 가로, false(0)면 세로.
	int start_location_row;					//.Com의 위치를 결정.
	int start_location_column;
	
	public static int[][][] DotCom = new int[num_of_DotCom][10][10];		//.Com 위치를 저장하는 3차원 배열. DotCom[.Com번호][행][열]의 형태.
	
	public void DotComDicise()
	{
		
		for (int i = 0; i < num_of_DotCom; i++)		//.Com 초기화
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 10; k++)
				{
					DotCom[i][j][k] = 0;
				}
			}
		}
		
		for (int i=0; i < num_of_DotCom; i++)
		{
			horizontal_vertical = random.nextBoolean();		//true(1)면 가로, false(0)면 세로.
			
			if (horizontal_vertical == true)		//가로일 때
			{
				start_location_row = random.nextInt(10);
				start_location_column = random.nextInt(7);
				for (int j = 0; j < 4; j++)
				{
					DotCom[i][start_location_row][start_location_column + j] = 1;
				}
			}		
			else
			{
				start_location_row = random.nextInt(7);
				start_location_column = random.nextInt(10);
				for (int j = 0; j < 4; j++)
				{
					DotCom[i][start_location_row + j][start_location_column] = 1;
				}
			}				
		}
	}
	
	public void SimpleDotCom_show()
	{
		int[][] showmatrix = new int[10][10];
		
		System.out.print("  ");
		for (int i = 0; i < 10; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = 0; i < num_of_DotCom; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 10; k++)
				{
					if (DotCom[i][j][k] == 1)
					{
						showmatrix[j][k]++;
					}
				}
			}
		}
		
		int showmatrix_num;
		
		for (int i = 0; i < 10; i++)
		{
			System.out.print(i);
			for (int j = 0; j < 10; j++)
			{
				showmatrix_num = showmatrix[i][j];
				
				if (showmatrix_num == 0)			//기본 칸
				{
					System.out.print(" □");
				}
				else if (showmatrix_num == 1)		//.Com이 있는 칸
				{
					System.out.print(" ■");
				}
				else if (showmatrix_num == 2)		//.Com이 존재하고, 2개가 겹친 칸
				{
					System.out.print(" ◆");
				}
				else								//.Com이 존재하고, 3개 이상 겹친 칸. 보통 4개 이상 겹칠 일이 드물기에,
				{									//.Com 4개가 겹치더라도 각각 4칸의 직사각형 모양이므로 보통은 구분 가능할 것.
					System.out.print(" ★");
				}
			}
			System.out.println();
		}
	}
}
