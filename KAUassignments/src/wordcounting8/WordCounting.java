package wordcounting8;

import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//8주차 java 실습과제

public class WordCounting {
	public static void main(String[] args) {
		 Map <String,Integer> Counting = new HashMap<String,Integer>();
		 int counter = 0;
		 String tmp;
		 
		 //입력받기 
		 Scanner text = new Scanner(System.in);
		 String line = text.nextLine();
		 tmp = line.toLowerCase();
		 
		 //각각 단어로 분리 후, 해쉬맵에 넣어 개수 카운트
		 for (String word : tmp.split("[.,·,:;()\\[\\]'\\\\\\/!\\?\\s\"]+"))
			{
	           	   if(Counting.containsKey(word)) {
	           		   counter = Counting.get(word);
	           		   counter++;
	           		   Counting.replace(word,counter);
	           	   }
	           	   else {
	           		   Counting.put(word, 1);
	           	   }
	          }
		
		//결과 출력 (내림차순 적용)
		System.out.printf("\n단어			횟수\n");
			
			// Map.Entry 리스트 작성
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(Counting.entrySet());
			// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
		
		public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
			// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
			//결과출력
		for(Entry<String, Integer> entry : list_entries) {
			System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
		}
		 
		 
	} //main 종료
		
         
} //class 끝
    