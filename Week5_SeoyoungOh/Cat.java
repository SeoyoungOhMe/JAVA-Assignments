
public class Cat extends Pet{
	private String color;
	
	public void writeOutput()
	{
		super.writeOutput(); // Pet 클래스의 writeOutput 메서드를 호출함
		System.out.println("Color: "+ color); // color 출력
	}
	public void setColor(String color) {
		this.color=color; // color 저장
	}
	public String getColor() {
		return color; // color 리턴
	}
	public void move() {
		System.out.println(super.getName() +" creeps and jumps"); // Pet클래스의 getName메서드 호출
	}

}
