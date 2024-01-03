import java.util.Scanner;

class Time{
	private int hour;
	private int minute;
	
	private boolean isValid(int hour, int minute) { // 입력받은 시와 분의 범위가 유효한지 확인하는 메소드
		if(0<=hour && hour<24 && 0<=minute && minute<60) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setTime(int hour, int minute) {
		if(isValid(hour, minute)) { // 범위가 유효할 경우 값을 저장함
			this.hour = hour;
			this.minute = minute;
		}
		else {
			System.out.println("Wrong Input"); // 범위가 잘못된 경우 저장하지 않음
		}
	}
	public int getHourOrMinute(char ch) {
		if(ch=='h' || ch=='H') {// h나 H를 매개인자로 받은 경우 hour를 리턴
			return hour;
		}else {
			return minute;
		}
	}
}

public class HW1_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd= new Scanner(System.in);
		int h, m; // 사용자에게 hour와 minute을 입력받음
		Time t = new Time(); // Time형 인스턴스 생성
		
		System.out.println("Hour:");
		h=kbd.nextInt(); // 시 입력받음
		System.out.println("Minute:");
		m = kbd.nextInt(); // 분 입력받음
		
		t.setTime(h, m);// 시와 분을 저장함
		System.out.println(t.getHourOrMinute('h')+":"+t.getHourOrMinute('m'));
		
	}

}
