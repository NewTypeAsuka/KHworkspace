package edu.kh.game.view;

import java.util.Objects;
import java.util.Scanner;
import edu.kh.game.dto.*;

public class GameView {
	
	public static String name;

	/* 노트
	 * - ●(내레이션)●
	 * - [(게임 설명)]
	 * - 대화는 처음에 두 칸 띄우고, 한 마디 뒤에는 enter();
	 * - 한 루틴 진행 후에는 clearScreen(); 
	 */
	
	// 화면 5행 개행
	public static void clearScreen() {
		for(int i=0; i<5; i++) System.out.println("");
		}
	
	// 대화 출력 엔터
	public static void enter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		sc.nextLine();
	}
	
	// 플레이어 이름 짓기
	public static void playerName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[플레이어 이름을 지어주세요.]");
		System.out.print("이름: ");
		name = sc.next();
	}
	
	// 시작메뉴 화면
	public static void displayMenu() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃====================================┃");
		System.out.println("┃      Cheong-gye Greits Escape      ┃");
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
				playerName(); /* 플레이어 이름 짓기 */
				clearScreen();
				System.out.printf("[%s님, 게임을 시작합니다.]\n", name); 
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
				System.out.println("┃            Game Start              ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				displayIntro(); /* 게임 인트로 */
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

	// 게임 인트로
	public static void displayIntro() {
		System.out.println("●평화로운 청계 그레이츠 빌딩 옥상정원●"); enter();
		System.out.println("  \"정말 기분 좋은 오후야~\""); enter();
		System.out.println("  \"그러게 정말 오늘 날씨도 맑고 정말 상쾌하다!\""); enter();
		System.out.println("  \"그런데 어디선가 이상한 소리가 들리지 않아?\""); enter();
		System.out.println("  \"응? 이상한 소리?\""); enter();
		System.out.println("  \"(비명소리) 끄아아악!\""); enter();
		System.out.println("  \"뭐지?\""); enter();
		System.out.println("  \"(안내방송) 비상, 비상. 빌딩 내부에 있으신 분은\n"
				+ "  모두 빌딩 밖으로 대피해주시기 바랍니다.\""); enter();
		System.out.println("  \"으악!?\""); enter();
		System.out.println("  \"???\""); enter();
		System.out.println("  \"좀.. 좀비다!\""); enter();
		System.out.println("  \"모두 뛰어!\""); enter();
		System.out.printf("●이윽고 %s은(는) 홀로 6층으로 대피에 성공한다.●\n", name); enter();
		System.out.printf("●하지만 %s은(는) 이 많은 좀비를 뚫고\n"
				+ "  1층까지 무사히 도달할 수 있을까?●", name); enter(); clearScreen();
		displayGame(); /* 게임 화면 */
	}

	// 게임 화면
	public static void displayGame() {
		System.out.println("(실제 게임이 진행되는 곳)");
	}
}
