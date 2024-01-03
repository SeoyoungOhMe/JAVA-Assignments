
public class Dog extends Pet{
	private Boolean boosterShot;
	
	public void writeOutput()
	{
		super.writeOutput(); // Pet 클래스의 writeOutput 메서드 호출
		String bs;
		if(boosterShot == true) // 부스터샷을 맞은 경우 bs는 O
			bs="0";
		else // 부스터샷을 맞지 않은 경우 bs는 X
			bs="X";
		System.out.println("BoosterShot: "+ bs);
	}
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot = boosterShot; // 부스터샷 맞았는지 여부 저장
	}
	public boolean getBoosterShot() {
		return boosterShot; // 부스터샷 맞았는지 여부 리턴
	}
	public void move() {
		System.out.println(super.getName() +" walks and runs"); // Pet의 getName 메서드를 호출
	}
}
