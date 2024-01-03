import java.util.Scanner;

class DiceGame{
	private int diceFace;
	private int userGuess;
	
	private int rollDice() {
		return (int)(Math.random()*6+1); // 1~6의 랜덤 숫자를 반환함
	}
	private void setUserInput() {
		int input; // 사용자에게 입력받는 숫자 추측 값 선언
		Scanner kbd = new Scanner(System.in);
		System.out.println("Guess the number! What do you think?");
		input = kbd.nextInt(); // 값을 초기화함
		while(input<1 || input>6) { // 사용자가 입력한 값이 범위에 맞지 않은 경우
			System.out.println("Input number between 1~6.");
			input = kbd.nextInt(); // 다시 입력을 받음
		}
		userGuess = input; // 범위가 유효한 경우 값을 저장함
		
	}
	private void checkUserGuess() {
		if(diceFace==userGuess) { // 사용자가 주사위 값을 맞춘 경우
			System.out.println("Bingo!!!");
		}
		else { // 틀린 경우
			System.out.println("Wrong!");
		}
	}
	public void startPlaying() {
		diceFace = rollDice(); // 주사위를 던져 나온 랜덤한 값을 diceFace에 저장함
		setUserInput(); // 사용자에게 추측 값을 입력받음
		checkUserGuess(); // 사용자의 추측이 맞는지 확인함
	}
}

public class HW1_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");

		DiceGame dg = new DiceGame(); // DiceGame형 객체 생성
		String ans="y"; // 사용자에게 게임을 다시 할지 입력받는 대답으로, 처음에는 while문을 실행하기 위해 임의로 y로 초기화함
		Scanner kbd1 = new Scanner(System.in);
		
		while(!ans.equalsIgnoreCase("n")) { // ans가 n이나 N이 아닌 경우 반복문을 실행함
			System.out.println("\n<< GAME START >>");
			System.out.println("Dice is rolled!!!");
			dg.startPlaying(); // dg의 주사위게임을 실행하는 메소드를 실행함
			System.out.println("Try again?(y/n)");
			ans = kbd1.next(); // 사용자에게 대답을 입력받음
		}
		System.out.println("Game finished.");
	}

}
