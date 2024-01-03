import java.awt.*;
import javax.swing.*;

class MyFrame1 extends JFrame{
	
	public void makeButton(String text, JPanel panel) {
		JButton button=new JButton(text); // 버튼 생성
		panel.add(button); // 버튼을 패널에 추가
	}
	
	public MyFrame1() {
		setSize(300,200); // 사이즈 설정
		setTitle("Calculator"); // 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel panel=new JPanel(); // 패널 객체 생성
		
		setLayout(new BorderLayout()); // BorderLayout로 지정
		
		JTextField field = new JTextField(); // field 객체 생성
		add(field, BorderLayout.NORTH); // 맨 위에 field를 추가함.
		field.setHorizontalAlignment(JTextField.RIGHT); // 데이터 오른쪽에 나타나게 함
		
		panel.setLayout(new GridLayout(5,4)); // 패널에 20칸의 GridLayout 추가
		
		//버튼을 추가함.
		makeButton("ON", panel);
		makeButton("AC", panel);
		makeButton("C", panel);
		makeButton("OFF", panel);
		makeButton("7", panel);
		makeButton("8", panel);
		makeButton("9", panel);
		makeButton("/", panel);
		makeButton("4", panel);
		makeButton("5", panel);
		makeButton("6", panel);
		makeButton("X", panel);
		makeButton("1", panel);
		makeButton("2", panel);
		makeButton("3", panel);
		makeButton("-", panel);
		makeButton("0", panel);
		makeButton(".", panel);
		makeButton("=", panel);
		makeButton("+", panel);
		
		add(panel); // 프레임에 패널 추가
		pack(); 
		setVisible(true); // 화면에 나타냄
	}
}
public class Week11_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		MyFrame1 f = new MyFrame1(); // 객체 생성

	}

}
