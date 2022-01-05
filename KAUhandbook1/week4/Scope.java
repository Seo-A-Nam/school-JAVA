//Scope class demonstrates field and local variable scopes
public class Scope {
	//field that is accessible to all methods of this class
	private static int x = 1;
	
	//methods begin creates and initializes local variable x
	//and calls methods useLocalVariable and useField
	public static void main(String[] args) 
	//원래는 main이 아니라 함수 begin이었음. x가 static도 아니었음. 실행시키기 위해 임의로 main으로 바꾼 것 
	//
	{
		int x = 5;
		System.out.printf("local x in method begin is %d\n", x);
		useLocalVariable();
		useField();
		useLocalVariable();	
		useField();
		
		System.out.printf("\nlocal x in method begins is %d\n", x);
	}
	
	//creates and initialize local variable x during each call
	public static void useLocalVariable()
	{
		int x = 25; //initialized each time useLocalVariable is called
		System.out.printf("\nlocal x on entering method useLocalVariable is %d\n",x);
		++x;	//modifies this method's local variable x
		System.out.printf("\nlocal x before exiting method useLocalVariable is %d\n",x);
	}
	
	//modify class Scope's field x during each call
	public static void useField()
	{
		System.out.printf("\nfield x on entering method useField is %d\n",x);
		x*=10;	//modifies class Scope's field x	//instance variable
		System.out.printf("\nfield x before exiting method useField is %d\n",x);
	}
}
