package assignment_week_12;

public class test{

	static void exe(exercise ex)
	{
		ex.play();
	}
	
	public static void main(String[] args) 
	{
		exercise[] ex_list = new exercise[4];
		
		for(int i = 0; i < 4; i++)
		{
			ex_list[i] = select(i);
			exe(ex_list[i]);
		}
	}

	static exercise select(int i)
	{
		if (i == 0)
			return new exercise();
		else if(i == 1)
			return new baseball();
		else if(i == 2)
			return new soccer();
		else if(i == 3)
			return new basketball();
		return null;
	}
}

class exercise
{
	void play()
	{
		System.out.println("play exercise");
	}
}

class baseball extends exercise
{
	void play()
	{
		System.out.println("play baseball");
	}
}

class soccer extends exercise
{
	void play()
	{
		System.out.println("play soccer");
	}
}

class basketball extends exercise
{
	void play()
	{
		System.out.println("play basketball");
	}
}


