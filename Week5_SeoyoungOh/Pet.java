
public class Pet {
	private String name;
	private int age;
	private double weight;
	
	public void writeOutput() {
		System.out.println("Name: "+ name); // 이름 출력
		System.out.println("Age: "+ age); // 나이 출력
		System.out.println("Weight: "+ weight); // 몸무게 출력
		
	}
	public void setPet(String name, int age, double weight) {
		this.name = name; // 이름 저장
		this.age = age; // 나이 저장
		this.weight= weight; // 몸무게 저장
	}
	public void setName(String name) {
		this.name = name;// 이름 저장
	}
	public void setAge(int age) {
		this.age = age;// 나이 저장
	}
	public void setWeight(double weight) {
		this.weight= weight;// 몸무게 저장
	}
	public String getName() {
		return name; // 이름 리턴
	}
	public int getAge() {
		return age;// 나이 리턴
	}
	public double getWeight() {
		return weight;// 몸무게 리턴
	}
	public void move() {
		System.out.println(name +" moves"); // moves로 출력
	}
}
