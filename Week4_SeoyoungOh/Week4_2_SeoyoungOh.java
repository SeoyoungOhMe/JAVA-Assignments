import java.util.Scanner;

class Facto{ // Facto 클래스 선언
	static int result; // 두 수의 팩토리얼 값의 차이
	static int factoVal(int x) {
		int fac=1;
		for(int i=1; i<=x; i++) {
			fac*=i; // 팩토리얼 계산하는 과정
		}
		return fac;
	}
}

public class Week4_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		int a, b; // 사용자에게 입력받는 두 정수 선언
		int result; // 두 정수의 팩토리얼 값 차이를 저장
		Scanner kbd=new Scanner(System.in);
		
		System.out.print("두 정수 입력(1 이상 10 이하):");
		a=kbd.nextInt(); // a 값 초기화
		b=kbd.nextInt(); // b 값 초기화
		while(a>0 && a<=10 && b>0 && b<=10) { // a와 b가 1부터 10 사이의 정수인 경우
			result=Facto.factoVal(a) - Facto.factoVal(b); // 팩토리얼 값 차이 계산
			Facto.result=result; // 클래스 변수에 값을 저장
			System.out.println("Factorial("+a+")-Factorial("+b+") = "+result);
			System.out.print("두 정수 입력(1 이상 10 이하):");
			a=kbd.nextInt();
			b=kbd.nextInt();
		}
		System.out.println("범위가 잘못되었습니다. 종료합니다."); // 범위가 잘못된 경우 종료
		

	}

}
