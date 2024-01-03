import java.util.Scanner;
public class Week1_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		int a, b, c; // 세 개의 정수를 각각 a, b, c로 선언
		float avg; // avg는 세 개의 정수의 평균 값
		
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("정수 세 개 입력"); 
		a = keyboard.nextInt(); // a 초기화
		b = keyboard.nextInt(); // b 초기화
		c = keyboard.nextInt(); // c 초기화
		
		avg = (float)(a+b+c)/3; // float형으로 avg에 값 저장
		System.out.printf("평균:%.2f", avg); // 소수점 이하 둘째자리까지 출력
		
	}

}
