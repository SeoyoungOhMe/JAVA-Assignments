
public class Play extends Production {
	private int performanceCost;
	
	public int getPerformanceCost() {
		return performanceCost; // 퍼포먼스값 리턴
	}
	public void setPerformanceCost(int performanceCost) {
		this.performanceCost = performanceCost; // 퍼포먼스 값 저장
	}
	public void display() {
		super.display(); // 부모 클래스인 Production의 display 메서드 호출
		System.out.println("performance cost:"+performanceCost);
	}

}
