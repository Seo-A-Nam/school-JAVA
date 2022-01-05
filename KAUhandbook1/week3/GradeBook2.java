import java.util.Scanner;

public class GradeBook2 {
	private int aCount; private int bCount; private int cCount; private int dCount; private int fCount;
	private int total;
	private int gradeCounter;
	
	public void inputGrades()
	{
		Scanner input = new Scanner( System.in );
		int grade;
		
		System.out.printf("%s\n%s\n		%s\n	%s\n", "Enter the integer grades in the range 0-100.",
				"Type the end-of-file indicator to terminate input:", "On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
				"On Windows type <Ctrl> z then press Enter");
		
		//loop until user enters the end-of-file indicator
		while(input.hasNext())	//입력의 끝을 표시. 다음 입력이 존재합니까? Ctrl + Z 입력하면 끝냄
		{
			grade = input.nextInt();
			total += grade;
			++gradeCounter;
			
			//call method to increment approximate counter
			incrementLetterGradeCounter( grade );	//grade를 분류
		}
	}
	
	//add 1 to appropriate counter for specified grade
	private void incrementLetterGradeCounter( int grade )
	{
		switch( grade / 10 )
		{
			case 9:	//grade was between 90
			case 10: // and 100, inclusive
				++aCount; //increment aCount
				break;
			case 8: //grade was between 80 and 89
				++bCount;
				break;
			case 7: //grade was between 70 and 79
				++cCount;
				break;
			case 6: //grade was between 60 and 69
				++dCount;
				break;
				
			default: //grade was less than 60
				++fCount;
				break;		
		}
	}
	
	//display a report based on the grades entered by user
	public void displayGradeReport()
	{
		System.out.println("\nGrade Report:");
		
		//if user entered at least one grade
		if (gradeCounter != 0)
		{
			double average  = (double) total / gradeCounter;
			
			System.out.printf("Total of the %d grades entered is %.2f\n",average);
			System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n","Number of students who received each grade:",
					"A: ",aCount,"B: ",bCount,"C: ",cCount,"D: ",dCount,"F: ",fCount);
		}
		else
			System.out.println("No grades were entered");
	}
}
