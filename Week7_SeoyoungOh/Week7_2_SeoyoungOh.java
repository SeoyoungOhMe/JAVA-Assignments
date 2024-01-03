import java.util.Scanner;

interface Geometry{ // 인터페이스 생성
	public final double PI = 3.14159; // 파이 상수 값 선언
	
	public double area(); // 다른 클래스에서 접근 가능하도록 public 선언
	public double perimeter();// 다른 클래스에서 접근 가능하도록 public 선언
}

class Circle implements Geometry{
	double radius;
	
	Circle(){
		
	}
	Circle(double radius){ // 반지름 저장
		this.radius=radius;
	}
	
	public double area(){ // 메소드 오버라이딩
		return PI*radius*radius;
	}
	public double perimeter() {// 메소드 오버라이딩
		return 2*radius*PI;
	}
}

class Square implements Geometry{
	double side;
	
	Square(){
		
	}
	Square(double side){ // 변의 길이 저장
		this.side=side;
	}
	public double area(){// 메소드 오버라이딩
		return side*side;
	}
	public double perimeter() {// 메소드 오버라이딩
		return 4*side;
	}
}

class Triangle implements Geometry{
	double a,b,c;
	double s;
	
	Triangle(){
		
	}
	Triangle(double a, double b, double c){ // a, b, c를 저장하고 s를 계산 및 저장
		this.a=a;
		this.b=b;
		this.c=c;
		this.s=(a+b+c)/2;
	}
	public double area(){// 메소드 오버라이딩
		return Math.sqrt(s*(s-a)*(s-b)*(s-c)); // Math클래스의 메소드 사용
	}
	public double perimeter() {// 메소드 오버라이딩
		return a+b+c;
	}
}

public class Week7_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd = new Scanner(System.in);
		int a, b, c; // 삼각형의 세 변의 길이를 저장하는 변수
		
		Circle cir; // Circle형 참조변수 생성
		Square sqr; // Square형 참조변수 생성
		Triangle tri; // Triangle형 참조변수 생성
		
		System.out.println("Input radius for a circle");
		cir = new Circle(kbd.nextInt()); // 원의 반지름 입력
		
		System.out.println("Input length for a square");
		sqr = new Square(kbd.nextInt()); // 사각형의 변의 길이 입력
		
		System.out.println("Input a for a triangle");
		a = kbd.nextInt(); 
		System.out.println("Input b for a triangle");
		b = kbd.nextInt();
		System.out.println("Input c for a triangle");
		c = kbd.nextInt();
		tri = new Triangle(a, b, c); // 삼각형의 세 변의 길이 저장
		
		System.out.println("<Circle>");
		System.out.print("Area: ");
		System.out.println(cir.area()); // 넓이 출력
		System.out.print("Circumference: ");
		System.out.println(cir.perimeter()); // 둘레의 길이 출력
		
		System.out.println("<Square>");
		System.out.print("Area: ");
		System.out.println(sqr.area()); // 넓이 출력
		System.out.print("Circumference: ");
		System.out.println(sqr.perimeter()); // 둘레의 길이 출력
		
		System.out.println("<Triangle>");
		System.out.print("Area: ");
		System.out.println(tri.area()); // 넓이 출력
		System.out.print("Circumference: ");
		System.out.println(tri.perimeter()); // 둘레의 길이 출력
	}
}
