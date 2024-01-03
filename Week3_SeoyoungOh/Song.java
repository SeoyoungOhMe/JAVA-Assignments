
public class Song {
	public String title; // 곡명 변수
	public String singer; // 가수명 변수
	public int price; // 가격 변수
	
	public void price() { // 가격을 출력해주는 메소드
		System.out.println(price + "원입니다.");
	}
	public void play() { // 사용자가 선택한 노래의 곡명과 가수명을 출력해주는 메소드
		System.out.println("노래들어요: \"" + title + "\" by " + singer);
	}

}
