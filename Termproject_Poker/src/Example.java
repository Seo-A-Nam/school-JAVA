import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player[] players;

		// System.out.println(dealer.deck);
		System.out.print("Player�� ���� �Է��ϼ���>");
		int numOfPlayer = new Scanner(System.in).nextInt();
		players = new Player[numOfPlayer];

		// �� �÷��̾�� �⺻ ���ñ� 10000������ ��������.
		for (int i = 0; i < numOfPlayer; i++) {
			players[i] = new Player();
			players[i].money = 10000;
		}
		int index = 0;

		// ���� ���� ���ο� ���� ���α׷��� �ݺ� ���� ����. ���� ������ �����ϰ��� �� ��� ������ ������.

		while (true) {

			System.out.println("��� �Ͻ÷��� 1 , �����Ͻ÷��� 2");
			index = new Scanner(System.in).nextInt();
			if (index == 1) {
				Dealer dealer = new Dealer();

				for (int i = 0; i < numOfPlayer; i++) {
					dealer.deal(players[i]);
					// �÷��̾�ī�� ����
					Arrays.sort(players[i].cards);
					System.out.println("�÷��̾� " + (i + 1) + " " + Arrays.toString(players[i].cards));
					// ������ �����ϸ� �� �÷��̾��� ���õ� �� 10000������ �� ���ñ� 1000���� ������
					players[i].money -= 1000;
				}

				dealer.checkRank(players);

				// ranking �迭�� �����Ͽ� ������ �÷��̾��� ������ �־��� (�ؽø� ���� ��ũ�� ���� ������ ���� �� ���� ���� �Ǵ� ������ ���� ����
				// �߰��Ǵ� ������ ���ļ� ��)
				int ranking[] = new int[numOfPlayer];
				for (int i = 0; i < numOfPlayer; i++) {
					ranking[i] = players[i].rank;
				}
				Arrays.sort(ranking);
				System.out.println(Arrays.toString(ranking));
				int winnerrank = ranking[numOfPlayer-1];
				for (int i = 0; i < numOfPlayer; i++) {
					if (players[i].rank == winnerrank) {
						System.out.println(i + 1 + "��° �÷��̾ �¸��߽��ϴ�");
						players[i].money += (1000 * (numOfPlayer));
					}

				}
				// ���� ������ �����Ͽ��� ��� ���� ���� ���� �����ϰ� �ִ� �÷��̾ �¸��ϵ�����.
			} else if (index == 2) {
				int maxmoney = players[0].money;

				for (int i = 1; i < numOfPlayer; i++) {
					if (maxmoney < players[i].money) {
						maxmoney = players[i].money;
						System.out.println((i + 1) + "�÷��̾ ���� �� " + maxmoney + "�� ���� ���� �����ϴ�. �¸��ϼ̽��ϴ�.");

					}
				}
				break;
			}
		}
		// ������ �����ǰ� �� �÷��̾��� �ܾ��� Ȯ���� �� ���� �ܾ�Ȯ�� �� ���α׷��� ������.
		System.out.print("������ �÷��̾��� �ܾ��� Ȯ���Ͻ÷��� 3��");
		int confirm = new Scanner(System.in).nextInt();
		if (confirm == 3) {

			for (int i = 0; i < numOfPlayer; i++) {
				System.out.println((i + 1) + "�÷��̾��� ���� " + players[i].money + " �� �Դϴ�.");
			}
		}

		// sort ���� �� ���(�Ʒ� ����Բ��� Player Ŭ������ Comparable�� implements �ؼ� �Ʒ��� ��츦 ������� ����)
		// int max = 0;
		// for(int i = 1 ; i < numOfPlayer ; i++) {
		// max = players[0].rank;
		// if(max < players[i].rank) {
		// max = players[i].rank;
		// }
		// }
		// int winner = 0;
		//
		// for(int i = 0 ; i <numOfPlayer ; i++) {
		// if(max == players[i].rank)
		// System.out.println("���ڴ� "+(i+1)+"�Դϴ�.");
		// }

	}
}

class Dealer {
	ArrayList deck = new ArrayList(Card.NUM_MAX * Card.KIND_MAX); // Card[] deck = new Card[52];
	HashMap rankTable = new HashMap();

	Dealer() {
		// 1. deck�� Card�� �����ؼ� �ִ´�.
		// ���� �����Ѵ�.

		int i = 0;

		for (int k = Card.KIND_MAX; k > 0; k--) {
			for (int n = 0; n < Card.NUM_MAX; n++) {
				deck.add(new Card(k, n + 1));
			}
		}
		// ������
		Collections.shuffle(deck);

		// 2. rankTable�� rank������ �ִ´�.
		// "straight flush" �� 9000
		// "flush"�� 8000
		// "straight"�� 7000
		// "full house"�� 6000
		// "four card"�� 5000
		// "three card"�� 4000
		// "2 pair"�� 3000
		// "1 pair"�� 2000
		// "no rank"�� 1000

		String ranking[] = { "Straight flush", "flush", "Straight", "full house", "four card", "three card", "2 pair",
				"1 pair", "no rank" };
		for (i = 0; i < ranking.length; i++) {
			rankTable.put(ranking[i], 9000 - 1000 * i);
		}
		System.out.println("��ũ ���̺� : " + rankTable);
		System.out.println();
	}

	// ī�� �����ֱ�
	void deal(Player p) {
		for (int i = 0; i < 5; i++) {
			p.cards[i] = (Card) deck.get(i);
			deck.remove(i);
		}

	}

	void checkRank(Player[] players) {
		// �� player�� rank�� üũ�ؼ� player�� rank�� ����

		for (int ii = 0; ii < players.length; ii++) {
			int[] cntArr = new int[14];

			boolean threeCard = false;
			boolean fourCard = false;
			int pair = 0;
			boolean straight = false;
			boolean flush = false;
			boolean straightFlush = false;
			boolean fullhouse = false;
			int pairnum = 0;
			int kindCnt = 0;

			int stCnt = 0;
			for (int i = 0; i < 5; i++) {
				cntArr[players[ii].cards[i].num]++;
			}

			for (int i = 0; i < 4; i++) {
				if (cntArr[i] > 0) {
					// stCnt++;
					for (int j = i; j < cntArr.length - 1; j++) {
						if (cntArr[j + 1] > 0) {
							stCnt++;
							pairnum = i;
							if (stCnt == 5)
								straight = true;
						} else {
							stCnt = 0;
						}
					}

				}
				if (players[ii].cards[0].kind == players[ii].cards[i + 1].kind) {
					kindCnt++;
					if (kindCnt == 4) {
						flush = true;
					}
				} else if (stCnt == 5 && flush == true) {
					straightFlush = true;
				}
			}
			for (int i = 0; i < cntArr.length; i++) {
				if (cntArr[i] == 4) {
					fourCard = true;
					pairnum = i;
				break;}
				else if (cntArr[i] == 3) {
					for (int j = 0; j < cntArr.length; j++) {
						if (cntArr[j] == 2) {
							fullhouse = true;
						break;}
					threeCard = true;
					pairnum = i;

					break;}
				} else if (cntArr[i] == 2) {
					pair++;

					if (pair == 1||pair == 2) {
						pairnum = i;
						break;
					}
				} else if (pair == 0 && cntArr[i] == 1) {
					pairnum = i;

				}



			}

			// System.out.println(Arrays.toString(cntArr));

			if (fourCard)
				players[ii].rank = (int) rankTable.get("four Card") + pairnum;
			else if (threeCard)
				players[ii].rank = (int) rankTable.get("three card") + pairnum;
			else if (straight)
				players[ii].rank = (int) rankTable.get("Straight") + pairnum;
			else if (pair == 1)
				players[ii].rank = (int) rankTable.get("1 pair") + pairnum;
			else if (pair == 2)
				players[ii].rank = (int) rankTable.get("2 pair") + pairnum;
			else if (fullhouse)
				players[ii].rank = (int) rankTable.get("full house") + pairnum;
			else if (flush)
				players[ii].rank = (int) rankTable.get("flush") + players[ii].cards[4].kind + players[ii].cards[4].num;
			else if (straightFlush)
				players[ii].rank = (int) rankTable.get("Straight flush") + pairnum;
			else
				players[ii].rank = (int) rankTable.get("no rank") + pairnum + players[ii].cards[4].kind;

			// ���� ��ũ�� ��� ���� ū ���� ī�� ��

			System.out.println("�÷��̾� " + (ii + 1) + "�� ������ : " + players[ii].rank);

		}
		// }

	}
}

class Player implements Comparable {
	Card[] cards = new Card[5];
	int rank, money = 0;

	@Override
	public int compareTo(Object o) {
		// if(o instanceof Player) {
		Player p = (Player) o;
		return this.rank - p.rank;
		// }else
		// TODO Auto-generated method stub
		// return 0;
	}
}

class Card implements Comparable {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;

	int kind;
	int num;

	Card(int kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	public String toString() {
		String[] kinds = { "", "COLVER", "HEART", "DIAMOND", "SPADE" };
		String numbers = "0123456789XJQK";
		return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.num);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Card) {
			Card c1 = (Card) o;
			return this.num - c1.num;
		}
		return 1;
	}
}