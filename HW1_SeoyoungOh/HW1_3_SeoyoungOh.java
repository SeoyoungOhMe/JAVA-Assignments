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

class Audio extends Product{
	Audio(){
		super(50); // 가격 50 저장
	}
	public String toString() {
		return "Audio"; // Audio 출력
	}
}

class Buyer{ // 구매자 정보 저장
	private int money, i;
	int bonusPoint=0;
	Product item[] = new Product[10];
	
	Buyer() {} // 생성자
	
	public boolean setMoney(int money) { // 가격 정보 저장
		
		if(money >0) {
			this.money = money;
			return true;
		}
		else {
			System.out.println("Money should be positive.");
			return false;
		}
	}
	
	public int getMoney() { // 가격 정보 리턴하는 메서드
		return money;
	}
	
	void buy(Product pd) {
		if(pd.price>money) { // 남아있는 금액보다 물건의 가격이 더 큰 경우 돈이 부족하다는 메시지를 출력하고 exit함
			System.out.println("Money is not enough.");
			System.out.println();
		}
		else {
			System.out.println("You bought "+pd+"("+pd.price+")."); // 구매 정보를 출력
			money -= pd.price; // 구매한 물건의 가격만큼 총 금액에서 빼줌
			bonusPoint += pd.bonusPoint; // 보너스 포인트 계산
			item[i++] = pd; // 아이템을 배열에 저장
		}
	}
	
	void summary() { // 모든 구매 관련 정보를 출력해줌
		System.out.print("- Shopping list: ");
		for(int j=0;j<i;j++) {
			System.out.print(item[j]+" "); // item 배열을 모두 돌아가며 쇼핑 리스트를 출력함
		}

		System.out.println("\n- Money left: "+ money); // 남은 금액을 출력함
		
		System.out.print("- Current bonus point: "+bonusPoint); // 적립된 보너스 포인트를 출력
	}
}

public class HW1_3_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		
		Product pd[];
		int input; // 사용자가 입력하는 구매하고 싶은 물품의 번호
		int person; // buyer의 수
		boolean pos; // 사용자가 입력한 값이 양의 정수인지 아닌지 확인하는 메소드 실행 후 리턴값 저장하는 변수
		
		TV t = new TV(); // TV형 객체 생성
		Computer c = new Computer();// 컴퓨터형 객체 생성
		Audio a = new Audio();// 오디오형 객체 생성
		
		System.out.print("How many buyers? ");
		person=kbd.nextInt();
		Buyer by[] = new Buyer[person]; 
		System.out.println();
		
		for(int i=0;i<person; i++) {
			by[i] = new Buyer();
			System.out.println("<Buyer"+(i+1)+">");
			System.out.println("How much money do you have?"); // 맨 처음에 사용자가 가진 금액을 입력받음
			pos = by[i].setMoney(kbd.nextInt()); // 사용자가 입력한 값을 저장함
			while(pos==false) {
				System.out.println("How much money do you have?"); // 맨 처음에 사용자가 가진 금액을 입력받음
				pos = by[i].setMoney(kbd.nextInt()); 
			}
			
			System.out.println("Choose the item. You have "+by[i].getMoney() +"won left. Input 0 to quit.");
			System.out.println("1.TV(100)\t2.Computer(200)\t3.Audio(50)");
			input = kbd.nextInt();
			
			while((input != 0)) { // 사용자가 입력한 값이 0이 아닌 경우 while문을 실행함
				switch(input) {
				case 1: by[i].buy(t);break; //티비 구매
				case 2: by[i].buy(c);break; // 컴퓨터 구매
				case 3: by[i].buy(a);break; // 오디오 구매
				default : System.out.println("Wrong Input");break;
				}
				
				System.out.println("Choose the item. You have "+by[i].getMoney() +"won left. Input 0 to quit.");
				System.out.println("1.TV(100)\t2.Computer(200)\t3.Audio(50)");
				input = kbd.nextInt();
			}
			
			System.out.println();
		}
		
		System.out.println("<Shopping Result>");
		for(int j=0;j<person;j++) {
			System.out.println("<Buyer "+(j+1)+">");
			by[j].summary(); // 구매 정보 모두 출력
			System.out.println();
		}
		
	}

}
