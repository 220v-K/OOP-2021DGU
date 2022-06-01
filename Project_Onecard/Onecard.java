package project;

import java.util.*;

public class Onecard
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Cardset deck = new Cardset();


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
                deck.RestartGame();
                while(Cardset.isFinish == false)
                {
                	Cardset.playturn();
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
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> set = new ArrayList<String>();		//Cardset Array
    public static ArrayList<String> Player = new ArrayList<String>();	//Player Card Array
    public static ArrayList<String> Com1 = new ArrayList<String>();	//Com1 Card Array
    public static ArrayList<String> Com2 = new ArrayList<String>();	//Com2 Card Array

    public static String frontcard;

    //게임 (재)시작
    public void RestartGame()
    {
        set.clear();					//게임 재시작을 위한 ArrayList clear.
        Player.clear();
        Com1.clear();
        Com2.clear();

        ResetCardset();					//Cardset Reset

        Collections.shuffle(set);		//Cardset Shuffle

        AllocateCard();					//카드 7장씩 배분

        frontcard = set.get(0);			//맨 위의 카드
    }


    void AllocateCard()		//카드 7장씩 배분 메소드
    {
        for(int i=0; i<7; i++)
        {
            Player.add(set.get(0));
            set.remove(0);
        }
        for(int i=0; i<7; i++)
        {
            Com1.add(set.get(0));
            set.remove(0);
        }
        for(int i=0; i<7; i++)
        {
            Com2.add(set.get(0));
            set.remove(0);
        }
    }

    //덱을 총 53장이 포함되도록 리셋시킴
    void ResetCardset()
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
        set.add("♠A");set.add("◆A");set.add("♥A");set.add("♣A");
        set.add("♠Q");set.add("◆Q");set.add("♥Q");set.add("♣Q");
        set.add("♠J");set.add("◆J");set.add("♥J");set.add("♣J");
        set.add("♠K");set.add("◆K");set.add("♥K");set.add("♣K");
        set.add("Joker");
    }
    
    public static boolean turn_right = true;	//턴이 돌아가는 방향
    public static int turn = 0;	//누구의 턴인지를 결정하는 변수
    public static int attack_card_count = 0;
    public static boolean isAttack = false;
    public static boolean isFinish = false;

    //메소드 사용을 위한 3명의 플레이어의 객체 생성
    static Player player = new Player();
    static Com1 com1 = new Com1();
    static Com2 com2 = new Com2();
    
    public static void playturn()
    {
        //게임이 끝났는지 확인
        if(Cardset.Player.size() == 0)
        {
            System.out.println("Player 승리!");
            isFinish = true;
        }
        else if(Cardset.Com1.size() == 0)
        {
            System.out.println("Com1 승리!");
            isFinish = true;
        }
        if(Cardset.Com2.size() == 0)
        {
            System.out.println("Com2 승리!");
            isFinish = true;
        }

        //공격을 받은 턴
        if(isAttack = true)
        {
            //Player turn
            if (turn == 0)
            {
                player.canplay_attack();
                player.selectcard_attack();
            }
            //Com1 turn
            else if (turn == 1)
            {
                com1.canplay_attack();
                com1.selectcard_attack();
            }
            //Com2 turn
            else if (turn == 2)
            {
                com2.canplay_attack();
                com2.selectcard_attack();
            }
            else
            {
                System.out.println("Unexpected Error");
            }

            //공격이 끝났다면
            if(Cardset.frontcard.substring(1).equals("2") ||
                    Cardset.frontcard.substring(1).equals("A") ||
                    Cardset.frontcard.equals("Joker"))
            {}
            else
            {
                isAttack = false;
            }
        }
        //공격을 받지 않은 턴
        else
        {
            //Player turn
            if (turn == 0)
            {
                player.canplay();
                player.selectcard();
            }
            //Com1 turn
            else if (turn == 1)
            {
                com1.canplay();
                com1.selectcard();
            }
            //Com2 turn
            else if (turn == 2)
            {
                com2.canplay();
                com2.selectcard();
            }
            else
            {
                System.out.println("Unexpected Error");
            }
        }

        //Joker, A, 2, Q, J, K, 7의 처리는 여기에서 해준다.
        if(Cardset.frontcard.substring(1).equals("2") ||
                Cardset.frontcard.substring(1).equals("A") ||
                Cardset.frontcard.equals("Joker"))
        {
            isAttack = true;
        }
        else if(Cardset.frontcard.substring(1).equals("Q"))
        {
            //turn_right를 반대로 바꾸어 줌.
            if(turn_right == true)
                turn_right = false;
            else
                turn_right = true;
        }
        else if(Cardset.frontcard.substring(1).equals("J"))
        {
            //여기서 턴을 한 번 넘기고, 아래에서 한번 더 넘기면 점프한 것이 됨.
            if(turn_right == true)
            {
                if(turn == 2)
                    turn = 0;
                else
                    turn++;
            }
            else
            {
                if(turn == 0)
                    turn = 2;
                else
                    turn--;
            }
        }
        else if(Cardset.frontcard.substring(1).equals("K"))
        {
            //여기서는 J와 반대로, 턴을 반대로 한 번 간 후에, 다시 아래에서 한 번 넘기면 K를 낸 사람의 차례가 한 번 더 돌아옴.
            if(turn_right == true)
            {
                if(turn == 0)
                    turn = 2;
                else
                    turn--;
            }
            else
            {
                if(turn == 2)
                    turn = 0;
                else
                    turn++;
            }
        }
        else if(Cardset.frontcard.substring(1).equals("7"))
        {
            //Player가 냈을 때는 직접 선택하도록
            if(turn == 0)
            {
                int shape_tochange;
                System.out.println("바꿀 모양을 선택하세요. 1:♠ 2:◆ 3:♥ 4:♣");
                shape_tochange = sc.nextInt();

                switch(shape_tochange)
                {
                    case 1:
                        Cardset.frontcard = "♠"+Cardset.frontcard.substring(1); break;
                    case 2:
                        Cardset.frontcard = "◆"+Cardset.frontcard.substring(1); break;
                    case 3:
                        Cardset.frontcard = "♥"+Cardset.frontcard.substring(1); break;
                    case 4:
                        Cardset.frontcard = "♣"+Cardset.frontcard.substring(1); break;
                }

                System.out.println("모양이 " + Cardset.frontcard.substring(0,1) + "로 바뀜. 현재 공개된 카드 : " + Cardset.frontcard);
            }
            //Com1, Com2가 냈을 때는 랜덤으로
            else
            {
                int shape_tochange = (int)( (Math.random() * 4) % 4 + 1 ) ;

                switch(shape_tochange)
                {
                    case 1:
                        Cardset.frontcard = "♠"+Cardset.frontcard.substring(1); break;
                    case 2:
                        Cardset.frontcard = "◆"+Cardset.frontcard.substring(1); break;
                    case 3:
                        Cardset.frontcard = "♥"+Cardset.frontcard.substring(1); break;
                    case 4:
                        Cardset.frontcard = "♣"+Cardset.frontcard.substring(1); break;
                }

                System.out.println("모양이 " + Cardset.frontcard.substring(0,1) + "로 바뀜. 현재 공개된 카드 : " + Cardset.frontcard);
            }
        }
        //다음 턴으로 넘김
        next_turn();
    }
    static void next_turn()
    {
        //턴이 오른쪽으로 도는지 왼쪽으로 도는지
        if(turn_right == true)
        {
            if(turn == 2)
                turn = 0;
            else
                turn++;
        }
        else
        {
            if(turn == 0)
                turn = 2;
            else
                turn--;
        }
    }
    
    //남은 카드 출력
    void Leftcards()
    {
        for(String i : set)
        {
            System.out.print(i + " ");
        }
        System.out.println("바닥에 공개되어 있는 카드는 : " + set.get(0));
        System.out.println("바닥에 남은 카드 개수 : " + set.size());
    }

}




abstract class Gamer
{
    //낼 수 있는 카드 찾고 출력 메소드
    abstract void canplay();

    //낼 카드 선택
    abstract void selectcard();

    //공격당했을 때의 버전
    abstract void canplay_attack();
    abstract void selectcard_attack();
}

class Player extends Gamer
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장


    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Player.size(); i++)		//모양이 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Player.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Player.size(); i++)		//숫자가 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Player.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(1).equals(temp2.substring(1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }
        //(모양과 숫자가 같은 카드는 있을 수 없으니 고려하지 않아도 됨)
    }
    public void selectcard()
    {
        //낼 카드가 없다면 Cardset 맨 마지막에서 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Player.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\n낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다!");
            System.out.println("뽑은 카드 : " + Cardset.Player.get(Cardset.Player.size()-1) + "\n");
        }
        //낼 카드가 있다면 선택하기
        else
        {
            System.out.print("\n낼 카드를 선택하세요! : ");
            for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
            {
                System.out.print( i + ". " + Cardset.Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
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

            System.out.println(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Player.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Player.get(pick-1));
            Cardset.Player.remove(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)));
        }
    }

    // 공격한 후 다음 차례에 낼 수 있는 카드 선별
    public void canplay_attack()
    {
        Card_CanPlay_Index.clear();

        if(Cardset.frontcard.equals("Joker"))
        {
            Cardset.attack_card_count += 5;
        }
        else if(Cardset.frontcard.substring(1).equals("A"))
        {
        	Cardset.attack_card_count += 3;

            for(int i = 0; i < Cardset.Player.size(); i++)		//A가 있는 지 or 조커가 있는 지
            {
                String temp;
                temp = Cardset.Player.get(i);
                if (temp.substring(1).equals("A") || temp.equals("Joker"))
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
        else if(Cardset.frontcard.substring(1).equals("2"))
        {
        	Cardset.attack_card_count += 2;

            for(int i = 0; i < Cardset.Player.size(); i++)		//모양이 같은 A나, 모양이 다른 2나, 조커가 있는 지
            {
                String temp, temp2;
                temp = Cardset.Player.get(i);
                temp2 = Cardset.frontcard;
                if ( (temp.substring(0,1).equals(temp2.substring(0,1)) && temp.substring(1).equals("A")) ||
                        (temp.substring(1).equals("2")) || temp.equals("Joker") )
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
    }
    // 공격한 후 다음 차례에 낼 카드 선택
    public void selectcard_attack()
    {
        //낼 카드가 없다면 Cardset 맨 마지막에서 공격당한 개수 만큼 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count 개의 카드를 뽑음
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Player.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }

            System.out.println("\n낼 수 있는 카드가 없어 맨 끝에서 카드를 " + Cardset.attack_card_count + "개 뽑아왔습니다!");
            Cardset.attack_card_count = 0;	//이건 카드를 받았으니 초기화시켜줌
        }
        //낼 카드가 있다면 선택
        else
        {
            System.out.print("\n낼 카드를 선택하세요! : ");
            for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
            {
                System.out.print( i + ". " + Cardset.Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
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

            System.out.println(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Player.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Player.get(pick-1));
            Cardset.Player.remove(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)));
        }
    }

}
class Com1 extends Gamer
{
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장

    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Com1.size(); i++)		//모양이 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Com1.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Com1.size(); i++)		//숫자가 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Com1.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(1).equals(temp2.substring(1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }
    }
    public void selectcard()
    {
        //낼 카드가 없다면 맨 마지막에서 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Com1.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\nCom1이 낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다!");
            System.out.println("뽑은 카드 : " + Cardset.Com1.get(Cardset.Com1.size()-1) + "\n");
        }
        //낼 카드가 있다면 내기
        else
        {
            System.out.println("\nCom1이 " + Cardset.Com1.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Com1.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com1.get(0));
            Cardset.Com1.remove(Cardset.Com1.get(Card_CanPlay_Index.get(0)));
        }
    }

    public void canplay_attack()
    {
        Card_CanPlay_Index.clear();

        if(Cardset.frontcard.equals("Joker"))
        {
        	Cardset.attack_card_count += 5;
        }
        else if(Cardset.frontcard.substring(1).equals("A"))
        {
        	Cardset.attack_card_count += 3;

            for(int i = 0; i < Cardset.Com1.size(); i++)		//A가 있는 지 or 조커가 있는 지
            {
                String temp;
                temp = Cardset.Com1.get(i);
                if (temp.substring(1).equals("A") || temp.equals("Joker"))
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
        else if(Cardset.frontcard.substring(1).equals("2"))
        {
        	Cardset.attack_card_count += 2;

            for(int i = 0; i < Cardset.Com1.size(); i++)		//모양이 같은 A나, 모양이 다른 2나, 조커가 있는 지
            {
                String temp, temp2;
                temp = Cardset.Com1.get(i);
                temp2 = Cardset.frontcard;
                if ( (temp.substring(0,1).equals(temp2.substring(0,1)) && temp.substring(1).equals("A")) ||
                        (temp.substring(1).equals("2")) || temp.equals("Joker") )
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
    }
    public void selectcard_attack()
    {
        //낼 카드가 없다면 Cardset 맨 마지막에서 공격당한 개수 만큼 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count 개의 카드를 뽑음
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Com1.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }
            System.out.println("\n낼 수 있는 카드가 없어 맨 끝에서 카드를 " + Cardset.attack_card_count + "개 뽑아왔습니다!");
            Cardset.attack_card_count = 0;	//이건 카드를 받았으니 초기화시켜줌
        }
        //낼 카드가 있다면 내기
        else
        {
            System.out.println("\nCom1이 " + Cardset.Com1.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Com1.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com1.get(0));
            Cardset.Com1.remove(Cardset.Com1.get(Card_CanPlay_Index.get(0)));
        }
    }

}

class Com2 extends Gamer
{
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//낼 수 있는 카드의 ArrayList에서의 index 저장

    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Com2.size(); i++)		//모양이 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Com2.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Com2.size(); i++)		//숫자가 같은 카드가 있는 지 검사
        {
            String temp, temp2;
            temp = Cardset.Com2.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(1).equals(temp2.substring(1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }
    }
    public void selectcard()
    {
        //낼 카드가 없다면 맨 마지막에서 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Com2.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\nCom2이 낼 수 있는 카드가 없어 맨 끝에서 카드를 뽑아왔습니다!");
            System.out.println("뽑은 카드 : " + Cardset.Com2.get(Cardset.Com2.size()-1) + "\n");
        }
        //낼 카드가 있다면 내기
        else
        {
            System.out.println("\nCom2이 " + Cardset.Com2.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Com2.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com2.get(0));
            Cardset.Com2.remove(Cardset.Com2.get(Card_CanPlay_Index.get(0)));
        }
    }

    public void canplay_attack()
    {
        Card_CanPlay_Index.clear();

        if(Cardset.frontcard.equals("Joker"))
        {
        	Cardset.attack_card_count += 5;
        }
        else if(Cardset.frontcard.substring(1).equals("A"))
        {
        	Cardset.attack_card_count += 3;

            for(int i = 0; i < Cardset.Com2.size(); i++)		//A가 있는 지 or 조커가 있는 지
            {
                String temp;
                temp = Cardset.Com2.get(i);
                if (temp.substring(1).equals("A") || temp.equals("Joker"))
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
        else if(Cardset.frontcard.substring(1).equals("2"))
        {
        	Cardset.attack_card_count += 2;

            for(int i = 0; i < Cardset.Com2.size(); i++)		//모양이 같은 A나, 모양이 다른 2나, 조커가 있는 지
            {
                String temp, temp2;
                temp = Cardset.Com2.get(i);
                temp2 = Cardset.frontcard;
                if ( (temp.substring(0,1).equals(temp2.substring(0,1)) && temp.substring(1).equals("A")) ||
                        (temp.substring(1).equals("2")) || temp.equals("Joker") )
                {
                    Card_CanPlay_Index.add(i);
                }
            }
        }
    }
    public void selectcard_attack()
    {
        //낼 카드가 없다면 Cardset 맨 마지막에서 공격당한 개수 만큼 뽑아오기
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count 개의 카드를 뽑음
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Com2.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }
            System.out.println("\n낼 수 있는 카드가 없어 맨 끝에서 카드를 " + Cardset.attack_card_count + "개 뽑아왔습니다!");
            Cardset.attack_card_count = 0;	//이건 카드를 받았으니 초기화시켜줌
        }
        //낼 카드가 있다면 내기
        else
        {
            System.out.println("\nCom2이 " + Cardset.Com2.get(Card_CanPlay_Index.get(0)) + "를 냈습니다.\n");
            Cardset.frontcard = Cardset.Com2.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com2.get(0));
            Cardset.Com2.remove(Cardset.Com2.get(Card_CanPlay_Index.get(0)));
        }
    }
}
