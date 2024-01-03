import java.util.Scanner;
public class Week3_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner keyboard= new Scanner(System.in);
		double radius; // radius 반지름 선언
		
		Circle cir=new Circle(); // Circle형 객체 cir 생성
		System.out.println("반지름:"); 
		radius = keyboard.nextDouble(); // 반지름을 사용자에게 입력받음
		cir.setRadius(radius); // 객체에 반지름 값을 저장
		
		System.out.println("반지름:" + cir.getRadius()); // 반지름을 다시 출력해줌
		
		cir.circleInfo(); // 원둘레와 원넓이 출력
	}

}
