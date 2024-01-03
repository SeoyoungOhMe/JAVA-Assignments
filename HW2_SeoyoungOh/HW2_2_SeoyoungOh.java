import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyFrame1 extends JFrame implements ActionListener {
	private JTextField field; // 계산 결과 및 사용자로부터 입력받은 숫자, 연산자를 보여주는 textfield
	private String num1="initial"; // 첫 번째 수를 저장하는 변수
	private String num2=null; // 두 번째 수를 저장하는 변수
	private String operation = ""; // 연산자를 저장하는 변수
	
	public MyFrame1() {
		/*** 기본 설정 ***/
		setSize(300,200); // 사이즈 설정
		setTitle("Calculator"); // 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel panel=new JPanel(); // 패널 객체 생성
		
		setLayout(new BorderLayout()); // BorderLayout로 지정
		
		field = new JTextField(); // field 객체 생성
		add(field, BorderLayout.NORTH); // 맨 위에 field를 추가함.
		field.setHorizontalAlignment(JTextField.RIGHT); // 데이터 오른쪽에 나타나게 함
		
		panel.setLayout(new GridLayout(4,4)); // 패널에 20칸의 GridLayout 추가
		
		/*** 버튼을 추가함. ***/
		makeButton("7", panel);
		makeButton("8", panel);
		makeButton("9", panel);
		makeButton("/", panel);
		makeButton("4", panel);
		makeButton("5", panel);
		makeButton("6", panel);
		makeButton("*", panel);
		makeButton("1", panel);
		makeButton("2", panel);
		makeButton("3", panel);
		makeButton("-", panel);
		makeButton("New", panel);
		makeButton("0", panel);
		makeButton("=", panel);
		makeButton("+", panel);
		
		add(panel); // 프레임에 패널 추가
		pack(); 
		setVisible(true); // 화면에 나타냄
	}
	
	public void makeButton(String text, JPanel panel) {
		JButton button=new JButton(text); // 버튼 생성
		button.addActionListener(this); // 액션 추가
		panel.add(button); // 버튼을 패널에 추가
	}
	
	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand(); // 사용자의 액션을 인식하여 op에 저장
		
		if(op.equals("New")) {// textfield 내용을 지우고 새로운 계산을 시작
			field.setText("");
			
			/*** 변수 초기화 ***/
			num1="initial";
			num2="";
			operation="";
			
		} else if(op.equals("0")||op.equals("1")||op.equals("2")||op.equals("3")||op.equals("4")||op.equals("5")||op.equals("6")||op.equals("7")||op.equals("8")||op.equals("9")) {
			field.setText(op); // textfield에 사용자가 입력한 op을 출력하여 표시함.
			
			if(num1.equals("initial")) { // 첫 번째 수를 입력받은 경우
				num1 = op;
			}else { // 두 번째 수를 입력받은 경우
				num2 = op;
			}
			
		} else if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")) {
			// 연산자를 화면에 띄우고 operation 변수에 저장함.
			field.setText(op);
			operation = op;
			
		} else if(op.equals("=")) { // 연산 결과를 textfield 영역에 나타냄
			// String을 Integer로 변환하여 계산
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			
			try {
				if(operation.equals("+")) {
					int result=n1 + n2;
					field.setText(Integer.toString(result)); // 다시 문자열로 변환 후 나타냄
					
				}else if(operation.equals("-")) {
					int result=n1 - n2;
					field.setText(Integer.toString(result));// 다시 문자열로 변환 후 나타냄
					
				}else if(operation.equals("*")) {
					int result=n1 * n2;
					field.setText(Integer.toString(result));// 다시 문자열로 변환 후 나타냄
					
				}else { // operation.equals("/")와 같음
					double result=(double)n1 / n2;
					field.setText(Double.toString(result));// 다시 문자열로 변환 후 나타냄
					
				}
			}
			catch(ArithmeticException e1) { // 0으로 나누는 경우 예외처리
				System.out.println("Don't divide number with zero.");
			}
			
		}
		
	}
}

public class HW2_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**********
		전공: 사이버보안
		학번: 2171070
		성명: 오서영
		**********/
		
		MyFrame1 f = new MyFrame1(); // 객체 생성

	}

}
