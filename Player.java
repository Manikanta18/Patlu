package com;

import java.util.*;

public class Player {

	private String name;
	private int total;
	private ArrayList<Card> cards = new ArrayList<Card>() ;
	private int flag = 0;
	//0 - not win
	//1 - patlu
	//2 - win

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		int t=0;
		if(cards.size() !=0 ) {
			for(int i=0; i<cards.size();i++) {
				t = t + cards.get(i).getScore();
			}
		}
		total = t;
		return total;
	}


	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card c) {
		this.cards.add(c);
	}
	

}
