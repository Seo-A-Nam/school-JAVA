package week12;
//Testing class CreateSequentialFile

public class CreateSequentialFileTest {
	public static void main(String[] args)
	{
		CreateSequentialFile application = new CreateSequentialFile();
		
		application.openFile();
		application.addRecords();
		application.closeFile();
	}
}