
public class Circle {
	public final double PI = 3.14159; // 상수 PI를 선언함.
	private double radius; // 반지름 radius
	
	public void setRadius(double radius) { // 반지름을 사용자에게 입력받아 저장
		this.radius=radius;
	}
	public double getRadius() { // 반지름 값을 반환해줌
		return radius;
	}
	public double perimeter() { // 원둘레를 계산해주는 메소드
		return PI*2*radius;
	}
	public double area() { // 원넓이를 계산해주는 메소드
		return PI*radius*radius;
	}
	public void circleInfo() {
		System.out.printf("원둘레:%.2f", perimeter()); // 원둘레를 소수점 2자리까지 출력
		System.out.println();
		System.out.printf("원넓이:%.2f", area()); // 원넓이를 소수점 2자리까지 출력
		
	}
}
