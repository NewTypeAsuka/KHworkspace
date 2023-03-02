package edu.kh.game.dto;

import java.util.ArrayList;
import java.util.List;

public class Building {

	List<List<String>> list = new ArrayList<>(7);
	
	public Building() {
		for(int i=0; i<7; i++) {
			list.add(new ArrayList<>());
		}
		
		// 1층: 로비
		list.get(0).add("로비");
		
		// 2~3층: 회의실, 강의실1, 강의실2, 화장실, 탕비실
		for(int i=1; i<=2; i++) {
			list.get(i).add("회의실");
			list.get(i).add("강의실");
			list.get(i).add("화장실");
			list.get(i).add("탕비실");
		}
		
		// 4층: 신한라이프 회장실, 회의실1, 회의실2, 탕비실
		list.get(3).add("신한라이프 회장실");
		list.get(3).add("대회의실");
		list.get(3).add("강당");
		list.get(3).add("탕비실");
		
		// 5~6층: 회의실1, 회의실2, 강당, 화장실, 탕비실
		for(int i=4; i<=5; i++) {
			list.get(i).add("회의실1");
			list.get(i).add("회의실2");
			list.get(i).add("강당");
			list.get(i).add("화장실");
			list.get(i).add("탕비실");
		}
		
		// 7층: 옥상정원
		list.get(6).add("옥상정원");
	}
}