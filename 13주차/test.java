import java.text.DecimalFormat;
import java.util.*;
import java.lang.Object;

public class test
{
    public static void main(String[] args)
    {
        Car.print_car_number();
        Car ca1 = new Car("car1", 1234);
        Car ca2 = new Car("car2");
        Car ca3 = new Car("car3");

        Car.print_car_info(ca1);
        Car.print_car_info(ca2);

        ca1.price(); ca2.price(); ca3.price();
        Car.print_car_number();
    }


}

class Car
{
    //금액 표시할 때, 3자리마다 쉼표 출력
    DecimalFormat format = new DecimalFormat("###,###");

    //Car 객체의 객체 변수가 될 친구들
    String carname;
    int carnum;
    int carprice = (int)(Math.random() * 899999999 + 100000000);    //100,000,000 ~ 999,999,999 사이의 숫자가 가격으로 책정.
    //Car 객체가 생성된 개수. static을 이용해 클래스 변수로 생성.
    static int car_count = 0;

    //Car 클래스의 생성자 오버로딩.
    Car(String carname, int carnum)
    {
        this.carname = carname;
        this.carnum = carnum;
        System.out.println("make " + carname + "& number is " + carnum);
        car_count++;
    }
    Car(String carname)
    {
        this.carname = carname;
        this.carnum = (int)(Math.random() * 9998 + 1);  // 1~9999의 숫자 랜덤
        System.out.println("make " + carname + "& number is " + this.carnum);
        car_count++;
    }

    static void print_car_number()
    {
        System.out.println("car_count is " + car_count);
    }

    static void print_car_info(Car car)
    {
        System.out.println("car_name is " + car.carname + " & car_number is " + car.carnum);
    }

    void price()
    {
        System.out.println("The price is " + format.format(carprice));
    }
}