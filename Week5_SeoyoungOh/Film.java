
public class Film extends Production {
	private int boxOfficeGross;
	
	public int getBoxOfficeGross() {
		return boxOfficeGross; // 박스오피스그로스 리턴
	}
	public void setBoxOfficeGross(int boxOfficeGross) {
		this.boxOfficeGross=boxOfficeGross; // 박스오피스그로스 값 저장
	}
	
	public void display() {
		super.display(); // 부모 클래스인 Production의 display 메서드 호출
		System.out.println("boxOfficeGross:"+boxOfficeGross);
	}
}
