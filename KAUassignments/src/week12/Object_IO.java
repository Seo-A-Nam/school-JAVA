package week12;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import week12.AccountRecordSerializable;
/*
 1. Ű����κ��� �Ʒ� 5���� �����͸� �Է��� �޾Ƽ� 5���� account ��ü�� �����Ѵ�. 2. �� account ��ü���� (serialize�Ͽ�) ���� test2.acc�� �����Ѵ�. 3. �����͸� �̿��Ͽ� test2.acc�� ������ Ȯ���غ���. 4. test2.acc�� ����� ��ü�� ��� �о ���α׷��� ���� �޸� ��ü�� �����ϰ�
heading�� �Բ� 5���� �����͸� �� �ʵ��� ���� ��ġ�� �����ϰ� �Ͽ� ���÷��̷� ���
�Ѵ�.
 */
public class Object_IO 
{
	public static void main(String[] args) 
	{
		createAccount application = new createAccount();
		application.openFile();
		application.addRecords();
		application.closeFile();
		
		readAccount application2 = new readAccount();
		application2.openFile();
		application2.readRecords();
		application2.closeFile();
	}
	
	public static class createAccount
	{
		private ObjectOutputStream output;	//outputs data to file
		
		//allow user to specify file name
		public void openFile() 
		{
			try	//open file
			{
				output = new ObjectOutputStream(new FileOutputStream("test2.acc"));
			}
			catch (IOException ioException)
			{
				System.err.println("Error opening file");
			}
		}
		
		//add records to file
		public void addRecords() 
		{
			AccountRecordSerializable record;	//object to be written to file
			int accountNumber = 0;	//account number for record object
			String firstName;	//first name for record object
			String lastName;	//last name for record object
			double balance;		//balance for record object
			
			Scanner input = new Scanner (System.in);
			System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator", 
					"when you are prompted to enter input.","On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
					"On Windows type <ctrl> z then press Enter");
			System.out.printf("%s\n%s", "Eneter account number (>0)", "first name, last name and balance.");
			
			while(input.hasNext())	//loop until end-of-file indicator
			{
				try //output values to file
				{
					
					accountNumber = input.nextInt();	//read account number
					firstName = input.next();			//read first name
					lastName = input.next();			//read last name
					balance = input.nextDouble();		//read balance
					
					if( accountNumber >0 )
					{
						//create new record
						record = new AccountRecordSerializable(accountNumber, firstName, lastName, balance);
						output.writeObject(record);	//output record
					}
					
					else
					{
						System.out.println("Account number must be greater than 0. ");
					}
				}
				catch (IOException ioException)
				{
					System.err.println("Error writing to file");
					return;
				}
				catch (NoSuchElementException elementException )
				{
					System.err.println("Invalid input. Please try again.");
					input.nextLine();	//discard input so user can try again
				}
				
				//System.out.printf("%s %s\n%s", "Enter account number(>0),","first name, last name and balance.","?");
			}
		}
		
		//close file and terminate application 
		public void closeFile()
		{
			try //close file
			{
				if( output != null)
					output.close();
			}
			catch( IOException ioException)
			{
				System.err.println("Error closing file.");
				System.exit(1);
			}
		}
	}
	
	public static class readAccount
	{
		private ObjectInputStream input;
		
		public void openFile()
		{
			try
			{
				input = new ObjectInputStream( new FileInputStream("test2.acc"));
			}
			catch(IOException ioException)
			{
				System.err.println("Error opening file.");
			}
		}
		
		public void readRecords()
		{
			AccountRecordSerializable record;
			System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance");
			
			File file = new File("IO_redirection2.txt");
			try {
				PrintStream printStream = new PrintStream(new FileOutputStream(file));
				System.setErr(printStream);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try
			{
				while(true)
				{
					record = (AccountRecordSerializable)input.readObject();
					System.err.printf("%-10d%-12s%-12s%10.2f\n",
							record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
					
					System.out.printf("%-10d%-12s%-12s%10.2f\n",
							record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
				
				}
			}
			
			catch ( EOFException endOfFileException )
			{
				return;
			}
			catch ( ClassNotFoundException classNotFoundException )
			{
				System.err.println("Unable to create object");
			}
			
			catch(IOException ioException)
			{
				System.err.println("Error during read from file.");
			}
			
			}

		public void closeFile()
		{
			try
			{
				if ( input != null )
					input.close();
			}
			catch(IOException ioException)
			{
				System.err.println("Error closing file.");
				System.exit(1);
			}
		}
	
		
		
	}
	
}