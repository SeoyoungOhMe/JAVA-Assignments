import java.util.Scanner;

class Shape{
	private int x;
	private int y;

	public void setPoint(int x, int y) {
		this.x=x; // x 값 저장
		this.y=y; // y 값 저장
	}
	public void display() { // 저장된 값 출력
		System.out.println("Point (x,y) = ("+x+","+y+")");
	}
}

class Circle extends Shape{
	private int radius;
	
	public void setPoint(int x, int y, int radius) {
		super.setPoint(x, y); // Shape 클래스의 setPoint 메소드 호출
		this.radius=radius; // radius 저장
	}
	public void display() {
		super.display(); // Shape 클래스의 display 메소드 호출
		System.out.println("Radius r = " + radius); // radius 출력
	}
}

class Rectangle extends Shape{
	private int width;
	private int height;
	
	public void setPoint(int x, int y, int width, int height) {
		super.setPoint(x, y); // Shape 클래스의 setPoint 메소드 호출
		this.width=width; // width 저장
		this.height=height; // height 저장
	}
	public void display() {
		super.display();// Shape 클래스의 display 메소드 호출
		System.out.println("Width: "+ width+", Height: "+height); // width와 height 출력
	}
}

public class HW1_5_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		Shape[] myShape = new Shape[10]; // 참조변수는 부모 타입
		int input; // 1~4의 선택지 중 사용자에게 입력받는 값
		int x, y, r, w, h; 
		
		AA:
		for(int i=0; i<10;i++) {
			System.out.println("1.Circle\t2.Rectangle\t3.Show\t4.Exit");
			input=kbd.nextInt(); // 사용자에게 1~4 중 하나를 입력받음
			switch(input) { // 사용자에게 받은 값에 따라 다른 실행
			case 1: 
				myShape[i]=new Circle();  // 인스턴스는 자식 클래스로 생성
				System.out.print("x = ");
				x=kbd.nextInt(); // x 값 입력받음
				System.out.print("y = ");
				y=kbd.nextInt();// y 값 입력받음
				System.out.print("r = ");
				r=kbd.nextInt();// r 값 입력받음
				Circle c=(Circle)myShape[i]; // 다운캐스팅
				c.setPoint(x, y, r); // 다운캐스팅했기 때문에 setPoint 메소드 접근 가능
				break;
			case 2: 
				myShape[i]=new Rectangle();// 인스턴스는 자식 클래스로 생성
				System.out.print("x = ");
				x=kbd.nextInt();// x 값 입력받음
				System.out.print("y = ");
				y=kbd.nextInt();// y 값 입력받음
				System.out.print("w = ");
				w=kbd.nextInt();// w 값 입력받음
				System.out.print("h = ");
				h=kbd.nextInt();// h 값 입력받음
				Rectangle rec =(Rectangle)myShape[i]; //다운캐스팅
				rec.setPoint(x, y, w, h); // 다운캐스팅했기 때문에 setPoint 메소드 접근 가능
				break;
			case 3:
				for(int j=0;j<i;j++) {
					myShape[j].display(); // 그동안의 myShape 요소들을 모두 출력
				}
				i--; // 단지 그동안의 리스트를 출력만하므로 i값을 다시 하나 빼줘야 함
				break;
			case 4:
				break AA; // 이중 반복문을 빠져나옴.
			default:
				break;
			}
			
			System.out.println();
		}
	}

}
