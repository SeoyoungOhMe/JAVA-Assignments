import java.util.Scanner;

class Game{
	private int youScr; // 사용자의 누적 점수
	private int comScr; // 컴퓨터의 누적 점수
	private int youCho; // 사용자가 가위, 바위, 보 중 선택한 패
	private int comCho; // 컴퓨터가 가위, 바위, 보 중 선택한 패
	
	Game(){} // 생성자
	public void play() {
		System.out.println("가위바위보 게임을 시작합니다."); // 게임 시작
		System.out.println();
		
		while(youScr!=3 && comScr!=3) { // 한 쪽이 먼저 세 번을 이기기 전까지 게임 반복
			int n=input();
			if(n==1)writeOutput(); // 범위 내의 숫자를 입력했을 경우만 writeOutput 메서드 실행
			System.out.println();
		}
		// 어느 한 쪽이 이긴 경우
		System.out.println("You("+youScr+")\tCom("+comScr+")"); // 최종 점수 출력
		if(youScr==3) { // 3점을 당신이 먼저 낸 경우
			System.out.println("당신이 이겼습니다.");
		}
		else { // 3점을 컴퓨터가 먼저 낸 경우
			System.out.println("컴퓨터가 이겼습니다.");
		}
		System.out.println("게임을 종료합니다.");
	}
	public int input() {
		Scanner kbd = new Scanner(System.in);
		String youPick; // 사용자가 선택한 패
		String comPick; // 컴퓨터가 선택한 패
		int num=0; // 사용자가 입력한 값이 1~3의 범위인지 확인 후 다른 값을 리턴
		
		try {
			System.out.println("당신의 선택은?(You("+youScr+") - Com("+comScr+"))");
			System.out.println("가위(1) 바위(2) 보(3)");
			youCho = kbd.nextInt(); // 1~3 중 사용자로부터 입력을 받음
			
			if(youCho<1 || youCho>3) {
				throw new Exception("범위가 잘못되었습니다."); // exception을 throw함
			}

			System.out.println("<You>\t<Com>");
			
			if(youCho==1) 
				youPick="가위";
			else if(youCho==2)
				youPick="바위";
			else 
				youPick="보";
			
			comCho = (int)(Math.random()*3)+1; // 컴퓨터 선택값 설정하고 저장함
			if(comCho==1)
				comPick="가위";
			else if(comCho==2)
				comPick="바위";
			else 
				comPick="보";
			
			System.out.println(youPick+"\t"+comPick); // 사용자와 컴퓨터의 패를 출력함
			
			num=1; // 사용자가 1~3 사이의 값을 입력한 경우 1을 리턴
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); // 범위가 잘못되었음을 출력함
		}
		return num; 
		
	}
	public void writeOutput() {
		if(youCho==comCho) {
			System.out.println("비김"); // 비긴 경우 점수의 변화 없음
		}
		else if((youCho%3)+1 == comCho) {
			System.out.println("컴퓨터 승");
			comScr++; // 컴퓨터 점수를 1점 추가
		}
		else {
			System.out.println("당신 승");
			youScr++; // 당신의 점수를 1점 추가
		}	
	}
}

public class Week8_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Game g = new Game();
		g.play();

	}

}
