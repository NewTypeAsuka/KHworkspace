package edu.kh.game.view;

import java.util.Objects;
import java.util.Scanner;

public class GameView {
	// 화면 5행 개행
	public static void clearScreen() {
		for (int i = 0; i < 5; i++)
			System.out.println("");
		}
	
	// 시작메뉴 화면
	public void displayMenu() {
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃====================================┃");
		System.out.println("┃     Survive in Zombie Building     ┃");
		System.out.println("┃====================================┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃  /     /       / /   /     /   /   ┃");
		System.out.println("┃1. 게임 시작	Game Start   /      /┃");
		System.out.println("┃2. 게임 종료	Exit  /     /  /  /  ┃");
		System.out.println("┃    / /      /        /      /   /  ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                     dev_20230302   ┃");
		System.out.println("┃                     JYH/PJW/JBS    ┃");
		System.out.println("┃                     JSY/CGT/LSJ    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println();
		System.out.println("[게임을 시작하려면 1을 입력해주세요.]");
		System.out.println("[게임을 종료하려면 2를 입력해주세요.]");
		
		boolean startCheck = true;
		Scanner sc = new Scanner(System.in);
		
		while(startCheck) {
			System.out.print("입력: ");
			String startInput = sc.nextLine();
			if(startInput.equals("1")) {
				clearScreen();
				System.out.println("[게임을 시작합니다.]"); 
				for(int i=5; i>=1; i--) {
					try {
						System.out.print(i + "  ");
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				clearScreen();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃            Game Start              ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				displayGame(); /* 게임이 시작되는 곳 */
				break;
			}else if(startInput.equals("2")) {
				clearScreen();
				System.out.println("[게임이 종료됩니다.]");
				for(int i=3; i>=1; i--) {
					try {
						System.out.print(i + "     ");
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				clearScreen();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃               Exit                 ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				
					// 이스터에그
					String easteregg = sc.next();
					if(easteregg.toUpperCase().equals("EASTEREGG")) {
						System.out.println("?: ...");
						try {
							Thread.sleep(2500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("이 게임은 정용화, 박종욱, 장반석,");
						System.out.println("        정송이, 최근태, 이상준이 만들었습니다.");
					}
				break;
			}else if(!(startInput.equals("1") || startInput.equals("2"))) {
				System.out.println("[1 또는 2를 입력해주세요.]");
				startCheck = true;
			}
		}
	}

	// 게임 화면
	public void displayGame() {
		System.out.println("실제 게임이 진행되는 곳");
	}
}
