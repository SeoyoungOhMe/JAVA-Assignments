import java.util.Scanner;

class Song{
	public String title; // 곡명
	public String singer; // 가수명
	public int price; // 가격
	
	Song(){} // 디폴트 생성자
	Song(String title, int price){ // 사용자가 가수명을 입력하지 않은 경우의 생성자
		this(title, "모름", price); // 아래의 생성자를 호출함.
	}
	Song(String title, String singer, int price){ // 사용자가 가수명을 입력한 경우의 생성자
		this.title=title; // 곡명 저장
		this.singer=singer; // 가수명 저장
		this.price=price; // 가격 저장
	}
	public void play() {
		System.out.println(title + " by " + singer);
	}
}

public class Week4_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Song s; // Song 참조변수 선언
		String title, singer; // 곡명과 가수명 선언
		int price, num; // 가격과 노래 듣는 횟수 선언
		int total; // 사용자가 내야 하는 가격 선언
		
		Scanner kbd= new Scanner(System.in);
		System.out.println("*Song 정보*");
		System.out.print("곡명:");
		title=kbd.nextLine(); // 곡명 초기화
		while(title.equals("")) { // 곡명을 입력하지 않은 경우
			System.out.println("곡명은 반드시 필요합니다.");
			System.out.print("곡명:");
			title=kbd.nextLine(); // 곡명 초기화
		}
		System.out.print("가수명:");
		singer=kbd.nextLine(); // 가수명 초기화
		
		System.out.print("가격:");
		price=kbd.nextInt(); // 가격 초기화
		System.out.println("몇번 들으시겠습니까?");
		num=kbd.nextInt(); // 노래 듣는 횟수 초기화
		
		if(singer.equals("")) { // 사용자가 가수명을 입력하지 않은 경우
			s=new Song(title, price);
		}else { // 사용자가 가수명을 입력한 경우
			s=new Song(title, singer, price);
		}
		
		for(int i=0; i<num; i++) {
			s.play(); // 노래 재생
		}
		
		total=price*num; // 총 금액 계산
		System.out.println("총 " + total + "원입니다."); // 총 내야하는 금액 출력
	}

}
