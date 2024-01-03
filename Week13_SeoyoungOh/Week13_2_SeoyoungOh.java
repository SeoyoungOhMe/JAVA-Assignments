import javax.swing.JOptionPane;

class SharedArea1{ // Shared Area에 공유 자원을 저장함.
	String str; // str에 콘솔창에 출력하는 랜덤한 String을 저장함.
}

class MyThread1 extends Thread{ // 문자를 선택하고 콘솔창에 출력
	boolean stop; //초기값은 false
	SharedArea1 sharedArea; //Shared Area 사용
	
	public void run() {
		// 3글자 이상의 15 단어를 배열에 저장
		String[] strArr = new String[]{"cat", "dog","love","spring", "cake", "dog", "apple","juice","banana","shark","meat","milk","giant","tiny","hate"};
		int n; // 0~14까지의 랜덤한 숫자를 저장하는 변수
		
		for(int i=20;i>0;i--) { // 20초간 기회를 줌
			n=(int)(Math.random()*15); // 0~14까지의 랜덤한 숫자를 선택함
			
			String s = strArr[n]; // strArr에서 n번째 문자를 s에 저장
			System.out.println(s); // s를 콘솔창에 출력
			sharedArea.str=s; // Shared Area에도 저장함.
			
			try {
				sleep(1000); // 1초간 휴식
			}
			catch(InterruptedException e) { //에러 캐치
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("실패!");
	}
	public void setStop(boolean stop) { //stop시키는 메소드
		this.stop=stop;
	}
}

class MyThread2 extends Thread{ // JOptionPane 입력창
	boolean stop;//초기값은 false
	SharedArea1 sharedArea;//Shared Area 사용
	
	public void run() {
		AA:
		while(true) {
			String st = JOptionPane.showInputDialog("문자열 입력"); // JOptionPane에서 사용자로부터 입력받은 문자열
			System.out.println("<"+st+">을 입력하셨습니다."); // 사용자가 입력한 내용을 출력해줌
			
			if(sharedArea.str.equalsIgnoreCase(st)) { // st와 선택한 문자가 동일한 경우
				System.out.println("성공!"); //성공 메세지 출력
				System.out.println("Timer is stopped.");
				System.exit(0); // 프로그램 종료
			}
		}
	}
	
	public void setStop(boolean stop) { //stop시키는 메소드
		this.stop=stop;
	}
}

public class Week13_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		MyThread1 th1=new MyThread1(); // 객체 생성
		MyThread2 th2=new MyThread2(); // 객체 생성
		SharedArea1 SH =new SharedArea1(); // 객체 생성
		
		th1.sharedArea=SH; //공유 자원
		th2.sharedArea=SH; //공유 자원
		
		th1.start(); //시작
		th2.start(); //시작
		
		th1.setStop(true); //쓰레드 중지
		th2.setStop(true); //쓰레드 중지
	}

}
