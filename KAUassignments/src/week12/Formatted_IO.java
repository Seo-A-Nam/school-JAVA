package week12;

import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.deitel.ch17.AccountRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
/*
1. Scanner�� �̿��Ͽ� Ű����κ��� �Ʒ��� �ִ� 5���� �����͸� �Է��� �޾Ƽ� Formatter�� �̿��Ͽ� ���� formatted1.txt�� �����Ѵ�. 
2. �����͸� �̿��Ͽ� formatted1.txt�� ������ Ȯ���Ѵ�. 
3. Scanner�� test1.txt�� ������ �о heading�� �Բ� 5���� �����͸� �� �ʵ��� ����, ��ġ�� �����ϰ� �Ͽ� ���÷��̷� ����Ѵ�. 
*/

public class Formatted_IO {
	public static void main(String[] args)
	{	
		createText application = new createText();
		application.openFile();
		application.addRecords();
		application.closeFile();
		
		readFile application2 = new readFile();
		application2.openFile();
		application2.readRecords();
		application2.closeFile();
	}
	
	public static class createText
	{
		private Formatter output; //object used to output text to file
		public void openFile() 
		{
			try 
			{
				output = new Formatter("formatted1.txt");
			}
			catch ( SecurityException securityException )
			{
				System.err.println("You do not have write access to this file.");
				System.exit(1);
			}
			catch (FileNotFoundException fileNotFoundException )
			{
				System.err.println("Error opening or creating a file.");
				System.exit(1);
			}
		}
		
		public void addRecords()
		{
			AccountRecord record = new AccountRecord();
			Scanner input = new Scanner(System.in);
			System.out.printf("%s\n%s\n%s\n%s\n\n","To terminate input, type the end-of-file indicator","when you are prompted to enter input.","On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl>z then press Enter");
			System.out.printf("%s\n%s","Enter account number(>0), first name, last name and balance.", "?");
			
			while(input.hasNext())
			{
				try 
				{	//retrieve data to be output
					record.setAccount(input.nextInt());	//read account number
					record.setFirstName(input.next());	//read first name
					record.setLastName(input.next());	//read last name
					record.setBalance(input.nextDouble());	//read balance
					
					if( record.getAccount() > 0 )
					{
						//write new record
						output.format("%d %s %s %.2f\n", record.getAccount(),record.getFirstName(),record.getLastName(),record.getBalance());
					}
					
				}
				catch (FormatterClosedException formatterClosedException )
				{
					System.err.println("Error writing to file.");
					return;
				}
				
				catch ( NoSuchElementException elementException )
				{
					System.err.println("Invalid input. Please try again.");
					input.hasNextLine();//discard input so user can try again
				}
			}
		}
		//close file
		public void closeFile()
		{
			if(output != null)
				output.close();
		}
		
	}
	
	public static class readFile
	{
		private Scanner input;
		
		//enable user to open file
		public void openFile()
		{
			try 
			{
				input = new Scanner(new File("formatted1.txt"));
			}
			catch ( FileNotFoundException fileNotFoundException )
			{
				System.err.println("Error opening file.");
				System.exit(1);
			}
		}
		
		//read record from file
		public void readRecords()
		{

			//object to be written to screen
			AccountRecord record = new AccountRecord();
			System.out.printf("%-10s%-12s%-12s%10s\n","Account","First Name", "Last Name", "Balance");
			try	//read records from file using Scanner object
			{
				File file = new File("IO_redirection1.txt");
				try {
					PrintStream printStream = new PrintStream(new FileOutputStream(file));
					System.setErr(printStream);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				while(input.hasNext())
				{
					record.setAccount(input.nextInt()); 	//read account number
					record.setFirstName(input.next());		//read first name
					record.setLastName(input.next());
					record.setBalance(input.nextDouble()); 
					
					System.err.printf("%-10d%-12s%-12s%10.2f\n",record.getAccount(),record.getFirstName(),record.getLastName(),record.getBalance());
					System.out.printf("%-10d%-12s%-12s%10.2f\n",record.getAccount(),record.getFirstName(),record.getLastName(),record.getBalance());
				}
			}
			
			catch ( NoSuchElementException elementException )
			{
				System.err.println("File improperly formed.");
				input.close();
				System.exit(1);
			}
			
			catch ( IllegalStateException stateException )
			{
				System.err.println("Error reading from file");
				System.exit(1);
			}
		}
		
		public void closeFile()
		{
			if ( input != null )
				input.close();
		}
		
	}
}
