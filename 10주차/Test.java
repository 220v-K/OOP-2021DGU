package assignment_week_9;

public class Test {
	public static Animal[] animals;
	public static void main(String[] args)
	{
		animals = new Animal[3]; 
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Cow();
		
		for(int i=0; i<animals.length; i++)
		{
			animals[i].bark();
		}
	}
}

abstract class Animal{
	public abstract void bark();
}
class Cat extends Animal
{
	public void bark()
	{
		System.out.println("Yawong~");
	}
}
class Dog extends Animal
{
	public void bark()
	{
		System.out.println("Bow wow");
	}
}
class Cow extends Animal
{
	public void bark()
	{
		System.out.println("Hmme~~~");
	}
}