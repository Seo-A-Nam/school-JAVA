
public class DeckOfCardsTest 
{
	public static void main(String[] args)
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); //place Cards in random order
		
		//print all 52 Cards in the order in which they are dealt
		for(int i =1; i<= 52; i++) 
		{
			//deal and display a Card
			System.out.printf("%-19s",myDeckOfCards.dealCard());
			if( i%4 ==0 )	//outuput newline every 4 cards
				System.out.println();
		}
	}
}
