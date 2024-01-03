import java.util.*;

class SharedArea{
	double ratio; //Front Ratio 저장
	boolean isReady; // 준비되었는지 상태 저장(초기값은 fault)
}

class SimulThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Input the number of coin toss:");
		int N = kbd.nextInt(); // 사용자에게 입력을 받음
		int result; // 앞면이 나오거나 뒷면이 나온 결과
		int count=0; //앞면이 나온 횟수
		
		for(int i=0; i<N; i++) { //N회 반복
			result = (int)Math.round(Math.random()); // 동전을 던짐
			
			//앞면이 나온 경우 1로 인식, 뒷면이 나온 경우 0으로 인식
			if(result == 1) {
				count++; // 앞면이 나온 횟수를 1 더함.
			}
		}
		
		sharedArea.ratio=((double)count/N)*100; // ratio를 계산함

		sharedArea.isReady=true; // 상태를 true로 바꿈.
		synchronized(sharedArea) { //synchronizaion을 통해 구현
			sharedArea.notify();// 모두 완료되었다는 신호를 전해줌.
		}
	}
}

class PrintThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		if(sharedArea.isReady != true) {
			try {
			synchronized(sharedArea) {//synchronizaion을 통해 구현
				sharedArea.wait(); // true 신호가 올 때까지 기다림
			}
			}
			catch(InterruptedException e) { //에러 캐치
				System.out.println(e.getMessage());
			}
		}
		System.out.print("Front Ratio: "+Math.round(sharedArea.ratio*100)/100.0+"%"); // 비율 출력

	}	
}

public class Week13_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		SimulThread th1 = new SimulThread(); // 객체 생성
		PrintThread th2 = new PrintThread();// 객체 생성
		SharedArea SH = new SharedArea();// 객체 생성
		
		// Shared Area를 이용한 데이터 교환
		th1.sharedArea = SH;
		th2.sharedArea = SH;
		
		th1.start(); // th1 시작
		th2.start(); // th2 시작

	}

}
