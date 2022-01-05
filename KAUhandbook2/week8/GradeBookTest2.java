//creates a GradeBook object using an array of grades, then invokes method processGrades to analyze them
public class GradeBookTest2 
{
	public static void main(String[] args)
	{
		//array of student grades
		int[] gradesArray = {87, 68, 94, 100 ,83, 78, 85, 91, 76, 87};
		GradeBook3 myGradeBook = new GradeBook3("CS101 Introduction to Java Programming", gradesArray);
		myGradeBook.displayMessage();
		myGradeBook.processGrades();
	}
}
