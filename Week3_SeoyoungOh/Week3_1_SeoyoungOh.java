import java.util.Scanner;
public class Week3_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Song s1= new Song(); // 객체 s1 생성
		Song s2=new Song(); // 객체 s2 생성
		int input; // 1과 2번 노래 중 하나를 사용자에게 입력받음
		
		Scanner keyboard =new Scanner(System.in);
		
		System.out.println("*Song 1*"); 
		System.out.println("곡명입력:");
		s1.title=keyboard.nextLine(); // s1 객체에 곡명을 저장함
		System.out.println("가수명입력:");
		s1.singer=keyboard.nextLine(); // s1 객체에 가수명을 저장함
		System.out.println("가격입력:");
		s1.price=keyboard.nextInt(); // s1 객체에 가격을 저장함
		keyboard.nextLine();
		
		System.out.println("\n*Song 2*");
		System.out.println("곡명입력:");
		s2.title=keyboard.nextLine();// s2 객체에 곡명을 저장함
		System.out.println("가수명입력:");
		s2.singer=keyboard.nextLine();// s2 객체에 가수명을 저장함
		System.out.println("가격입력:");
		s2.price=keyboard.nextInt();// s2 객체에 가격을 저장함
		keyboard.nextLine();
		
		System.out.println("\n노래를 고르세요"); 
		System.out.println("1:" + s1.title + " 2:" + s2.title); // 객체에 저장된 곡명을 모두 출력함.
		input = keyboard.nextInt(); // 사용자에게 노래를 입력받음
		
		switch(input) {
		case 1: // 1번 노래를 선택한 경우
			s1.play();
			s1.price(); // 가격 출력
			break;
		case 2: // 2번 노래를 선택한 경우
			s2.play();
			s2.price(); // 가격 출력
			break;
		}
		System.out.println("감사합니다.");
	}

}
