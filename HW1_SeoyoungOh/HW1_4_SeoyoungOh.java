import java.util.Scanner;

class StudentInformation{
	private String name;
	private String id;
	
	StudentInformation(){ } // 생성자
	
	public void display() {
		System.out.printf("%s\t%s\t",getName(), getID()); // 이름과 아이디 출력
	}
	public void setName(String name) {
		this.name=name; // 이름 저장
	}
	public void setID(String id) {
		this.id=id; // 아이디 저장
	}
	public String getName() {
		return name; // 이름 리턴
	}
	public String getID() {
		return id; // 아이디 리턴
	}
}

class StudentScore extends StudentInformation{
	private int korean;
	private int math;
	private int english;
	
	public void display() {
		super.display(); // StudentInformation 클래스의 display 메소드 호출
		System.out.printf("%d\t%d\t%d\t", getKorean(),getMath(), getEnglish()); // 모든 점수 출력
	}
	public void setKorean(int korean) { // 국어 점수 저장
		this.korean=korean;
	}
	public void setMath(int math) { // 수학 점수 저장
		this.math=math;
	}
	public void setEnglish(int english) { // 영어 점수 저장
		this.english=english;
	}
	public int getKorean() { // 국어 점수 리턴
		return korean;
	}
	public int getMath() { // 수학 점수 리턴
		return math;
	}
	public int getEnglish() { // 영어 점수 리턴
		return english;
	}
}

public class HW1_4_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		int studentNum; // 입력받는 학생 수를 저장할 변수
		int korSum=0, mathSum=0, engSum=0; // 국어, 수학, 영어 점수의 합 선언 및 초기화
		double korAvg, mathAvg, engAvg; // 국어, 수학, 영어 점수의 평균 점수 변수
		int[] sum; // 한 학생의 국어, 수학, 영어 점수를 모두 합친 값을 저장하는 변수
		StudentScore[] ss; // 배열 선언
		
		System.out.println("How many students are there?");
		studentNum = kbd.nextInt(); // 학생 수를 입력받음
		ss = new StudentScore[studentNum]; // 배열의 크기 저장하여 초기화
		sum = new int[studentNum];
		System.out.println("Input the information.");
		System.out.println();
		
		for(int i=0; i<studentNum; i++) {
			ss[i] = new StudentScore();
			System.out.print("ID:");
			ss[i].setID(kbd.next()); // 아이디 입력받아 저장
			kbd.nextLine();
			System.out.print("Name:");
			ss[i].setName(kbd.nextLine()); // 이름 입력받아 저장
			System.out.print("Korean:");
			ss[i].setKorean(kbd.nextInt()); // 국어 점수 입력받아 저장
			System.out.print("Math:");
			ss[i].setMath(kbd.nextInt()); // 수학 점수 입력받아 저장
			System.out.print("English:");
			ss[i].setEnglish(kbd.nextInt()); // 영어 점수 입력받아 저장
			System.out.println();
			sum[i]=ss[i].getKorean()+ss[i].getMath()+ss[i].getEnglish();// 세 과목의 점수를 모두 합함
			korSum += ss[i].getKorean(); // 국어 점수의 총합에 더함
			mathSum += ss[i].getMath(); // 수학 점수의 총합에 더함
			engSum += ss[i].getEnglish(); // 영어 점수의 총합에 더함
		}
		
		System.out.println("NAME\t\tID\tKOREAN\tMATH\tENGLISH\tSUM\tAVG");
		for(int i=0;i<studentNum;i++) {
			ss[i].display(); // StudentScore 클래스의 display 메소드 호출
			System.out.printf("%d\t%.2f",sum[i],((double)sum[i]/3)); // 한 학생의 세 과목 총점, 평균을 출력
			System.out.println();
		}
		korAvg=korSum/(double)studentNum; // 국어 점수 평균 계산
		mathAvg=mathSum/(double)studentNum; // 수학 점수 평균 계산
		engAvg=engSum/(double)studentNum; // 영어 점수 평균 계산
		System.out.printf("Subject Avg\t\t%.2f\t%.2f\t%.2f",korAvg, mathAvg, engAvg); // 세 과목의 평균 모두 출력
		System.out.println();
		System.out.println();
		
		System.out.println("<Students over the average>");
		
		System.out.println("\nKorean:");
		for(int i=0;i<studentNum; i++) { // 국어 점수가 평균 이상인 학생 이름 출력
			if(ss[i].getKorean()>=korAvg) {
				System.out.print(ss[i].getName()+" ");
			}
		}
		System.out.println("\nMath:");
		for(int i=0;i<studentNum; i++) {// 수학 점수가 평균 이상인 학생 이름 출력
			if(ss[i].getMath()>=mathAvg) {
				System.out.print(ss[i].getName()+"\t");
			}
		}
		System.out.println("\nEnglish:");
		for(int i=0;i<studentNum; i++) {// 영어 점수가 평균 이상인 학생 이름 출력
			if(ss[i].getEnglish()>=engAvg) {
				System.out.print(ss[i].getName()+"\t");
			}
		}
	}
}
