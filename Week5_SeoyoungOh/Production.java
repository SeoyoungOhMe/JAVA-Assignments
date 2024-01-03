
public class Production {
	private String title;
	private String director;
	private String writer;
	
	public String getTitle() {
		return title; // 타이틀 리턴
	}
	public String getDirector() {
		return director; // 디렉터 리턴
	}
	public String getWriter() {
		return writer; // 작가 리턴
	}
	public void setTitle(String title) {
		this.title=title; // 타이틀 값 저장
	}
	public void setDirector(String director) {
		this.director=director; // 디렉터 정보 저장
	}
	public void setWriter(String writer) {
		this.writer=writer; // 작가 정보 저장
	}
	public void display() {
		System.out.println("Title:"+title); // 타이틀 출력
		System.out.println("Director:"+director); // 디렉터 출력
		System.out.println("Writer:"+writer); // 작가 출력
	}
}
