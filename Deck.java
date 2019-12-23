package com;
import java.util.*;
public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		
		ArrayList<String> types = new ArrayList<String>() ;
		ArrayList<String> values = new ArrayList<String>() ;
		ArrayList<Integer> scores = new ArrayList<Integer>() ;
		
		types.add("heart");
		types.add("diamond");
		types.add("spades");
		types.add("club");
		
		values.add("A");
		values.add("2");
		values.add("3");
		values.add("4");
		values.add("5");
		values.add("6");
		values.add("7");
		values.add("8");
		values.add("9");
		values.add("10");
		values.add("J");
		values.add("Q");
		values.add("K");
		
		scores.add(1);
		scores.add(2);
		scores.add(3);
		scores.add(4);
		scores.add(5);
		scores.add(6);
		scores.add(7);
		scores.add(8);
		scores.add(9);
		scores.add(10);
		scores.add(11);
		scores.add(12);
		scores.add(13);
		
		// creating deck of 52 cards
		ArrayList<Card> d = new ArrayList<Card>();
		for(int i=0; i<13; i++) {
			for(int j=0; j<4; j++) {
				Card c = new Card();
				c.setType(types.get(j));
				c.setValue(values.get(i));
				c.setScore(scores.get(i));
				d.add(c);
			}
		}
		
		this.deck = d;
		
	}
	
	public Card getCard(int index) {
		return this.deck.get(index);
		
	}
	
	public void removeCard(int index) {
		this.deck.remove(index);
	}

	
}
