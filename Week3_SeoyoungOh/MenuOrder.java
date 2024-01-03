
public class MenuOrder {
	private int cokePrice; // 콜라 가격
	private int lemonadePrice; // 레모네이드 가격
	private int coffeePrice; // 커피 가격
	private int inputMoney; // 사용자가 넣은 돈의 값
	private String drinkSelected; // 사용자가 선택한 음료
	
	public void setMoney (int inputMoney) { // 사용자가 넣은 돈을 저장
		this.inputMoney = inputMoney;
	}
	public void setPrice(String drink, int price) { // 콜라, 레모네이드, 커피 가격을 입력받아 저장
		if (drink.equals("coke"))
			cokePrice=price; // 콜라 가격 저장
		else if (drink.equals("lemonade"))
			lemonadePrice=price; // 레모네이드 가격 저장
		else
			coffeePrice=price; // 커피 가격 저장
	}
	public void showMenu() { // 사용자가 저장한 콜라, 레모네이드, 커피 가격을 출력해주는 메소드
		System.out.println("1. Coke: " + cokePrice);
		System.out.println("2. Lemonade: " + lemonadePrice);
		System.out.println("3. Coffee: " + coffeePrice);
	}
	public void showResult(int choice) { // 사용자의 선택에 따라 결과를 출력
		if(choice==1) { // 콜라를 선택한 경우
			drinkSelected="Coke"; 
			System.out.println(drinkSelected + "을 선택하셨습니다.");
			if(inputMoney >= cokePrice) // 돈이 음료 가격보다 많은 경우
				System.out.println("잔돈은 " + (inputMoney-cokePrice) + "원입니다.");
			else // 돈이 음료 가격보다 적은 경우
				System.out.println((cokePrice-inputMoney) + "원 더 넣어주세요.");
		}
		else if(choice==2) { // 레모네이드를 선택한 경우
			drinkSelected="Lemonade";
			System.out.println(drinkSelected + "을 선택하셨습니다.");
			if(inputMoney >= lemonadePrice)// 돈이 음료 가격보다 많은 경우
				System.out.println("잔돈은 " + (inputMoney-lemonadePrice) + "원입니다.");
			else// 돈이 음료 가격보다 적은 경우
				System.out.println((lemonadePrice-inputMoney) + "원 더 넣어주세요.");
		}
		else if(choice==3) { // 커피를 선택한 경우
			drinkSelected="Coffee";
			System.out.println(drinkSelected + "을 선택하셨습니다.");
			if(inputMoney >= coffeePrice)// 돈이 음료 가격보다 많은 경우
				System.out.println("잔돈은 " + (inputMoney-coffeePrice) + "원입니다.");
			else// 돈이 음료 가격보다 적은 경우
				System.out.println((coffeePrice-inputMoney) + "원 더 넣어주세요.");
		}
		else { // 그 외의 숫자를 입력한 경우
			System.out.println("없는 메뉴를 선택하셨습니다.");
		}
	}
}
