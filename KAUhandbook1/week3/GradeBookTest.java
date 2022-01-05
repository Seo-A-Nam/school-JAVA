//과목점수 계속 입력하고 마지막에 각 과목 점수의 평균을 출력하는 class
public class GradeBookTest {
	public static void main(String[] args)
	{
		GradeBook myGradeBook = new GradeBook("CS101 Introduction to Java Programming");
		myGradeBook.displayMessage();
		myGradeBook.determineClassAverage();	
	}
}
