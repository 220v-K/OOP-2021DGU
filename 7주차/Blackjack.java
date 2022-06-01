package assignment_week_7;

import java.util.*;


public class Blackjack 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Cardset test = new Cardset();
		
		int howmany_gameplayed = 0;
		int cmd;
		boolean isGamestart = false;
		
		Printcommand();
		do
		{
			System.out.println();
			System.out.println("Enter Command : ");
			cmd = sc.nextInt();
			
			switch(cmd)
			{
			case 1:
				howmany_gameplayed++;
				System.out.println("Game Start!");
				System.out.println("Number of times this game has run : " + howmany_gameplayed);
				test.StartGame();
				isGamestart = true;
				break;
				
			case 2:		
				if (isGamestart == true)
				{
					if (test.try_pick < 3)
					{	
						test.Pickcard();
					}
					if (test.try_pick < 3)
					{
						test.prob_towin();
					}
				}
				else
				{
					System.out.println("Start Game first");
				}
				
				break;
				
			case 3:
				if (isGamestart == true)
				{
					test.Printcardlist();
				}
				else
				{
					System.out.println("Start Game first");
				}
				break;
				
			case 4:
				Printcommand();
				break;
				
			case 5:
				break;
				
			default:
				System.out.println("Enter the proper Command");
			}
		}
		while(cmd != 5);
			
	}
	
	private static void Printcommand()
	{
		System.out.println("Commands");
		System.out.println("1 : Start/Restart a Game");
		System.out.println("2 : Pick a Card");
		System.out.println("3 : Print Card List(remained)");
		System.out.println("4 : Print This Command help");
		System.out.println("5 : Quit Game");
	}
}

class Cardset
{
	ArrayList<String> set = new ArrayList<String>();
	int current_num;	//���� ���� ī���� ���ڵ��� ����.
	int try_pick = 0;
	
	public void StartGame()
	{
		set.clear();	//���� ������� ���� ArrayList clear.
		current_num = 0;	//���� ������� ���� clear.
		try_pick = 0;
		
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
	
	public void Pickcard()		//ī�� �̴� �޼ҵ�
	{
		if (try_pick >= 3 )
		{
			System.out.println("Game is End. Plz Restart.");
		}
		else
		{
		int index;
		String pickitem;
		
		index = (int)( Math.random() * (set.size() - 1) );		// ī�� ���� 36�����, 0~35 ������ (����)���� ����
		pickitem = set.get(index);		//�� index�� ī�� �̾Ƽ� ����
		set.remove(index);				//�� �� ���� ī�� array���� ����
		System.out.println("You Picked : " + pickitem);	//ȭ�鿡 ���� ī�� ���
		
		current_num += Integer.parseInt(pickitem.substring(1));		//���� ī���� ���ڸ� current_num�� �߰�. ���ڿ� �ڸ� �� string->int ����ȯ �̿�.
		System.out.println("Sum of Card : " + current_num);			//���� ī���� �� ���
		
		try_pick++;
		if(try_pick >= 3)
		{
			if (current_num >= 15)
			{
				System.out.println("You win!");
			}
			else
			{
				System.out.println("You Lose!");
			}
		}
		}
		
	}
	
	public void prob_towin()		//ī�� ���� �� Ȯ�� ��� �޼ҵ�
	{
		int[] card_num = new int[set.size()];		//���� ī����� ���ڸ� �����ϴ� int�� �迭 ����
		String tempstr;
		int num_cardtowin = 0;
		
		for (int i = 0; i < set.size(); i++)
		{
			tempstr = set.get(i);
			card_num[i] = Integer.parseInt(tempstr.substring(1));
		}
		
		if (current_num < 5)
		{
			System.out.println("Probability of winning : 0");
		}
		else if(current_num >= 15)
		{
			System.out.println("Probability of winning : 1");
		}
		else
		{
			for(int i = 0; i < set.size(); i++)
			{
				if ( (15 - current_num) <= card_num[i] )	//�̾��� �� �¸��� �� �ִ� ī�� ���� ����
				{
					num_cardtowin++;
				}
			}
			
			System.out.println("Probability of winning : " + (double)( (double)num_cardtowin / (double)set.size()) );
		}
	
	}
	
	public void Printcardlist()		//���� �۵� Test�� ���
	{
		for(String i : set)	
		{
		    System.out.print(i + " ");
		}
	}
}





