package assignment_week_9;

import java.util.*;

public class OneCard 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Cardset test = new Cardset();
		
		while(true)
		{
			int cmd = 0;
			
			System.out.println("\n1: ���� ����, 2: ���� ����");	//1�̸� ���� ����, 2�� ���� ����. ���� �� �ߴ� ����, ������ ������ �ٽ� 1 or 2 ����
			cmd = sc.nextInt();
			while(true)
			{
				if(cmd == 1 || cmd == 2)
					break;
				else
				{
					System.out.println("�ùٸ� ���ڸ� �Է��� �ּ���.");
					cmd = sc.nextInt();
				}
			}

			if(cmd == 1)
			{
				test.RestartGame();
				
				int FinishGame = 0;
				while(FinishGame == 0)
				{
					FinishGame += test.PlayGame();			
				}
			}
			else if(cmd == 2)
			{
				System.out.println("������ �����մϴ�.");
				return;
			}
			else
				System.out.println("Unexpected Error");
		}
	}
}

class Cardset
{
	Scanner sc = new Scanner(System.in);
	ArrayList<String> set = new ArrayList<String>();	//Cardset Array
	ArrayList<String> Player = new ArrayList<String>();	//Player Card Array
	ArrayList<String> Com1 = new ArrayList<String>();	//Com1 Card Array
	ArrayList<String> Com2 = new ArrayList<String>();	//Com2 Card Array
	boolean isGameFinished = false;
	
	public void RestartGame()
	{
		isGameFinished = false;
		set.clear();					//���� ������� ���� ArrayList clear.
		Player.clear();
		Com1.clear();
		Com2.clear();

		ResetCardset();					//Cardset Reset
		
		Collections.shuffle(set);		//Cardset Shuffle
		
		AllocateCard();					//ī�� 5�徿 ���
	}
	
	public int PlayGame()
	{
		Turn_Player();
		if (isGameFinished == true)
			return 1;
		Turn_Com1();
		if (isGameFinished == true)
			return 1;
		Turn_Com2();
		if (isGameFinished == true)
			return 1;
		else
			return 0;
	}
	

	
	void Turn_Player()
	{
		System.out.println("���� ������ ī�� : " + set.get(0));		//�ٴڿ� ������ ī�� ���
		
		System.out.print("���� Player�� ������ �ִ� ī�� : ");		//Player�� ī�� ���
		for(String i : Player)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����
		
		for(int i = 0; i < Player.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Player.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Player.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Player.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(���� ���ڰ� ���� ī��� ���� �� ������ ������� �ʾƵ� ��)
		
		if(Card_CanPlay_Index.size() == 0)		//���ٸ� Cardset �� ���������� �̾ƿ���
		{
			Player.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\n�� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�!");
			System.out.println("���� ī�� : " + Player.get(Player.size()-1) + "\n");
		}
		else									//�ִٸ� �����ϱ�
		{
			System.out.print("\n�� ī�带 �����ϼ���! : ");
			for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
			{
				System.out.print( i + ". " + Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
			}
	
			int pick;
			while(true)		//ī�� ���� �� �߸��� ���� �Է� ����ó��
			{
				pick = sc.nextInt();
				if((1 <= pick) && (pick <= Card_CanPlay_Index.size()) )
				{
					break;
				}
				else
				{
					System.out.println("�ùٸ� ���ڸ� �Է��� �ּ���");
				}
			}
			
			System.out.println(Player.get(Card_CanPlay_Index.get(pick-1)) + "�� �½��ϴ�.\n");
			
			set.add(0, Player.get(pick-1));
			Player.remove(Player.get(Card_CanPlay_Index.get(pick-1)));
			
			isGameFinished_Player();	//���� ���� Ȯ��
		}
	}	
	void isGameFinished_Player()
	{
		if(Player.size() == 0)
		{
			System.out.println("������ ����Ǿ����ϴ�. �¸��ڴ� Player �Դϴ�!");
			
			if(Com1.size() > Com2.size())
				System.out.println("2��:Com1, 3��: Com2");
			else if(Com1.size() == Com2.size())
				System.out.println("���� 2��:Com1, Com2");
			else if(Com1.size() < Com2.size())
				System.out.println("2��:Com2, 3��: Com1");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void Turn_Com1()
	{
		System.out.println("���� ������ ī�� : " + set.get(0));		//�ٴڿ� ������ ī�� ���
		
		System.out.print("���� Com1�� ������ �ִ� ī�� : ");		//Player�� ī�� ���
		for(String i : Com1)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����
		
		for(int i = 0; i < Com1.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Com1.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Com1.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Com1.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(���� ���ڰ� ���� ī��� ���� �� ������ ������� �ʾƵ� ��)
		
		if(Card_CanPlay_Index.size() == 0)		//���ٸ� Cardset �� ���������� �̾ƿ���
		{
			Com1.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\nCom1�� �� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�.\n");
			System.out.println("���� ī�� : " + Com1.get(Com1.size()-1));
		}
		else									//�ִٸ� �� �� �ִ� ī�� ����
		{
			System.out.println("\nCom1�� " + Com1.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
			
			set.add(0, Com1.get(0));
			Com1.remove(Com1.get(Card_CanPlay_Index.get(0)));
		}
		
		isGameFinished_Com1();
	}	
	void isGameFinished_Com1()
	{
		if(Com1.size() == 0)
		{
			System.out.println("������ ����Ǿ����ϴ�. �¸��ڴ� Com1 �Դϴ�!");
			
			if(Player.size() > Com2.size())
				System.out.println("2��:Player, 3��: Com2");
			else if(Player.size() == Com2.size())
				System.out.println("���� 2��:Player, Com2");
			else if(Player.size() < Com2.size())
				System.out.println("2��:Com2, 3��: Player");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void Turn_Com2()
	{
		System.out.println("���� ������ ī�� : " + set.get(0));		//�ٴڿ� ������ ī�� ���
		
		System.out.print("���� Com2�� ������ �ִ� ī�� : ");		//Player�� ī�� ���
		for(String i : Com2)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����
		
		for(int i = 0; i < Com2.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Com2.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Com2.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
		{
			String temp, temp2;
			temp = Com2.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(���� ���ڰ� ���� ī��� ���� �� ������ ������� �ʾƵ� ��)
		
		if(Card_CanPlay_Index.size() == 0)		//���ٸ� Cardset �� ���������� �̾ƿ���
		{
			Com2.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\nCom1�� �� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�.\n");
			System.out.println("���� ī�� : " + Com2.get(Com2.size()-1));
		}
		else									//�ִٸ� �� �� �ִ� ī�� ����
		{
			System.out.println("\nCom1�� " + Com2.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
			
			set.add(0, Com2.get(0));
			Com2.remove(Com2.get(Card_CanPlay_Index.get(0)));
		}
		
		isGameFinished_Com2();
	}
	void isGameFinished_Com2()
	{
		if(Com2.size() == 0)
		{
			System.out.println("������ ����Ǿ����ϴ�. �¸��ڴ� Com2 �Դϴ�!");
			
			if(Com1.size() > Player.size())
				System.out.println("2��:Com1, 3��: Player");
			else if(Com1.size() == Player.size())
				System.out.println("���� 2��:Player, Com1");
			else if(Com1.size() < Player.size())
				System.out.println("2��:Player, 3��: Com1");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void AllocateCard()		//ī�� 5�徿 ��� �޼ҵ�
	{
		for(int i=0; i<5; i++)			
		{	
			Player.add(set.get(0));
			set.remove(0);
		}
		for(int i=0; i<5; i++)			
		{	
			Com1.add(set.get(0));
			set.remove(0);
		}
		for(int i=0; i<5; i++)			
		{	
			Com2.add(set.get(0));
			set.remove(0);
		}
	}
	void ResetCardset()		//ī��� ���� �޼ҵ�
	{
		for(int i = 2; i <= 10; i++)
		{
			set.add("��"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("��"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("��"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("��"+i);
		}
	}
	public void Printcardlist()			//���� �۵� Test�� ��� (�����ִ� ī�� ���)
	{
		for(String i : set)	
		{
		    System.out.print(i + " ");
		}
		System.out.println("�ٴڿ� �����Ǿ� �ִ� ī��� : " + set.get(0));
	}
	
}












