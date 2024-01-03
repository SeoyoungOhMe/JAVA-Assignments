import java.util.Scanner;
public class Week1_3_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		int F; // 화씨 온도 선언
		float C; // 섭씨 온도 선언
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("화씨온도 입력:");
		F = keyboard.nextInt(); // 화씨 온도 입력받아 초기화
		
		C = (float)5/9 * (F - 32); // 섭씨 온도를 float형으로 계산
		
		System.out.println("화씨온도:" + F); // 화씨 온도 출력
		System.out.printf("섭씨온도:%.1f", C); // 섭씨 온도를 소수점 이하 한자리까지 출력
	}

}
