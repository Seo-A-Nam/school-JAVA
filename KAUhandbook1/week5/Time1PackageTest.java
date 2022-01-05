import com.deitel.jhtp.ch08.Time1;
public class Time1PackageTest {
	public static void main(String[] args)
	{
		//create and initialize a Time1 object
		Time1 time = new Time1(); //생성자 호출
		
		//output string representations of the time
		System.out.print("The initial universal time is: ");
		System.out.println(time.toUniversalString());
		System.out.print("The initial standard time is: ");
		System.out.println(time.toString());
		System.out.println(); //output a blank line
		
		//change time and output updated time
		time.setTime(13, 27, 6);
		System.out.print("Universal time after setTime is: ");
		System.out.println(time.toUniversalString());
		System.out.print("Standard time after setTime is: ");
		System.out.println(time.toString());
	}
}
