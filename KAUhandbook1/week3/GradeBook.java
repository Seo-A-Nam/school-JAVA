//Gradebook class that solves class-average program using
import java.util.Scanner;

public class GradeBook {
	private String courseName;
	
	public GradeBook( String name )
	{
		courseName = name; //initialize the course name
	}
	
	public void setCourseName(String name)
	{
		courseName = name; //store the course name
	}
	
	public String getCourseName() 
	{
		return courseName;
	}
	
	public void displayMessage()
	{
		System.out.printf("Welcome to grade book for\n%s!\n\n",getCourseName());
	}
	
	//determine the average of an arbitrary number of grades
	public void determineClassAverage()
	{
		Scanner input = new Scanner(System.in);
		int total;
		int gradeCounter;
		int grade;
		double average; 
		
		//initializing phase
		total = 0;
		gradeCounter = 0;
		
		//processing phase
		//prompt for input and read grade from user
		System.out.print("Enter grade for -1 to quit: ");
		grade = input.nextInt();
		
		//loop until sentinel value read from user
		while (grade != -1)
		{
			total = total + grade;
			gradeCounter = gradeCounter + 1;
			
			//prompt for input and read next grade from user
			System.out.print("Enter grade or -1 to quit: ");
			grade = input.nextInt();
		}
		
		//termination phase
		//if user entered at least one grade...
		
		if( gradeCounter != 0 )
		{
			//calculate average of all grades entered
			average = (double) total / gradeCounter;
			
			//display total and average (with two digits of precision)
			System.out.printf("\nTotal of the %d grades entered is %d\n", gradeCounter, total );
			System.out.printf("Class average is %.2f\n", average );
			
		}
		else
			System.out.println("No grades were entered");
	}
	
}
