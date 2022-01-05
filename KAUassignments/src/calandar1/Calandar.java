package calandar1;
import java.util.Scanner;
 
public class Calandar {
	//9월 달력 출력
 
    public static void main(String[] args) {
        System.out.println("\t\t    2020년 9월\n");
        System.out.println("sun\t mon\t tue\t wen\t thu\t fri\t sat\t \n");
        System.out.println("\t \t 1\t 2\t 3\t 4\t 5\t \n");
        for(int i=6; i<31; i++) {
        	System.out.printf("%d\t ",i);
        	if((i-5)%7==0)  {
        		System.out.printf("\n\n");
        	}
        }
        System.out.println("\n");
        }
 
}