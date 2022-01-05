package wordcounting8;

import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//8���� java �ǽ�����

public class WordCounting {
	public static void main(String[] args) {
		 Map <String,Integer> Counting = new HashMap<String,Integer>();
		 int counter = 0;
		 String tmp;
		 
		 //�Է¹ޱ� 
		 Scanner text = new Scanner(System.in);
		 String line = text.nextLine();
		 tmp = line.toLowerCase();
		 
		 //���� �ܾ�� �и� ��, �ؽ��ʿ� �־� ���� ī��Ʈ
		 for (String word : tmp.split("[.,��,:;()\\[\\]'\\\\\\/!\\?\\s\"]+"))
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
		
		//��� ��� (�������� ����)
		System.out.printf("\n�ܾ�			Ƚ��\n");
			
			// Map.Entry ����Ʈ �ۼ�
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(Counting.entrySet());
			// ���Լ� Comparator�� ����Ͽ� ���� �������� ����
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare�� ���� ��
		
		public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
			// ���� �������� ����
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
			//������
		for(Entry<String, Integer> entry : list_entries) {
			System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
		}
		 
		 
	} //main ����
		
         
} //class ��
    