package edu.kh.game.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import edu.kh.game.dto.Equipment;
import edu.kh.game.dto.Player;
import edu.kh.game.dto.Zombie;
import edu.kh.game.view.GameView;

public class Service {

	Equipment equipment = new Equipment("신발", 0, 0);
	Zombie zom = new Zombie("qkr", 2, 1);
	private Player p1 = new Player("당신", 3, 0, 1, 3, 7, true);
	private String[] p1Item = new String[5];
	// name, hp, defense, power, stamina, floor, item[5], key
	private boolean runCheck = false;

	public String getName() {
		return p1.getName();
	}

	public void setName(String name) {
		p1.setName(name);
	}

	public boolean runCheck() {
		if (runCheck = true) {
			return true;
		}
		return false;
	}

	public boolean viewKey() {
		return p1.getKey();
	}

	public void tang() {
		getPlayerHp(1);
		getStamina(1);
	}

	public int viewHp() {// 현재 HP
		int hp = p1.getHp();
		return hp;
	}

	public int viewStamina() {// 현재 스테미나
		int stamina = p1.getStamina();
		return stamina;
	}

	public int viewFloor() { // 현재 층
		int floor = p1.getFloor();
		return floor;
	}

	public void moveFloor(boolean move) { // 층 이동 아래로
		p1.setFloor(p1.getFloor() - 1);
	}

	public int getPlayerHp(int getPlayerHp) { // 플레이어 힐
		int nowHp = p1.getHp() + getPlayerHp;
		if (nowHp > 3) {
			p1.setHp(3);
		} else {
			p1.setHp(nowHp);
		}
		return p1.getHp();
	}

	public int hitPlayer(int damage) { // 플레이어 맞음
		int nowHp = p1.getHp() - damage;
		p1.setHp(nowHp);
		return p1.getHp();
	}

	public int getStamina(int getStamina) { // 스테미나 획득
		int nowStamina = p1.getStamina() + getStamina;
		if (nowStamina >= 4) {
		} else {
			p1.setStamina(nowStamina);
		}
		return p1.getStamina();
	}

	public int useStamina(int useStamina) { // 스테미나 사용
		int nowStamina = p1.getStamina() - useStamina;
		p1.setStamina(nowStamina);
		return p1.getStamina();
	}

	public int getPlayerDefense(int getPlayerDefense) { // 플레이어 방어 획득
		int nowDefense = p1.getDefense() + getPlayerDefense;
		p1.setDefense(nowDefense);
		return p1.getDefense();
	}

	public int usePlayerDefense(int usePlayerDefense) { // 플레이어 방어 사용(필요?)
		int nowDefense = p1.getDefense() + usePlayerDefense;
		p1.setDefense(nowDefense);
		return p1.getDefense();
	}

	// 아이템 랜덤값 들어오면 해당 아이템을 null배열 or "" 에 넣어주기

	Random random = new Random();

	public int whatItem() {
		int whatItem = random.nextInt(100) + 1;
		int getItemRandom = random.nextInt(100) + 1;

		if (getItemRandom >= 1 && getItemRandom <= 40) {// 40퍼 확률 아이템 얻기

			if (whatItem >= 1 && whatItem <= 15) {// 의료상자
				return 1;
			} else if (whatItem >= 16 && whatItem <= 35) {// 붕대
				return 2;
			} else if (whatItem >= 36 && whatItem <= 55) {// 커피
				return 3;
			} else if (whatItem >= 56 && whatItem <= 77) {// 빵
				return 4;
			} else {// 컵라면
				return 5;
			}
		} else {
			return 0;
		}

	}

	// 아이템 랜덤값 들어오면 해당 아이템을 null배열 or "" 에 넣어주기
	public void addItem(int itemNum) {
		int count = 0;

		String item = "";
		if (itemNum == 1)
			item = "의료상자";
		if (itemNum == 2)
			item = "붕대";
		if (itemNum == 3)
			item = "빵";
		if (itemNum == 4)
			item = "컵라면";
		if (itemNum == 5)
			item = "커피";

		for (int i = 0; i < p1Item.length; i++) {
			if (p1Item[i] != null) {
				count++;
			}
		}
		if (count == 5) {
			System.out.println("[아이템 획득에 실패했습니다.]");
			System.out.println("[가방에 빈칸이 없습니다.]");
		}else
		if (itemNum >= 1 && itemNum <= 5) {
			for (int i = 0; i < p1Item.length; i++) {
				if (p1Item[i] == null) {
					p1Item[i] = item;
					break;
				}
			}
		}
		if (itemNum != 0) {
			System.out.println("\n\n\n\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.printf("        %s 을/를 얻었습니다.\n", item);
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		} else {
			System.out.println("[아이템을 찾지 못했습니다.]");
		}

	}

	public void itemView() {
		System.out.println("[현재 소지 중인 아이템 목록]");
		for (int i = 0; i < p1Item.length; i++) {
			if (p1Item[i] != (null)) {
				System.out.println(i + 1 + ". " + "\"" + p1Item[i] + "\"");
			} else {
				System.out.println(i + 1 + ". " + "-----");
			}
		}
	}

	public void useItem(int itemNum) {// 해당인덱스 1~5까지 고르면 사용
		itemNum -= 1;
		if (p1Item[itemNum] == null) {
			System.out.println("[해당 위치에는 아이템이 없습니다.]\n" + "[다시 선택해주시길 바랍니다.]");

		} else if (p1Item[itemNum].equals("의료상자")) {
			int nowHp = p1.getHp() + 1;
			p1.setHp(nowHp);
			int nowStamina = p1.getStamina() + 1;
			p1.setStamina(nowStamina);
			System.out.println("체력 +1\n스테미나 +1");
			p1Item[itemNum] = null;
		} else if (p1Item[itemNum].equals("붕대")) {
			int nowHp = p1.getHp() + 1;
			p1.setHp(nowHp);
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		} else if (p1Item[itemNum].equals("빵")) {
			int nowHp = p1.getHp() + 1;
			p1.setHp(nowHp);
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		} else if (p1Item[itemNum].equals("컵라면")) {
			int nowHp = p1.getHp() + 1;
			p1.setHp(nowHp);
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		} else if (p1Item[itemNum].equals("커피")) {
			int nowStamina = p1.getStamina() + 1;
			p1.setStamina(nowStamina);
			System.out.println("스테미나 +1");
			p1Item[itemNum] = null;
		}

	}

	public boolean isKey() {
		if (p1.getKey() == true) {
			p1.setKey(false);
			return true;
		}

		return false;
	}

	public void getKey() {
		p1.setKey(true);

	}

	// 플레이어 행동 관련
	public void died() {

		if (p1.getHp() == 0) {
			System.out.println("당신은 죽었습니다.");
		}
	}

	public int random() {
		int random = (int) (Math.random() * 100) + 1;

		return random;
	}

	public boolean attack() {

		if (random() + (equipment.getEvasion()) > 50) {
			zom.setHp(0);
			System.out.println("재빠르게 회피하고 좀비를 처리했습니다.");
			if (equipment != null) {
				equipment.setEvasion(equipment.getEvasion() - 1);
				broken(equipment);
				return true;
			}

		} else {
			System.out.println("공격을 당했지만 좀비를 처리했습니다.");
			p1.setHp(p1.getHp() - zom.getPower());

		}
		return false;
	}

	public boolean run() {
		if (p1.getStamina() == 3) {
			System.out.println("도망에 성공하였습니다.");
			p1.setStamina(p1.getStamina() - 1);
			return true;
		} else if (p1.getStamina() == 2) {
			p1.setStamina(p1.getStamina() - 1);
			if (random() > 25) {
				System.out.println("도망에 성공하였습니다.");
				return true;
			} else {
				System.out.println("도망에 실패하였습니다.");
				p1.setHp(p1.getHp() - 1);
				return false;
			}

		} else if (p1.getStamina() == 1) {
			p1.setStamina(p1.getStamina() - 1);
			if (random() > 50) {
				System.out.println("도망에 성공하였습니다.");
				return true;
			} else {
				System.out.println("도망에 실패하였습니다.");
				p1.setHp(p1.getHp() - 1);
				return false;
			}
		} else {
			System.out.println("스태미너가 부족하여 도망칠 수 없습니다.");
			p1.setHp(p1.getHp() - 1);

			return false;
		}

	}

	public void broken(Equipment i) {
		i.setStatus(i.getStatus() - 1);
		if (i.getStatus() == 0) {
			System.out.printf("방어구가 깨졌습니다.");
			equipment = null;
		}
	}

	public void eat(int i) {

	}

	public void save() {

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object/save.dat"));
			Player i = p1;
			Equipment e = equipment;
			Map<String, Object> saveFile = new LinkedHashMap<>();

			saveFile.put("p1", i);
			saveFile.put("e", e);

			oos.writeObject(saveFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void start() {
		System.out.println(p1.getHp());
		System.out.println(equipment.getStatus());
		p1.setHp(20);
		equipment.setStatus(99);
		equipment.setName("방어구");
		System.out.println(p1.getHp());
		System.out.println(equipment.getStatus());
	}

	public void status() {
		System.out.println(p1.getHp());
		System.out.println(equipment.getStatus());
		System.out.println(equipment.getName());
	}

	public void load() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("object/save.dat"));
			Map<String, Object> saveFile = new LinkedHashMap<>();
			saveFile = (Map<String, Object>) ois.readObject();
			p1 = (Player) saveFile.get("p1");
			equipment = (Equipment) saveFile.get("e");
			System.out.println(p1.getHp());
			System.out.println(equipment.getStatus());
			System.out.println(equipment.getName());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
