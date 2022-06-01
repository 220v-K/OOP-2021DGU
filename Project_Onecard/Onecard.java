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
                deck.RestartGame();
                while(Cardset.isFinish == false)
                {
                	Cardset.playturn();
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
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> set = new ArrayList<String>();		//Cardset Array
    public static ArrayList<String> Player = new ArrayList<String>();	//Player Card Array
    public static ArrayList<String> Com1 = new ArrayList<String>();	//Com1 Card Array
    public static ArrayList<String> Com2 = new ArrayList<String>();	//Com2 Card Array

    public static String frontcard;

    //���� (��)����
    public void RestartGame()
    {
        set.clear();					//���� ������� ���� ArrayList clear.
        Player.clear();
        Com1.clear();
        Com2.clear();

        ResetCardset();					//Cardset Reset

        Collections.shuffle(set);		//Cardset Shuffle

        AllocateCard();					//ī�� 7�徿 ���

        frontcard = set.get(0);			//�� ���� ī��
    }


    void AllocateCard()		//ī�� 7�徿 ��� �޼ҵ�
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

    //���� �� 53���� ���Եǵ��� ���½�Ŵ
    void ResetCardset()
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
        set.add("��A");set.add("��A");set.add("��A");set.add("��A");
        set.add("��Q");set.add("��Q");set.add("��Q");set.add("��Q");
        set.add("��J");set.add("��J");set.add("��J");set.add("��J");
        set.add("��K");set.add("��K");set.add("��K");set.add("��K");
        set.add("Joker");
    }
    
    public static boolean turn_right = true;	//���� ���ư��� ����
    public static int turn = 0;	//������ �������� �����ϴ� ����
    public static int attack_card_count = 0;
    public static boolean isAttack = false;
    public static boolean isFinish = false;

    //�޼ҵ� ����� ���� 3���� �÷��̾��� ��ü ����
    static Player player = new Player();
    static Com1 com1 = new Com1();
    static Com2 com2 = new Com2();
    
    public static void playturn()
    {
        //������ �������� Ȯ��
        if(Cardset.Player.size() == 0)
        {
            System.out.println("Player �¸�!");
            isFinish = true;
        }
        else if(Cardset.Com1.size() == 0)
        {
            System.out.println("Com1 �¸�!");
            isFinish = true;
        }
        if(Cardset.Com2.size() == 0)
        {
            System.out.println("Com2 �¸�!");
            isFinish = true;
        }

        //������ ���� ��
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

            //������ �����ٸ�
            if(Cardset.frontcard.substring(1).equals("2") ||
                    Cardset.frontcard.substring(1).equals("A") ||
                    Cardset.frontcard.equals("Joker"))
            {}
            else
            {
                isAttack = false;
            }
        }
        //������ ���� ���� ��
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

        //Joker, A, 2, Q, J, K, 7�� ó���� ���⿡�� ���ش�.
        if(Cardset.frontcard.substring(1).equals("2") ||
                Cardset.frontcard.substring(1).equals("A") ||
                Cardset.frontcard.equals("Joker"))
        {
            isAttack = true;
        }
        else if(Cardset.frontcard.substring(1).equals("Q"))
        {
            //turn_right�� �ݴ�� �ٲپ� ��.
            if(turn_right == true)
                turn_right = false;
            else
                turn_right = true;
        }
        else if(Cardset.frontcard.substring(1).equals("J"))
        {
            //���⼭ ���� �� �� �ѱ��, �Ʒ����� �ѹ� �� �ѱ�� ������ ���� ��.
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
            //���⼭�� J�� �ݴ��, ���� �ݴ�� �� �� �� �Ŀ�, �ٽ� �Ʒ����� �� �� �ѱ�� K�� �� ����� ���ʰ� �� �� �� ���ƿ�.
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
            //Player�� ���� ���� ���� �����ϵ���
            if(turn == 0)
            {
                int shape_tochange;
                System.out.println("�ٲ� ����� �����ϼ���. 1:�� 2:�� 3:�� 4:��");
                shape_tochange = sc.nextInt();

                switch(shape_tochange)
                {
                    case 1:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 2:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 3:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 4:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                }

                System.out.println("����� " + Cardset.frontcard.substring(0,1) + "�� �ٲ�. ���� ������ ī�� : " + Cardset.frontcard);
            }
            //Com1, Com2�� ���� ���� ��������
            else
            {
                int shape_tochange = (int)( (Math.random() * 4) % 4 + 1 ) ;

                switch(shape_tochange)
                {
                    case 1:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 2:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 3:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                    case 4:
                        Cardset.frontcard = "��"+Cardset.frontcard.substring(1); break;
                }

                System.out.println("����� " + Cardset.frontcard.substring(0,1) + "�� �ٲ�. ���� ������ ī�� : " + Cardset.frontcard);
            }
        }
        //���� ������ �ѱ�
        next_turn();
    }
    static void next_turn()
    {
        //���� ���������� ������ �������� ������
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
    
    //���� ī�� ���
    void Leftcards()
    {
        for(String i : set)
        {
            System.out.print(i + " ");
        }
        System.out.println("�ٴڿ� �����Ǿ� �ִ� ī��� : " + set.get(0));
        System.out.println("�ٴڿ� ���� ī�� ���� : " + set.size());
    }

}




abstract class Gamer
{
    //�� �� �ִ� ī�� ã�� ��� �޼ҵ�
    abstract void canplay();

    //�� ī�� ����
    abstract void selectcard();

    //���ݴ����� ���� ����
    abstract void canplay_attack();
    abstract void selectcard_attack();
}

class Player extends Gamer
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����


    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Player.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
        {
            String temp, temp2;
            temp = Cardset.Player.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Player.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
        {
            String temp, temp2;
            temp = Cardset.Player.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(1).equals(temp2.substring(1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }
        //(���� ���ڰ� ���� ī��� ���� �� ������ ������� �ʾƵ� ��)
    }
    public void selectcard()
    {
        //�� ī�尡 ���ٸ� Cardset �� ���������� �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Player.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\n�� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�!");
            System.out.println("���� ī�� : " + Cardset.Player.get(Cardset.Player.size()-1) + "\n");
        }
        //�� ī�尡 �ִٸ� �����ϱ�
        else
        {
            System.out.print("\n�� ī�带 �����ϼ���! : ");
            for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
            {
                System.out.print( i + ". " + Cardset.Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
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

            System.out.println(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)) + "�� �½��ϴ�.\n");
            Cardset.frontcard = Cardset.Player.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Player.get(pick-1));
            Cardset.Player.remove(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)));
        }
    }

    // ������ �� ���� ���ʿ� �� �� �ִ� ī�� ����
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

            for(int i = 0; i < Cardset.Player.size(); i++)		//A�� �ִ� �� or ��Ŀ�� �ִ� ��
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

            for(int i = 0; i < Cardset.Player.size(); i++)		//����� ���� A��, ����� �ٸ� 2��, ��Ŀ�� �ִ� ��
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
    // ������ �� ���� ���ʿ� �� ī�� ����
    public void selectcard_attack()
    {
        //�� ī�尡 ���ٸ� Cardset �� ���������� ���ݴ��� ���� ��ŭ �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count ���� ī�带 ����
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Player.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }

            System.out.println("\n�� �� �ִ� ī�尡 ���� �� ������ ī�带 " + Cardset.attack_card_count + "�� �̾ƿԽ��ϴ�!");
            Cardset.attack_card_count = 0;	//�̰� ī�带 �޾����� �ʱ�ȭ������
        }
        //�� ī�尡 �ִٸ� ����
        else
        {
            System.out.print("\n�� ī�带 �����ϼ���! : ");
            for(int i=1; i<Card_CanPlay_Index.size()+1; i++)
            {
                System.out.print( i + ". " + Cardset.Player.get( Card_CanPlay_Index.get(i-1) ) + "  " );
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

            System.out.println(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)) + "�� �½��ϴ�.\n");
            Cardset.frontcard = Cardset.Player.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Player.get(pick-1));
            Cardset.Player.remove(Cardset.Player.get(Card_CanPlay_Index.get(pick-1)));
        }
    }

}
class Com1 extends Gamer
{
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����

    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Com1.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
        {
            String temp, temp2;
            temp = Cardset.Com1.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Com1.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
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
        //�� ī�尡 ���ٸ� �� ���������� �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Com1.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\nCom1�� �� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�!");
            System.out.println("���� ī�� : " + Cardset.Com1.get(Cardset.Com1.size()-1) + "\n");
        }
        //�� ī�尡 �ִٸ� ����
        else
        {
            System.out.println("\nCom1�� " + Cardset.Com1.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
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

            for(int i = 0; i < Cardset.Com1.size(); i++)		//A�� �ִ� �� or ��Ŀ�� �ִ� ��
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

            for(int i = 0; i < Cardset.Com1.size(); i++)		//����� ���� A��, ����� �ٸ� 2��, ��Ŀ�� �ִ� ��
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
        //�� ī�尡 ���ٸ� Cardset �� ���������� ���ݴ��� ���� ��ŭ �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count ���� ī�带 ����
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Com1.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }
            System.out.println("\n�� �� �ִ� ī�尡 ���� �� ������ ī�带 " + Cardset.attack_card_count + "�� �̾ƿԽ��ϴ�!");
            Cardset.attack_card_count = 0;	//�̰� ī�带 �޾����� �ʱ�ȭ������
        }
        //�� ī�尡 �ִٸ� ����
        else
        {
            System.out.println("\nCom1�� " + Cardset.Com1.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
            Cardset.frontcard = Cardset.Com1.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com1.get(0));
            Cardset.Com1.remove(Cardset.Com1.get(Card_CanPlay_Index.get(0)));
        }
    }

}

class Com2 extends Gamer
{
    ArrayList<Integer> Card_CanPlay_Index = new ArrayList<Integer>();		//�� �� �ִ� ī���� ArrayList������ index ����

    public void canplay()
    {
        Card_CanPlay_Index.clear();

        for(int i = 0; i < Cardset.Com2.size(); i++)		//����� ���� ī�尡 �ִ� �� �˻�
        {
            String temp, temp2;
            temp = Cardset.Com2.get(i);
            temp2 = Cardset.frontcard;
            if (temp.substring(0,1).equals(temp2.substring(0,1)))
            {
                Card_CanPlay_Index.add(i);
            }
        }

        for(int i = 0; i < Cardset.Com2.size(); i++)		//���ڰ� ���� ī�尡 �ִ� �� �˻�
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
        //�� ī�尡 ���ٸ� �� ���������� �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            Cardset.Com2.add(Cardset.set.get(Cardset.set.size()-1));
            Cardset.set.remove(Cardset.set.size()-1);
            System.out.println("\nCom2�� �� �� �ִ� ī�尡 ���� �� ������ ī�带 �̾ƿԽ��ϴ�!");
            System.out.println("���� ī�� : " + Cardset.Com2.get(Cardset.Com2.size()-1) + "\n");
        }
        //�� ī�尡 �ִٸ� ����
        else
        {
            System.out.println("\nCom2�� " + Cardset.Com2.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
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

            for(int i = 0; i < Cardset.Com2.size(); i++)		//A�� �ִ� �� or ��Ŀ�� �ִ� ��
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

            for(int i = 0; i < Cardset.Com2.size(); i++)		//����� ���� A��, ����� �ٸ� 2��, ��Ŀ�� �ִ� ��
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
        //�� ī�尡 ���ٸ� Cardset �� ���������� ���ݴ��� ���� ��ŭ �̾ƿ���
        if(Card_CanPlay_Index.size() == 0)
        {
            //attack_card_count ���� ī�带 ����
            for(int i=0; i<Cardset.attack_card_count; i++)
            {
                Cardset.Com2.add(Cardset.set.get(Cardset.set.size()-1));
                Cardset.set.remove(Cardset.set.size()-1);
            }
            System.out.println("\n�� �� �ִ� ī�尡 ���� �� ������ ī�带 " + Cardset.attack_card_count + "�� �̾ƿԽ��ϴ�!");
            Cardset.attack_card_count = 0;	//�̰� ī�带 �޾����� �ʱ�ȭ������
        }
        //�� ī�尡 �ִٸ� ����
        else
        {
            System.out.println("\nCom2�� " + Cardset.Com2.get(Card_CanPlay_Index.get(0)) + "�� �½��ϴ�.\n");
            Cardset.frontcard = Cardset.Com2.get(Card_CanPlay_Index.get(0));

            Cardset.set.add(0, Cardset.Com2.get(0));
            Cardset.Com2.remove(Cardset.Com2.get(Card_CanPlay_Index.get(0)));
        }
    }
}
