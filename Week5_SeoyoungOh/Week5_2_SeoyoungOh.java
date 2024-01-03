import java.util.Scanner;
public class Week5_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd = new Scanner(System.in);
		
		Dog[] d = new Dog[3]; // Dog형 참조변수 생성
		Cat[] c = new Cat[3]; // Cat형 참조변수 생성
		
		for(int i=0; i<d.length; i++) {
			d[i] = new Dog(); // 실제 인스턴스 생성
			System.out.println("<<Dog " + (i+1) + ">>"); // 몇 번째 Dog인지 출력
			
			System.out.println("Name :");
			d[i].setName(kbd.next()); // 이름 저장
			
			System.out.println("Age :");
			d[i].setAge(kbd.nextInt()); // 나이 저장
			
			System.out.println("Weight :");
			d[i].setWeight(kbd.nextInt()); // 몸무게 저장
			
			System.out.println("BoosterShot(y/n) :"); 
			if(kbd.next().equalsIgnoreCase("Y"))
				d[i].setBoosterShot(true); // 부스터샷 여부가 y인 경우 true를 인자로 넘김
			else
				d[i].setBoosterShot(false);// 부스터샷 여부가 n인 경우 false를 인자로 넘김
			
			System.out.println();
		}
		
		for(int i=0; i<c.length; i++) {
			c[i] = new Cat(); // 실제 인스턴스 생성
			System.out.println("<<Cat " + (i+1) + ">>");// 몇 번째 Cat인지 출력
			
			System.out.println("Name :");
			c[i].setName(kbd.next());// 이름 저장
			
			System.out.println("Age :");
			c[i].setAge(kbd.nextInt());// 나이 저장
			
			System.out.println("Weight :");
			c[i].setWeight(kbd.nextInt());// 몸무게 저장
			
			System.out.println("Color :");
			c[i].setColor(kbd.next()); // 몸 색깔 저장
			
			System.out.println();
		}
		
		System.out.println("<<Dog List>>"); // 강아지 리스트 출력
		for(int i=0; i<d.length; i++) {
			d[i].writeOutput(); // Dog 클래스의 오버라이딩한 writeOutput 메서드 호출
			d[i].move();// Dog 클래스의 오버라이딩한 move 메서드 호출
			System.out.println();
		}
		System.out.println();
		
		System.out.println("<<Cat List>>"); // 고양이 리스트 출력
		for(int i=0; i<c.length; i++) {
			c[i].writeOutput();// Cat 클래스의 오버라이딩한 writeOutput 메서드 호출
			c[i].move();// Cat 클래스의 오버라이딩한 move 메서드 호출
			System.out.println();
		}
		
		System.out.println("* Dogs older than 2 years and no boostershot are...");
		for(int i=0; i<d.length; i++) { // 모든 강아지에 대해 확인
			if(d[i].getAge() > 2 && d[i].getBoosterShot() == true)// 두 살보다 많고 예방접종하지 않은 강아지
				System.out.println(d[i].getName()); // 조건에 해당되는 강아지 이름 출력
		}
		
		System.out.println();
		System.out.println("* Black cats weighs more than 3kg are...");
		for(int i=0; i<c.length; i++) { // 모든 고양이에 대해 확인
			if(c[i].getWeight() > 3 && c[i].getColor().equalsIgnoreCase("black")) // black 색깔이고 3kg가 넘는 고양이
				System.out.println(c[i].getName()); // 조건에 해당되는 고양이 이름 출력
		}
	}

}
