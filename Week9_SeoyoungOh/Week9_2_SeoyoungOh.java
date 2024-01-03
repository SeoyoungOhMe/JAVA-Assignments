import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.io.Serializable;

class Pet implements Serializable{
	private String name;
	private int age;
	private double weight;
	
	Pet(String name, int age, double weight){ // 생성자
		setPet(name, age, weight); // 함수 호출
	}
	public void setPet(String newName, int newAge, double newWeight) {
		setName(newName);
		setAge(newAge);
		setWeight(newWeight);
	}
	public void setName(String newName) {
		name=newName; // 이름 저장
	}
	public void setAge(int newAge) {
		age=newAge; // 나이 저장
	}
	public void setWeight(double newWeight) {
		weight=newWeight; // 무게 저장
	}
	public String getName() {
		return name; // 이름 리턴
	}
	public int getAge() {
		return age; // 나이 리턴
	}
	public double getWeight() {
		return weight; // 무게 리턴
	}
}

class Dog extends Pet implements Serializable{
	private String breed;
	private boolean boosterShot;
	
	Dog(String name, int age, double weight, String breed, boolean boosterShot){ // 생성자
		super(name, age, weight); // 부모 클래스의 생성자 호출
		setBreed(breed); // 함수 호출
		setBoosterShot(boosterShot); // 함수 호출
	}
	public void setBreed(String breed) {
		this.breed=breed; // breed 저장
	}
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot=boosterShot; // 부스터샷 여부 저장
	}
	public String getBreed() {
		return breed; // breed 리턴
	}
	public boolean getBoosterShot() {
		return boosterShot; //부스터샷 여부 리턴
	}
	public String toString() {
		String bs=null; // false, true가 아니라 X, O로 출력하기 위해 조건문 실행
		if(getBoosterShot()) { // true인 경우
			bs="O";
		}
		else { // false인 경우
			bs="X";
		}
		return getName()+"\t"+getAge()+"\t"+getWeight()+"\t"+getBreed()+"\t\t"+ bs; 
	}
}

public class Week9_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd = new Scanner(System.in);
		Dog myDog[] = new Dog[10]; // Dog형 배열 선언
		
		// 배열 객체 생성
		myDog[0] = new Dog("Merry", 3, 2.5, "Bulldog", false);
		myDog[1] = new Dog("JJong", 5, 5.5, "Mix", false);
		myDog[2] = new Dog("Kong", 4, 3, "Poodle", true);
		myDog[3] = new Dog("Apple", 2, 2.5, "Collie", true);
		myDog[4] = new Dog("Candy", 5, 5.5, "Coca", false);
		myDog[5] = new Dog("Cutie", 7, 2.5, "Chiwawa", true);
		myDog[6] = new Dog("Peace", 3, 2.5, "Huskey", false);
		myDog[7] = new Dog("Lion", 9, 1.5, "Shepard", true);
		myDog[8] = new Dog("Windy", 2, 9, "Jindo", true);
		myDog[9] = new Dog("Sweetie", 1, 2.5, "Maltiz", false);
		
		System.out.println("Input File name to write Dog data");
		String fileName = kbd.next(); // 파일 이름을 입력받음
		try {
			ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(myDog); // 파일에 Object를 씀 
			outputStream.close(); // 스트림 닫아 파일 완성
		}
		catch(IOException e) { // IOException 에러 처리
			System.out.println("Error writing to file "+fileName);
		}
		
		System.out.println("Name\tAge\tWeight\tBreed\t\tBoosterShot"); //카테고리 목차 출력
		
		Dog[] anotherDog = null; // anotherDog형 배열을 선언
		try {
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));//파일을 다시 엶
				anotherDog = (Dog[])inputStream.readObject(); // 파일의 전체 객체 readObject로 받음
				inputStream.close(); // 닫기
				
				for(int i=0; i<anotherDog.length;i++) {
					System.out.println(anotherDog[i]); // 전체 출력
				}
		}
		catch(EOFException e){// EOFException 예외 처리
			System.out.println("End of File Exception\n");
		}
		catch(FileNotFoundException e) { // FileNotFoundException 예외 처리
			System.out.println("File Not Found Exception\n");
		}
		catch(IOException e) { // IOException 예외 처리
			System.out.println("IO Exception\n");
		}
		catch(Exception e) { // Exception 예외 처리
			System.out.println("Exception\n");
		}
		
		System.out.println();
		
		System.out.println("Dogs older than 2 years and did not get the boosterShot.");
		
		for(int i=0; i<myDog.length;i++) { // myDog 전체를 확인함
			if(myDog[i].getAge()>2 && myDog[i].getBoosterShot()==false) { // 조건에 해당되는 경우
				System.out.println(myDog[i].getName()+"\t\t"+myDog[i].getBreed()); // 출력
			}
		}
		
		System.out.println();
		System.out.println("Program finished");
	}

}
