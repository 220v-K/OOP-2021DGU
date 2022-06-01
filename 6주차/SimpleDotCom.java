package assignment_week_6;

import java.util.*;

public class SimpleDotCom
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int maxNum_toHit;
		System.out.print("�ִ� ��ǥ �Է� Ƚ���� ����(50~70) : ");
		while(true)
		{
			maxNum_toHit = sc.nextInt();
			if(maxNum_toHit < 50 || maxNum_toHit > 70)
			{
				System.out.println("50~70 ������ Ƚ���� �Է��� �ֽʽÿ� : ");
				continue;
			}
			break;
		}
		
		SimpleDotCom_Set test = new SimpleDotCom_Set();
		
		test.DotComDicise();
		test.SimpleDotCom_show();	//ä���� .com ��ġ ���
		
		for (int i = 0; i < test.num_of_DotCom; i++)
		{
			System.out.println("You have to kill .Com - [" + i + "]");
		}
		
		SimpleDotCom_DidYouHit hit = new SimpleDotCom_DidYouHit();
		
		int num_of_left = test.num_of_DotCom;			//.Com�� ���� ����
		int num_of_hit;									//�ѹ��� kill�� .Com�� ����
		
		int[] killornot = new int[test.num_of_DotCom];	//.Com�� Kill�ߴ��� ����
		
		while(hit.shot_count != maxNum_toHit)
		{
			hit.Enter_matrix();			//��ǥ �Է�
			
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
			
			System.out.println("Left chance to hit : " + (maxNum_toHit - hit.shot_count)); 	//���� ��ǥ �Է� Ƚ�� ���

			

			for (int i = 0; i < test.num_of_DotCom; i++)
			{			
				if (killornot[i] == 8)
				{
					continue;
				}
				else
				{
					killornot[i] = 0;		//�ݺ� �ø��� ��� ���̸� �ȵǹǷ� 0���� �ʱ�ȭ
					
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
						num_of_left--;		//���� .com�� ���� 1 ����.
					}
				}
			}
			
			System.out.println(); 			//��� �� ����ϰ� �׳�..
				
			if (num_of_left == 0)							//.Com�� ���� �ʾ� �¸��ϸ�, �¸����� ��� �� ���α׷� ����.
			{
				System.out.println(" �ڡڡ� Victory �ڡڡ� ");
				break;
			}
		}
		
		if(hit.shot_count == maxNum_toHit)
		{
			System.out.println(" �� You Lose! �� ");		//���� Ƚ���� ��� �Ҹ��� while���� �������Դٸ�, �й蹮�� ��� �� ���α׷� ����.
		}
	}	
}

class SimpleDotCom_DidYouHit
{
	Scanner sc = new Scanner(System.in);
	SimpleDotCom_Set a = new SimpleDotCom_Set();

	
	int shot_count = 0;			//��ǥ �Է��� Ƚ��
	int row; int column;
	
	void Enter_matrix()		//����ڿ��� ��ǥ �Է¹���
	{
		row = -1; column = -1;
		
		while (row == -1)			//�� ��ǥ�� �Է�. 0~9 �� �Է� �� ����ó�� �� �ٽ� �Է�.
		{
			System.out.print("�Է��� ��ǥ�� ��(0~9) : ");
			row = sc.nextInt();
			if (row < 0 || row > 9)
			{
				System.out.println("0���� 9 ������ ���ڸ� �Է��ϼ���.");
				row = -1;	//while���� �ٽ� ������ ����
			}
		}
		while (column == -1)			//�� ��ǥ�� �Է�. 0~9 �� �Է� �� ����ó�� �� �ٽ� �Է�.
		{
			System.out.print("�Է��� ��ǥ�� ��(0~9) : ");
			column = sc.nextInt();
			if (column < 0 || column > 9)
			{
				System.out.println("0���� 9 ������ ���ڸ� �Է��ϼ���.");
				column = -1;
			}
		}	
		shot_count++;
	}

	int DotComvalue;
	int Num_of_Hit;
	int Hit()
	{
		Num_of_Hit = 0;		//�� ���� � Hit�ߴ����̹Ƿ�, �ݺ��� ������ �ʱ�ȭ
		
		for (int i = 0; i < a.num_of_DotCom; i++)
		{
			DotComvalue = a.DotCom[i][row][column];
			if (DotComvalue == 1)					//���� .Com�� ����ٸ�
			{
				Num_of_Hit++;
				a.DotCom[i][row][column] = 2;		//�� ĭ�� ���� (2�� �ٲپ�, ���߿� ������ 8�� �Ǹ� KILL ����� ��.)	
			}
		}
		
		return Num_of_Hit;		//Hit�� ���� return.
	}
}


class SimpleDotCom_Set
{

	int[][] background = new int[10][10];	//2���� �迭�� ����, 10x10 ������ ���� ����.
	static Random random = new Random();	//��������
	
	public SimpleDotCom_Set()		//������. background �迭 �ʱ�ȭ.
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				background[i][j] = 0;
			}
		}
	}
	
	public static int num_of_DotCom = random.nextInt(3) + 3;				//.Com�� ����
	boolean horizontal_vertical;				//true(1)�� ����, false(0)�� ����.
	int start_location_row;					//.Com�� ��ġ�� ����.
	int start_location_column;
	
	public static int[][][] DotCom = new int[num_of_DotCom][10][10];		//.Com ��ġ�� �����ϴ� 3���� �迭. DotCom[.Com��ȣ][��][��]�� ����.
	
	public void DotComDicise()
	{
		
		for (int i = 0; i < num_of_DotCom; i++)		//.Com �ʱ�ȭ
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
			horizontal_vertical = random.nextBoolean();		//true(1)�� ����, false(0)�� ����.
			
			if (horizontal_vertical == true)		//������ ��
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
				
				if (showmatrix_num == 0)			//�⺻ ĭ
				{
					System.out.print(" ��");
				}
				else if (showmatrix_num == 1)		//.Com�� �ִ� ĭ
				{
					System.out.print(" ��");
				}
				else if (showmatrix_num == 2)		//.Com�� �����ϰ�, 2���� ��ģ ĭ
				{
					System.out.print(" ��");
				}
				else								//.Com�� �����ϰ�, 3�� �̻� ��ģ ĭ. ���� 4�� �̻� ��ĥ ���� �幰�⿡,
				{									//.Com 4���� ��ġ���� ���� 4ĭ�� ���簢�� ����̹Ƿ� ������ ���� ������ ��.
					System.out.print(" ��");
				}
			}
			System.out.println();
		}
	}
}
