package com;

import java.util.*;

public class Game {

	// check win
	public boolean checkWin(int num) {
		if (num == 2) {
			return true;
		}
		return false;
	}

	public static void displayPlayerCards(Player p) {
		System.out.println("");
		System.out.println("Player " + p.getName() + " cards");
		System.out.println("");
		for (int i = 0; i < p.getCards().size(); i++) {
			System.out.println(p.getCards().get(i).getType() + " " + p.getCards().get(i).getValue());
		}
		System.out.println("");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("-----------Patlu Game-----------");
		System.out.println("");
		System.out.println("");

		System.out.println("Enter number of Players");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		ArrayList<Player> players = new ArrayList<Player>();

		// add details of player
		for (int n = 0; n < num; n++) {
			System.out.println("");
			System.out.println("Enter player " + n + " name");
			String Pname = sc.next();
			Player p = new Player();
			p.setName(Pname);
			p.setFlag(0);
			players.add(p);
		}

		// initiate deck
		Deck d = new Deck();

		System.out.println(d.deck.size());

		int totalDeckCards = d.deck.size();
		// give 2 random cards for each player
		for (int i = 0; i < players.size(); i++) {

			int x = (int) (Math.random() * (totalDeckCards + 1));
			totalDeckCards = totalDeckCards - 1;
			Card randcard1 = d.deck.get(x);
			// remove card from deck
			d.deck.remove(x);
			// add card to player
			players.get(i).addCard(randcard1);

			int y = (int) (Math.random() * (totalDeckCards + 1));
			totalDeckCards = totalDeckCards - 1;
			Card randcard2 = d.deck.get(y);
			// remove card from deck
			d.deck.remove(y);
			// add card to player
			players.get(i).addCard(randcard2);

		}

		for (int j = 0; j < players.size(); j++) {
			displayPlayerCards(players.get(j));
		}

		int gameStatus = 0;
		int completed = 0;
		// ----------------

		// check if score 21 got in first attempt
		for (int k = 0; k < players.size(); k++) {
			if (players.get(k).getTotal() == 21) {
				System.out.println(players.get(k).getName() + " Wins at score 21");
				gameStatus = 1;
			}
		}

		
		
		// game continues
		if (gameStatus == 0) {

			for (int k = 0; k < players.size(); k++) {

				// add cards if score is <18
				while (players.get(k).getTotal() < 18) {
					int z = (int) (Math.random() * (totalDeckCards + 1));
					totalDeckCards = totalDeckCards - 1;
					Card randcard3 = d.deck.get(z);
					d.deck.remove(z);
					players.get(k).addCard(randcard3);
					System.out.println("----------------");
					displayPlayerCards(players.get(k));
					System.out.println("----------------");
				}

				// decision to add card if score > 18 and <21
				while (players.get(k).getTotal() > 17 && players.get(k).getTotal() < 21) {
					System.out.println(players.get(k).getName() + " score is " + players.get(k).getTotal());
					System.out.println("Do you need one more card ?");
					System.out.println("Press Y - yes");
					System.out.println("Press N - NO");
					String decision = sc.next();
					if (decision == "Y") {
						int a = (int) (Math.random() * (totalDeckCards + 1));
						totalDeckCards = totalDeckCards - 1;
						Card randcard4 = d.deck.get(a);
						d.deck.remove(a);
						players.get(k).addCard(randcard4);
						System.out.println("----------------");
						displayPlayerCards(players.get(k));
						System.out.println("----------------");
					} else {
						break;
					}
				}

				
				if (players.get(k).getTotal() == 21) {
					completed = 1;
					System.out.println(players.get(k).getName() + " Wins with score 21");
					System.out.println("----------------");
					displayPlayerCards(players.get(k));
					System.out.println("----------------");
					
				}

				else if (players.get(k).getTotal() > 22) {
					System.out.println(players.get(k).getName() + " lost");
				}

				else if (players.get(k).getTotal() < 21) {
					System.out.println(players.get(k).getName() + " score is " + players.get(k).getTotal());
				}

			}

			while(true) {
			Player p = Collections.max(players, Comparator.comparing(obj -> obj.getTotal()));
			
			if (p.getTotal() > 17 && p.getTotal() < 22) {
				System.out.println(p.getName() + " Wins with score " + p.getTotal());
				System.out.println("----------------");
				displayPlayerCards(p);
				System.out.println("----------------");
				break;
			}
			
			else if(p.getTotal()>21) {
				players.remove(p);
			}

			}

		}

	}

}
