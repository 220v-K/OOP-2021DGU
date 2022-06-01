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
			
			System.out.println("\n1: 게임 시작, 2: 게임 종료");	//1이면 게임 시작, 2면 게임 종료. 게임 중 중단 ㄴㄴ, 게임이 끝나면 다시 1 or 2 선택
			cmd = sc.nextInt();
			while(true)
			{
				if(cmd == 1 || cmd == 2)
					break;
				else
				{
					System.out.println("올바른 숫자를 입력해 주세요.");
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
				System.out.println("게임을 종료합니다.");
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
		set.clear();					//게임 재시작을 위한 ArrayList clear.
		Player.clear();
		Com1.clear();
		Com2.clear();

		ResetCardset();					//Cardset Reset
		
		Collections.shuffle(set);		//Cardset Shuffle
		
		AllocateCard();					//카드 5장씩 배분
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
		System.out.println("현재 공개된 카드 : " + set.get(0));		//바닥에 공개된 카드 출력
		
		System.out.print("현재 Player가 가지고 있는 카드 : ");		//Player의 카드 출력
		for(String i : Player)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장
		
		for(int i = 0; i < Player.size(); i++)		//모양이 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Player.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Player.size(); i++)		//숫자가 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Player.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(모양과 숫자가 같은 카드는 있을 수 없으니 고려하지 않아도 됨)
		
		if(Card_CanPlay_Index.size() == 0)		//없다면 Cardset 맨 마지막에서 뽑아오기
		{
			Player.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\n낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다!");
			System.out.println("뽑은 카드 : " + Player.get(Player.size()-1) + "\n");
		}
		else									//있다면 선택하기
		{
			System.out.print("\n낼 카드를 선택하세요! : ");
			for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
			{
				System.out.print( i + ". " + Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
			}
	
			int pick;
			while(true)		//카드 뽑을 때 잘못된 숫자 입력 오류처리
			{
				pick = sc.nextInt();
				if((1 <= pick) && (pick <= Card_CanPlay_Index.size()) )
				{
					break;
				}
				else
				{
					System.out.println("올바른 숫자를 입력해 주세요");
				}
			}
			
			System.out.println(Player.get(Card_CanPlay_Index.get(pick-1)) + "를 냈습니다.\n");
			
			set.add(0, Player.get(pick-1));
			Player.remove(Player.get(Card_CanPlay_Index.get(pick-1)));
			
			isGameFinished_Player();	//게임 종료 확인
		}
	}	
	void isGameFinished_Player()
	{
		if(Player.size() == 0)
		{
			System.out.println("게임이 종료되었습니다. 승리자는 Player 입니다!");
			
			if(Com1.size() > Com2.size())
				System.out.println("2등:Com1, 3등: Com2");
			else if(Com1.size() == Com2.size())
				System.out.println("공동 2등:Com1, Com2");
			else if(Com1.size() < Com2.size())
				System.out.println("2등:Com2, 3등: Com1");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void Turn_Com1()
	{
		System.out.println("현재 공개된 카드 : " + set.get(0));		//바닥에 공개된 카드 출력
		
		System.out.print("현재 Com1이 가지고 있는 카드 : ");		//Player의 카드 출력
		for(String i : Com1)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장
		
		for(int i = 0; i < Com1.size(); i++)		//모양이 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Com1.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Com1.size(); i++)		//숫자가 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Com1.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(모양과 숫자가 같은 카드는 있을 수 없으니 고려하지 않아도 됨)
		
		if(Card_CanPlay_Index.size() == 0)		//없다면 Cardset 맨 마지막에서 뽑아오기
		{
			Com1.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\nCom1이 낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다.\n");
			System.out.println("뽑은 카드 : " + Com1.get(Com1.size()-1));
		}
		else									//있다면 낼 수 있는 카드 내기
		{
			System.out.println("\nCom1이 " + Com1.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
			
			set.add(0, Com1.get(0));
			Com1.remove(Com1.get(Card_CanPlay_Index.get(0)));
		}
		
		isGameFinished_Com1();
	}	
	void isGameFinished_Com1()
	{
		if(Com1.size() == 0)
		{
			System.out.println("게임이 종료되었습니다. 승리자는 Com1 입니다!");
			
			if(Player.size() > Com2.size())
				System.out.println("2등:Player, 3등: Com2");
			else if(Player.size() == Com2.size())
				System.out.println("공동 2등:Player, Com2");
			else if(Player.size() < Com2.size())
				System.out.println("2등:Com2, 3등: Player");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void Turn_Com2()
	{
		System.out.println("현재 공개된 카드 : " + set.get(0));		//바닥에 공개된 카드 출력
		
		System.out.print("현재 Com2가 가지고 있는 카드 : ");		//Player의 카드 출력
		for(String i : Com2)	
		{
		    System.out.print(i + " ");
		}
		
		ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장
		
		for(int i = 0; i < Com2.size(); i++)		//모양이 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Com2.get(i);
			temp2 = set.get(0);
			if (temp.substring(0,1).equals(temp2.substring(0,1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		
		for(int i = 0; i < Com2.size(); i++)		//숫자가 같은 카드가 있는 지 검사
		{
			String temp, temp2;
			temp = Com2.get(i);
			temp2 = set.get(0);
			if (temp.substring(1).equals(temp2.substring(1)))
			{
				Card_CanPlay_Index.add(i);
			}
		}
		//(모양과 숫자가 같은 카드는 있을 수 없으니 고려하지 않아도 됨)
		
		if(Card_CanPlay_Index.size() == 0)		//없다면 Cardset 맨 마지막에서 뽑아오기
		{
			Com2.add(set.get(set.size()-1));
			set.remove(set.size()-1);
			System.out.println("\nCom1이 낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다.\n");
			System.out.println("뽑은 카드 : " + Com2.get(Com2.size()-1));
		}
		else									//있다면 낼 수 있는 카드 내기
		{
			System.out.println("\nCom1이 " + Com2.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
			
			set.add(0, Com2.get(0));
			Com2.remove(Com2.get(Card_CanPlay_Index.get(0)));
		}
		
		isGameFinished_Com2();
	}
	void isGameFinished_Com2()
	{
		if(Com2.size() == 0)
		{
			System.out.println("게임이 종료되었습니다. 승리자는 Com2 입니다!");
			
			if(Com1.size() > Player.size())
				System.out.println("2등:Com1, 3등: Player");
			else if(Com1.size() == Player.size())
				System.out.println("공동 2등:Player, Com1");
			else if(Com1.size() < Player.size())
				System.out.println("2등:Player, 3등: Com1");
			else
				System.out.println("Unexpected Error");
			
			isGameFinished = true;
		}
	}
	
	void AllocateCard()		//카드 5장씩 배분 메소드
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
	void ResetCardset()		//카드셋 리셋 메소드
	{
		for(int i = 2; i <= 10; i++)
		{
			set.add("♠"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("◆"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("♥"+i);
		}
		for(int i = 2; i <= 10; i++)
		{
			set.add("♣"+i);
		}
	}
	public void Printcardlist()			//정상 작동 Test용 출력 (남아있는 카드 출력)
	{
		for(String i : set)	
		{
		    System.out.print(i + " ");
		}
		System.out.println("바닥에 공개되어 있는 카드는 : " + set.get(0));
	}
	
}












