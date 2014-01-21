package com.java.se.doudizhu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 模拟斗地主发牌情景
 * */
public class Test {

	public static void main(String[] args) {
		List<PuKe> puKes = createPuKe();
		Collections.shuffle(puKes);
		//三张地主牌
		List<PuKe> lastThree = puKes.subList(0, 2); 
		List<Player> players = new ArrayList<Player>();
		Player player1 = new Player("playerA");
		Player player2 = new Player("playerB");
		Player player3 = new Player("playerC");
		for (int i = 0; i < puKes.size(); i++) {
			if(i % 3 == 0) {
				player1.getPuKe().add(puKes.get(i));
				continue;
			}
			if(i % 3 == 1) {
				player2.getPuKe().add(puKes.get(i));
				continue;
			}
			if(i % 3 == 2) {
				player3.getPuKe().add(puKes.get(i));
				continue;
			}
		}
		players.add(player3);
		//player2是地主
		player2.getPuKe().addAll(lastThree);
		players.add(player2);
		players.add(player1);
		System.out.println("player : " + player1.getName());
		Iterator<PuKe> i1 = player1.getPuKe().iterator();
		while(i1.hasNext()) {
			System.out.print(i1.next().getName() + ";");
		}
		System.out.println();
		System.out.println("player : " + player2.getName());
		Iterator<PuKe> i2 = player2.getPuKe().iterator();
		while(i2.hasNext()) {
			System.out.print(i2.next().getName() + ";");
		}
		System.out.println();
		System.out.println("player : " + player3.getName());
		Iterator<PuKe> i3 = player3.getPuKe().iterator();
		while(i3.hasNext()) {
			System.out.print(i3.next().getName() + ";");
		}
	}
	
	public static List<PuKe> createPuKe() {
		List<PuKe> puKe = new ArrayList<PuKe>();
		String[] huaSe = {"黑桃", "红桃", "方块", "梅花"};
		for(int i=0; i<4; i++) {
			for(int j=1; j<=13; j++) {
				String num = "";
				PuKe p = new PuKe();
				if(j == 1) {
					num = "A";
				}
				else if(j == 11) {
					num = "J";
				}
				else if(j == 12) {
					num = "Q";
				}
				else if(j == 13) {
					num = "K";
				} else {
					num = "" + j;
				}
				p.setName(huaSe[i]+num);
				puKe.add(p);
			}
		}
		puKe.add(new PuKe("大王"));
		puKe.add(new PuKe("小王"));
		return puKe;
	}
}
