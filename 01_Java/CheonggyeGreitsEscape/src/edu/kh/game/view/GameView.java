package edu.kh.game.view;

import java.util.Objects;
import java.util.Scanner;
import edu.kh.game.dto.*;
import edu.kh.game.service.Service;

public class GameView {
	
	static Scanner sc = new Scanner(System.in);
	public static String name;
	public static Service gameService = new Service();
	public static Building floor = new Building();

	/* 인트로, 아웃트로 NOTATION
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
	public static void playerNameSet() {
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
		System.out.println("┃                     dev_20230313   ┃");
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
				playerNameSet(); /* 플레이어 이름 짓기 */
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
					if(easteregg.toUpperCase().equals("HI")) {
						System.out.println("?: ...");
						try {
							Thread.sleep(2500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("백동현 강사님 바~보");
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
		System.out.printf("●이윽고 %s은(는) 옥상정원 구석으로\n"
				+ "  대피에 성공한다.●\n", name); enter();
		System.out.printf("●하지만 %s은(는) 이 많은 좀비를 뚫고\n"
				+ "  1층까지 무사히 도달할 수 있을까?●", name); enter(); clearScreen();
		displayGame(); /* 게임 화면 */
	}

	// 게임 화면
	public static void displayGame() {
		int input = 0;

		while(viewFloor()>0) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.printf ("	" + floor.getRoom(viewFloor()-1));
			System.out.println("                                      ");
			System.out.printf ("	0. 아래 층(%dF)\n", viewFloor()-1);
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("                                      ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch(input) {
			case 0:
				if(checkKey() == false) {
					break;
				}
				gameService.moveFloor(true);
				break;
			case 1:
				checkingRoom(0);
				break;
			case 2:
				checkingRoom(1);
				break;
			case 3:
				checkingRoom(2);
				break;
			case 4:
				checkingRoom(3);
				break;
			case 5:
				checkingRoom(4);
				break;
			case 6:
				break;

			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////
	public static void checkedRoom() {
		int input = 0;
		
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[이미 들어간 방이거나");
			System.out.println("	들어갈 수 없는 방입니다.]");
			System.out.println("                                      ");
			System.out.println("	1. 돌아가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요]");
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	public static void noKey() {
		int input = 0;
		
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[키가 있어야 아래 층으로");
			System.out.println("	이동할 수 있습니다.");
			System.out.println("	방을 돌아다니면서 키를 찾으세요.]");
			System.out.println("                                      ");
			System.out.println("	1. 돌아가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////
	public static void yesKey() {
		int input = 0;
		
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[키를 사용하여");
			System.out.println("	아래 층으로 내려갈 수 있습니다.]");
			System.out.println("                                      ");
			System.out.println("	1. 내려가기");
			System.out.println("                                      ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////   

	public static void checkRoom() {
		int input = 0;
		
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[좀비가 나타났습니다.]");
			System.out.println("                                      ");
			System.out.println("	1. 공격하기");
			System.out.println("	2. 도망가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				Attackview();
				break;
			case 2:
				run();
				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		} else {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
				System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
				System.out.println("                                      ");
				System.out.println("	[아무것도 없었다.]");
				System.out.println("                                      ");
				System.out.println("	1. 돌아가기");
				System.out.println("                                      ");
				System.out.println("	9. 아이템 사용");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				clearScreen();

				switch (input) {
				case 1:
					break;
				case 9:
//					itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
				}
			}
		}
	}
	//////////////////////////////////////////////////////////////////
	public void aaaaaaaaaaaaaaaa() {
		int input = 0;
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[강의실에 입장했습니다.");
			System.out.println("	졸음이 쏟아집니다..]");
			System.out.println("                                      ");
			System.out.println("	1. 쉬기");
			System.out.println("	2. 나가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				aaaaaaaaa5a();
				break;
			case 2:
				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}
	public void aaaaaaaaa5a() {
		int input = 0;
		
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[백동현강사님 좀비를 만났습니다.]");
			System.out.println("                                      ");
			System.out.println("	1. 공부하기");
			System.out.println("	2. 도망가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				
				break;
			case 2:
				run();

				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	public void Zerofloor() {
		int input = 0;
		
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
			System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
			System.out.println("                                      ");
			System.out.println("	[좀비가 나타났습니다.]");
			System.out.println("                                      ");
			System.out.println("	1. 공격하기");
			System.out.println("	2. 도망가기");
			System.out.println("                                      ");
			System.out.println("	9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			clearScreen();

			switch (input) {
			case 1:
				Attackview();
				break;
			case 2:
				run();

				break;
			case 9:
//				itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	public static void Attackview() {
		int input = 0;
		
		if (gameService.attack()) {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
				System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
				System.out.println("                                      ");
				System.out.println("	[재빠르게 회피하고 좀비를");
				System.out.println("   	처리했습니다.]");
				System.out.println("                                      ");
				System.out.println("	1. 돌아가기");
				System.out.println("                                      ");
				System.out.println("	9. 아이템 사용");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
//					itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
				}
			}
		} else {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
				System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
				System.out.println("                                      ");
				System.out.println("	[공격을 당했지만");
				System.out.println("	좀비를 처리했습니다.]");
				System.out.println("                                      ");
				System.out.println("	1. 돌아가기");
				System.out.println("                                      ");
				System.out.println("	9. 아이템 사용");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				clearScreen();

				switch (input) {
				case 1:

					break;
				case 9:
//					itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
				}
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////
	public static void runcheck() {
		int input = 0;
		
		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
		System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
		System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
		System.out.println("                                      ");
		System.out.println("	[도망에 실패했습니다.");
		System.out.println("	좀비에게 피해를 입습니다.]");
		System.out.println("                                      ");
		System.out.println("	1. 공격하기");
		System.out.println("	2. 도망가기");
		System.out.println("                                      ");
		System.out.println("	9. 아이템 사용");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("메뉴 선택 >> ");
		input = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		clearScreen();

		switch (input) {
		case 1:
			Attackview();
			break;
		case 2:
			run();
			break;
		case 9:
//      itemUse();
			break;
		default:
			System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
		}
	}

	/////////////////////////////////////////////////////////////////////////
	public void itemview() {
		int input = 0;
		
		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
		System.out.printf ("┃HP : %d/5  ┃ST : %d/3  ┃현재 층 : %dF   ◆\n", viewHp(), viewStamina(), viewFloor());
		System.out.println("┗━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
		System.out.println("                                      ");
		System.out.println("                                      ");
		System.out.println("                                      ");
		System.out.println("                                      ");
		System.out.println("	1. 공격하기");
		System.out.println("	2. 도망가기");
		System.out.println("                                      ");
		System.out.println("	9. 아이템 사용");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("메뉴 선택 >> ");
		input = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		System.out.println();

		switch (input) {
		case 1:
			Attackview();
			break;
		case 2:
			run();
			break;
		case 9:
//      itemUse();
			break;
		default:
			System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");

		}
	}

//////////////////////////////////////////////////////////
	private static void checkingRoom(int i) {
		if (viewFloor() - 1 == 6 || viewFloor() - 1 == 0) {
			System.out.println("[메뉴에 존재하는 번호만 입력해주세요.]");
		} else {
			if (floor.getFloor(viewFloor() - 1, i).equals("탕비실")) {
				gameService.addItem(gameService.whatItem());
			}

			if (floor.getFloor(viewFloor() - 1, i).equals(floor.getFloor2(viewFloor() - 1, i))) {
				checkedRoom();
			} else {
				floor.getFloor(viewFloor() - 1, i);
				System.out.println(floor.getFloor(viewFloor() - 1, i));
				floor.setFloor(viewFloor() - 1, i, floor.getFloor(viewFloor() - 1, i));
				checkRoom();
			}
			if (floor.keyCheck(viewFloor() - 1, i).equals("[열쇠를 발견하였습니다.]")) {
				gameService.getKey();
			}
		}

	}

	private static void run() {
		boolean i = gameService.run();

		if (i == false) {
			runcheck();
		} else {
		}
	}

	private static boolean checkKey() {
		if (gameService.isKey() == true) {
			yesKey();
			return true;
		}
		noKey();
		return false;
	}

	private static int viewHp() {
		return gameService.viewHp();
	}

	private static int viewStamina() {
		return gameService.viewStamina();
	}

	private static int viewFloor() {
		return gameService.viewFloor();
	}

	public void moveFloor(boolean move) { // 층 이동
		gameService.moveFloor(move);
	}

	private int hitPlayer(int damage) {

		return gameService.hitPlayer(damage);
	}

	public void useItem(int index) { // 사용하면 삭제"null"로 변경
		gameService.useItem(index - 1);
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		displayOutro() /* 게임 아웃트로 */
	
	
	// 게임 아웃트로
	public static void displayOutro() {
		System.out.println("  \"와~ 드디어 탈출이다!\""); enter();
		System.out.println("  \"우리는 최후의 승자야.\""); enter();
		System.out.println("  \"이제부터는 항상 주위 사람을 챙기면서 살아가자..\""); enter();
		System.out.println("  \"힘을 내고, 힘을 내고, 힘을 내자!\""); enter();
		System.out.println("  \"아자! 아자! 파이팅~\""); enter();
		System.out.println("  \"우리 인생 파이팅~\""); enter();
		System.out.println("  \"FOREVER..\""); enter();
		System.out.println("●한바탕 좀비 소동에서 탈출한 이들은\n"
				+ "  오래오래 잘 살았다고 한다.●"); enter(); clearScreen();
		System.out.println("[게임 끝]"); enter(); clearScreen();
		displayEnding(); /* 엔딩 */
	}
	
	// 엔딩
	public static void displayEnding() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                End                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("  만든 이:");
		System.out.println("    정용화 / 박종욱 / 장반석");
		System.out.println("    정송이 / 최근태 / 이상준"); clearScreen();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃====================================┃");
		System.out.println("┃      Cheong-gye Greits Escape      ┃");
		System.out.println("┃====================================┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃  /     /       / /   /     /   /   ┃");
		System.out.println("┃   /  /    THANKS TO PLAY! /  /    /┃");
		System.out.println("┃    / /      /        /      /   /  ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
