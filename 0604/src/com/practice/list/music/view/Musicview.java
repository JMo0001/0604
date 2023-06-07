package com.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.practice.list.music.controller.MusicController;
import com.practice.list.music.moel.vo.Music;

public class Musicview {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	public void mainmenu() {
//		******* 메인 메뉴 *******
//		1. 마지막 위치에 곡 추가 // addList() 실행
//		2. 첫 위치에 곡 추가 // addAtZero()
//		3. 전체 곡 목록 출력 // printAll()
//		4. 특정 곡 검색 // searchMusic()
//		5. 특정 곡 삭제 // removeMusic()
//		6. 특정 곡 정보 수정 // setMusic()
//		7. 곡명 오름차순 정렬 // ascTitle()
//		8. 가수명 내림차순 정렬 // descSinger()
//		9. 종료 // “종료” 출력 후 main()으로 리턴
//		메뉴 번호 선택 : >> 입력 받음
//		// 메뉴 화면 반복 실행 처리
		int menu = 0;
		do{	//조건 체크 안하고 1.메뉴 보여주고 2. 입력 받고 3. 대입 하면서 try catch 가고 4. while(조건)확인함.
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			
			String menuStr = sc.nextLine();
			menu = 0;	// 초기화는 try문 바로 위에서.
			try {
				menu = Integer.parseInt(menuStr);//사용자 입력 >> menu에 대입.
			}catch(NumberFormatException e) {
				System.out.println("문자는 입력할 수 없습니다..");
			}
			switch(menu) {
			//정상 입력 경우
			case 1 : addList();
				break;
			case 2 : addAtZero();
				break;
			case 3 : printAll();
				break;
			case 4 : searchMusic();
				break;
			case 5 : removeMusic();
				break;
			case 6 : setMusic();
				break;
			case 7 : ascTitle();
				break;
			case 8 : descSInger();
				break;
			case 9 : 
				break;
//				return;	//종료 >>main으로 돌아감
			default:
				//비정상 입력 경우
				System.out.println("메뉴에 해당하는 1-9에 해당하는 숫자만 작성해주세요.");
				continue;	//do로 올라감
			}
			//반복문 마지막.
//			System.out.println("정상 시행시에만 보였으면 함.");
		}while(menu !=9);//while문 끝남
		System.out.println("종료");
		return;
		
		
	}
	public void addList() {
		//****** 마지막 위치에 곡 추가 ******
		// 곡 명과 가수 명을 사용자에게 입력 받는다.
		// MusicController에 addList()를 이용해서 입력한 정보를 넘기고
		// 추가 성공 시 “추가 성공”, 추가 실패 시 “추가 실패” 콘솔창에 출력
		System.out.println("****** 마지막 위치에 곡 추가 ******");//mc.addList(null)
		System.out.println("곡 명 : ");
		String title = sc.nextLine();
		System.out.println("가수 명 : ");
		String singer = sc.nextLine();
//		Music vo = new Music(); 
//		vo.setSinger(singer);
//		vo.setTitle(title); //따로따로 보내기보다 묶어서 보내는 것이 좋다.
//		Music vo = new Music(title, singer); 
		int result = mc.addList(new Music(title, singer)); //addList 눌러보면 Controller에서 int형 리턴
		if(result>0) {//0보다 크면 추가 성공, 0이면 추가 실패
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}//만들었으면  controller 가서 추가해 줄것.
	}
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");//mc.addAtZero
		System.out.println("곡 명 : ");
		String title = sc.nextLine();
		System.out.println("가수 명 : ");
		String singer = sc.nextLine();
		int result = mc.addAtZero(new Music(title, singer)); //addList 눌러보면 Controller에서 int형 리턴
		if(result>0) {//0보다 크면 추가 성공, 0이면 추가 실패
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	public void printAll() {
		//****** 전체 곡 목록 출력 ******
		// MusicController에 printAll() 반환 값을 출력한다.
		System.out.println("****** 전체 곡 목록 출력 ******");// mc.printAll();
		List<Music> volist = mc.printAll();	// 리턴 타입은? List
		for(Music vo : volist) {//enhanced for 반복문 for(리턴타입 변수명 : 리턴할 배열명)
			System.out.println(vo);
		}
	}
	public void searchMusic() {
//		****** 특정 곡 검색 ******
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡명을 입력해주세요.");
		String title = sc.nextLine();
		Music result = mc.searchMusic(title); //리턴 타입은? Music
		if(result==null) {
			System.out.println("검색한 곡이 없습니다.");
		}else {
			System.out.printf("검색한 곡은 000(%s, %s) 입니다.\n", result.getTitle(), result.getSinger());
		}
		System.out.println("결과");
		
	}
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.println("삭제할 곡명을 입력해주세요.");
		String title = sc.nextLine();
		Music result = mc.removeMusic(title);
		if(result==null) {
			System.out.println("삭제할 곡이 없습니다.");
		}else {
			System.out.printf("000(%s, %s)을 삭제 했습니다.\n", result.getTitle(), result.getSinger());
		}
	}
	public void setMusic() {
		//TODO
	}
	public void ascTitle() {
		//TODO
	}
	public void descSInger() {
		//TODO
	}

}
