import java.util.Scanner;

class Product{ // 공통되는 멤버변수와 메서드를 정의함
	int price; // 가격 
	int bonusPoint; // 보너스 포인트
	Product(int price){
		this.price=price; // 가격을 저장
		bonusPoint=(int)(price/10.0); // 보너스 포인트 계산하여 저장
	}
}

class TV extends Product{
	TV(){
		super(100); // 가격 100 저장
	}
	public String toString() {
		return "Tv"; // Tv 출력
	}
}

class Computer extends Product{
	Computer(){
		super(200); // 가격 200 저장
	}
	public String toString() {
		return "Computer"; // Computer 출력
	}
}

class Video extends Product{
	Video(){
		super(110); // 가격 110 저장
	}
	public String toString() {
		return "Video"; // Video 출력
	}
}

class Audio extends Product{
	Audio(){
		super(50); // 가격 50 저장
	}
	public String toString() {
		return "Audio"; // Audio 출력
	}
}

class NoteBook extends Product{
	NoteBook(){
		super(300); // 가격 300 저장
	}
	public String toString() {
		return "NoteBook"; // NoteBook 출력
	}
}

class Buyer{ // 구매자 정보 저장
	int money, i;
	int bonusPoint=0;
	Product item[] = new Product[10];
	
	Buyer() {} // 생성자
	
	void setMoney(int money) { // 가격 정보 저장
		this.money = money;
	}
	
	int getMoney() { // 가격 정보 리턴하는 메서드
		return money;
	}
	
	int buy(Product pd) {
		if(pd.price>money) { // 남아있는 금액보다 물건의 가격이 더 큰 경우 돈이 부족하다는 메시지를 출력하고 exit함
			System.out.println("\nMoney is not enough.");
			return 1;
		}
		System.out.println("You bought "+pd+"("+pd.price+")."); // 구매 정보를 출력
		money -= pd.price; // 구매한 물건의 가격만큼 총 금액에서 빼줌
		bonusPoint += pd.bonusPoint; // 보너스 포인트 계산
		item[i++] = pd; // 아이템을 배열에 저장
		return 0;
	}
	
	void summary() { // 모든 구매 관련 정보를 출력해줌
		System.out.print("SHOPPING LIST : ");
		for(int j=0;j<i;j++) {
			System.out.print(item[j]+" "); // item 배열을 모두 돌아가며 쇼핑 리스트를 출력함
		}

		System.out.println("\nMONEY LEFT : "+ money); // 남은 금액을 출력함
		
		System.out.print("CURRENT BONUS POINT : "+bonusPoint); // 적립된 보너스 포인트를 출력
	}
}

public class Week6_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		
		Buyer by = new Buyer(); // Buyer 형 객체를 생성하고 by로 가리킴
		int input; // 사용자가 입력하는 구매하고 싶은 물품의 번호
		int rtn=0; // buy 메서드의 리턴값을 저장함
		
		TV t = new TV(); // TV형 객체 생성
		Computer c = new Computer();// 컴퓨터형 객체 생성
		Video v = new Video();// 비디오형 객체 생성
		Audio a = new Audio();// 오디오형 객체 생성
		NoteBook n = new NoteBook();// 노트북형 객체 생성
		
		System.out.println("How much do you have?"); // 맨 처음에 사용자가 가진 금액을 입력받음
		by.setMoney(kbd.nextInt()); // 사용자가 입력한 값을 저장함
		
		System.out.println("What do you want to buy? Input 0 to quit.");
		System.out.println("1. TV(100)\t2. Computer(200)\t3. Video(110)\t4. Audio(50)\t5. NoteBook(300)");
		input = kbd.nextInt();
		
		while((input != 0)) { // 사용자가 입력한 값이 0이 아닌 경우 while문을 실행함
			switch(input) {
			case 1: rtn=by.buy(t);break; //티비 구매
			case 2: rtn=by.buy(c);break; // 컴퓨터 구매
			case 3: rtn=by.buy(v);break; // 비디오 구매
			case 4: rtn=by.buy(a);break; // 오디오 구매
			case 5: rtn=by.buy(n);break; // 노트북 구매
			default : System.out.println("No such item.");break;
			}
			
			if(rtn == 1) { // 남이있는 금액보다 물건의 가격이 더 비싼 경우 더 이상 프로그램을 진행하지 않고 while문을 exit함
				break;
			}
			
			System.out.println("What do you want to buy? Input 0 to quit.");
			System.out.println("1. TV(100)\t2. Computer(200)\t3. Video(110)\t4. Audio(50)\t5. NoteBook(300)");
			input = kbd.nextInt();
		}
		
		System.out.println();
		by.summary(); // 구매 정보 모두 출력
	}
}
