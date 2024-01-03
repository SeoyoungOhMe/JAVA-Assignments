import java.util.Scanner;
public class Week3_4_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		MenuOrder mo = new MenuOrder(); // 객체 mo 생성
		Scanner kbd = new Scanner(System.in); 
		String input = "Y";
		int money; // 사용자가 넣는 돈
		int choice; // 사용자가 선택하는 음료의 번호
		
		System.out.println("--- 음료가격 설정 ---");
		System.out.println("Coke가격:");
		mo.setPrice("coke", kbd.nextInt()); // 콜라 가격을 입력받음
		System.out.println("Lemonade가격:");
		mo.setPrice("lemonade", kbd.nextInt()); // 레모네이드 가격을 입력받음
		System.out.println("Coffee가격:");
		mo.setPrice("coffee", kbd.nextInt()); // 커피 가격을 입력받음
		
		while(input.equalsIgnoreCase("y")) {
			System.out.println("\n--- 돈을 넣으세요 ---");
			money=kbd.nextInt();
			mo.setMoney(money); // 입력받은 돈의 금액을 저장
			System.out.println("--- 음료를 선택하세요 ---");
			mo.showMenu(); // 음료의 종류와 가격을 출력
			mo.showResult(kbd.nextInt()); // 사용자에게 음료 번호를 입력받고 결과 출력
		
			System.out.println("계속 하시겠습니까?(y/n)");
			kbd.nextLine(); // 개행 문제 해결
			input=kbd.nextLine();
		}
	}

}
