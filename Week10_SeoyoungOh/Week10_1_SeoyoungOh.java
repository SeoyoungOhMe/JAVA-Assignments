import java.util.*;

class Student{
	String name;
	String ID;
	int age;
	
	public Student(String name, String ID, int age) { // 생성자
		this.name=name;
		this.ID=ID;
		this.age=age;
	}
	
}

public class Week10_1_SeoyoungOh {
	
	public static void printResult(List<Student> student) {
		System.out.println("NUMBER\tNAME\tID\tAGE"); // 목차
		for(int i=0;i<student.size();i++) { // 모든 학생 정보 출력
			System.out.println((i+1)+"\t"+student.get(i).name+"\t"+student.get(i).ID+"\t"+student.get(i).age);
		}
	}
	
	public static void deleteStudent(List<Student> Stu) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Input Student Number to delete.");
		
		int location;
		location=kbd.nextInt(); // 제거하고 싶은 객체의 인덱스를 입력받음

		Stu.remove(location-1); // 입력받은 위치에서 하나 뺀 인덱스 객체를 제거해야 함
	}
	
	public static void addStudent(List<Student> Stu) {
		Scanner kbd=new Scanner(System.in);
		String name;
		String ID;
		int age;
		int location; // 추가하고 싶은 인덱스를 입력받기 위한 변수
		
		System.out.println("Input Student Name, ID, and age, and the location");
		// 순서대로 입력받음
		name=kbd.next();
		ID=kbd.next();
		age=kbd.nextInt();
		location=kbd.nextInt();
		
		Stu.add(location-1, new Student(name, ID, age)); // 입력받은 위치에서 1 뺀 인덱스에 새로운 객체 추가
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd=new Scanner(System.in);
		ArrayList <Student> std = new ArrayList<Student>();
		System.out.println("Input Student Name, ID, and age. 0 for name to quit.");
		int input; // 사용자로부터 1~4까지 입력받는 변수
		
		String name;
		String ID;
		int age;
		
		AA: // 이중 반복문을 빠져나오기 위함
		while(true) {
			name=kbd.next(); // 이름을 입력받음
			
			if(name.equals("0")) { // 0을 입력받는 경우
				break AA; // 이중 반복문 탈출
			}
			// 아이디와 나이 입력받음
			ID=kbd.next();
			age=kbd.nextInt();

			std.add(new Student(name, ID, age)); // 새로운 객체 추가
		}
		
		printResult(std); // 전체 목록을 출력
		
		while(true) {
			System.out.println();
			System.out.println("Choose the operation you want.");
			System.out.println("1.add information 2. delete information 3. show list 4. Finish program");
			input=kbd.nextInt();
			try {
				
				if(input==4) {
					break; // 프로그램 끝냄
				}
				else if(input==3) {
					printResult(std); // 목록 전체 출력
				}
				else if(input==2) { // 삭제하는 메소드 실행
					deleteStudent(std); 
					printResult(std);
				}
				else if(input==1){ // 추가하는 메소드 실행
					
					addStudent(std);
					printResult(std);
				}
				else {
					throw new Exception("Wrong input."); // 1~4 이외의 숫자를 입력한 경우 예외 처리
				}
			}
			
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
