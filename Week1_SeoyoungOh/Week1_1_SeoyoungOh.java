import java.util.Scanner;
public class Week1_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		int base, height; // base는 밑변, height은 높이
		float area; // area는 삼각형의 넓이

		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Input base:");
		base = keyboard.nextInt(); // 입력값으로 base 초기화

		System.out.println("Input height:");
		height = keyboard.nextInt(); // 입력값으로 height 초기화
		
		area = (float)(base*height)/2; // float 형으로 area 계산
		
		System.out.println("The area :"+area);
	}

}