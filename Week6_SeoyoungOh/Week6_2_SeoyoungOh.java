import java.util.Scanner;

class Car {
	private String emgType;
	private int number;
	private String carType;
	private String reqPerson;
	
	Car(){ } // 생성자
	Car(String emgType, int number, String carType, String reqPerson){ // 생성자
		this.emgType = emgType; // 초기화
		this.number = number; // 초기화
		this.carType = carType;// 초기화
		this.reqPerson = reqPerson;// 초기화
	}
	public String getEmgType() {
		return emgType; //emgType 리턴
	}
	public int getNumber() {
		return number; // number 리턴
	}
	public String getCarType() {
		return carType; // carType 리턴
	}
	public String getReqPerson() {
		return reqPerson; // reqPerson 리턴
	}
	public String getStr() {
		return getEmgType()+"\t\t"+getNumber()+"\t\t"+getCarType()+"\t"+getReqPerson(); // 모든 관련 정보를 출력함.
	}
}

class FireEngine extends Car {
	FireEngine(){
		super("Fire", 119, "FireEngine", "FireFighter"); // 변수값 초기화
	}
	public String toString() {
		return getStr(); //Car 클래스의 getStr() 메서드 호출
	}
}

class Ambulance extends Car {
	Ambulance(){
		super("Patient", 119, "Ambulance", "Doctor"); // 변수값 초기화
	}
	public String toString() {
		return getStr(); //Car 클래스의 getStr() 메서드 호출
	}
}

class PoliceCar extends Car {
	PoliceCar(){
		super("Thief", 112, "PoliceCar", "PoliceOfficer"); // 변수값 초기화
	}
	public String toString() {
		return getStr(); //Car 클래스의 getStr() 메서드 호출
	}
}

class Emergency {
	public Car emgList[] = new Car[10]; // 최대 10개 인스턴스를 저장하는 참조변수 배열 선언
	int i=0;
	
	Emergency() {} // 생성자
	
	public void EM_Call(Car c) { // Car 타입의 인스턴스를 받아 전화번호를 출력하고 객체 배열의 인스턴스에 저장
		System.out.println("Call "+c.getNumber()); // 전화번호를 출력
		emgList[i++]= c; // 객체 배열의 인스턴스에 저장
	}
	public void EM_record() {
		System.out.println("Emergency\tNumber\t\tCar_Type\tRequired"); // 목차 출력
		for(int j=0; j<i; j++) { // 전체 배열의 모든 데이터 출력
			System.out.println(emgList[j]);
		}
	}
}

public class Week6_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		Emergency emg = new Emergency(); // Emergency 형 객체 생성
		int input; // 비상상황의 종류를 사용자로부터 입력받아 저장하는 변수
		 
		FireEngine f = new FireEngine(); // FireEngine 형 객체 생성
		Ambulance a = new Ambulance(); // Ambulance 형 객체 생성
		PoliceCar p = new PoliceCar(); // PoliceCar 형 객체 생성
		
		System.out.println("What kind of Emergency?"); // 무슨 종류의 비상상황인지 물어봄
		System.out.println("1.Fire     2.Patient     3.Thief     4.Record     5.End"); // 종류
		input = kbd.nextInt(); // 사용자의 답을 입력받음
		
		while(input != 5) { // 사용자가 입력한 값이 5가 아닌 경우 while문 반복
			switch(input) {
			case 1 : emg.EM_Call(f); break; // FireEngine의 경우
			case 2 : emg.EM_Call(a); break; // Ambulance의 경우
			case 3 : emg.EM_Call(p); break; // Police의 경우
			case 4 : emg.EM_record(); break; // 그동안의 모든 기록 출력
			default: System.out.println("Wring Input"); break; // 그 이외의 경우 잘못된 인풋이라는 정보를 출력
			}
			
			System.out.println("What kind of Emergency?");
			System.out.println("1.Fire     2.Patient     3.Thief     4.Record     5.End");
			input = kbd.nextInt(); // 사용자의 답을 입력받음
		}
		System.out.println("Finished");
	}
}
