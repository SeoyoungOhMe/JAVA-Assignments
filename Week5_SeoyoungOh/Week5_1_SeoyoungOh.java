import java.util.Scanner;
public class Week5_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		
		Play p = new Play(); // Play형 객체 p 생성
		Film f = new Film(); // Film형 객체 f 생성
		
		System.out.println("Input Title for Play");
		p.setTitle(kbd.next()); // p의 title 저장
		System.out.println("Input Director for Play");
		p.setDirector(kbd.next()); // p의 director 저장
		System.out.println("Input Writer for Play");
		p.setWriter(kbd.next()); // p의 writer 저장
		
		System.out.println("Input Title for Film");
		f.setTitle(kbd.next());// f의 title 저장
		System.out.println("Input Director for Film");
		f.setDirector(kbd.next());// f의 director 저장
		System.out.println("Input Writer for Film");
		f.setWriter(kbd.next());// f의 writer 저장
		
		System.out.println("Input Performance Cost for Play");
		p.setPerformanceCost(kbd.nextInt()); // p의 performance cost 저장
		System.out.println("Input boxOfficeGross Cost for Film");
		f.setBoxOfficeGross(kbd.nextInt()); // f의 boxOfficeGross cost 저장
		
		p.display(); // Play 클래스의 오버라이딩한 display 메서드를 호출함
		System.out.println();
		f.display(); // Film 클래스의 오버라이딩한 display 메서드를 호출함
	}

}
