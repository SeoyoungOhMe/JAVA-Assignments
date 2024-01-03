import java.util.Scanner;

abstract class Pet{
	public String species; // 종
	public String name; // 이름
	public int age; // 나이
		
	public abstract void move();
}

class Dog extends Pet{
	public void move() { // 메소드 오버라이딩
		System.out.print("run");
	}
}

class Cat extends Pet{
	public void move() {// 메소드 오버라이딩
		System.out.print("jump");
	}
}

class Bird extends Pet{
	public void move() {// 메소드 오버라이딩
		System.out.print("fly");
	}
}

class Snake extends Pet{
	public void move() {// 메소드 오버라이딩
		System.out.print("crawl");
	}
}

public class Week7_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Pet[] group = new Pet[10];// 참조변수 배열 생성
		int ans; // 원하는 작업이 무엇인지에 대한 답을 저장
		int species; // 종이 무엇인지에 대한 답을 저장
		
		Scanner kbd = new Scanner(System.in);
		
		AA: // 이중반복문을 탈출하기 위함
		for(int i=0;i<group.length;i++) { // 배열의 크기만큼 반복
			System.out.println();
			System.out.println("원하는 작업은 무엇입니까?");
			System.out.println("1. New input\t2. Output\t3. Exit");
			ans=kbd.nextInt(); // 사용자로부터 원하는 작업이 무엇인지 답을 입력받음
			
			if(ans==1) { // 1번을 선택한 경우
				System.out.println("종은 무엇입니까?");
				System.out.println("1. Dog\t2. Cat\t3. Snake\t4. Bird");
				species=kbd.nextInt();
				
				if(species==1) {
					group[i]=new Dog(); // 개 인스턴스 생성
					group[i].species="Dog"; // 종은 개
				}
				else if(species==2) {
					group[i]=new Cat(); // 고양이 인스턴스 생성
					group[i].species="Cat"; // 종은 고양이
				}
				else if(species==3) {
					group[i]=new Snake(); // 뱀 인스턴스 생성
					group[i].species="Snake"; // 종은 뱀
				}
				else if(species==4) {
					group[i]=new Bird(); // 새 인스턴스 생성
					group[i].species="Bird"; // 종은 새
				}
				else {
					System.out.println("잘못된 출력");
					i--; // 잘못된 출력에 대해 배열에 저장하지 않기 위함
					break;
				}
				System.out.print("Name:");
				group[i].name=kbd.next(); // 이름 입력받음
				System.out.print("Age:");
				group[i].age=kbd.nextInt(); // 나이 입력받음
			}
			else if(ans==2) { // 2번을 선택한 경우
				System.out.println();
				System.out.println("Species\tName\tAge\tMovement"); // 카테고리 입력
				for(int j=0;j<i;j++) {
					System.out.printf("%s\t%s\t%d\t", group[j].species, group[j].name, group[j].age);
					group[j].move(); // 오버라이딩된 메소드가 호출됨
				}
				System.out.println();
				i--; // 배열에 저장하지 않기 위함
			}
			else if(ans==3) { // 3번을 선택한 경우
				System.out.println("종료");
				break AA; // 이중 반복문 탈출
			}
			else { // 잘못 입력한 경우
				i--; // 배열에 저장하지 않기 위함
				System.out.println("잘못된 입력");
			}
		}
		
	}
}
