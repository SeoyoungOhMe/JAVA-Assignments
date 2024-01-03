import java.awt.*;
import javax.swing.*;

class MyFrame2 extends JFrame{
	private JRadioButton RB1;
	private JRadioButton RB2;
	
	public MyFrame2() {
		setSize(350,200); // 사이즈 지정
		setTitle("Student Information"); // 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // BorderLayout으로 설정

		JLabel label = new JLabel("STUDENT INFORMATION"); // 레이블을 생성함.
		
		label.setHorizontalAlignment(JLabel.CENTER); // 레이블을 가운데 정렬함
		add(label, BorderLayout.NORTH); // 레이블을 맨 위에 배치함.
		
		JPanel panel1=new JPanel(); // 패널1 객체 생성
		JPanel panel2=new JPanel(); // gender를 위한 패널2 객체 생성
		
		panel1.setLayout(new GridLayout(4, 2)); // GridLayout으로 총 8칸을 생성
		
		panel2.setLayout(new FlowLayout());
		
		RB1= new JRadioButton("Male");
		RB2= new JRadioButton("Female", true); // Female을 초기값으로 설정함.
		panel2.add(RB1); // 패널2에 추가
		panel2.add(RB2); // 패널2에 추가
		ButtonGroup bg = new ButtonGroup(); // 논리적 묶음으로 만듦.
		bg.add(RB1); // 추가함.
		bg.add(RB2); // 추가함.

		panel1.add(new JLabel("NAME")); // 이름
		panel1.add(new JTextField()); // 이름을 적을 수 있는 칸
		panel1.add(new JLabel("GENDER")); // 성별
		panel1.add(panel2); // 성별을 선택할 수 있는 패널2
		panel1.add(new JLabel("ID")); // 아이디
		panel1.add(new JTextField()); // 아이디를 적을 수 있는 칸
		panel1.add(new JLabel("DEPARTMENT")); // 주소
		panel1.add(new JTextField()); // 주소를 적을 수 있는 칸
		
		add(panel1, BorderLayout.CENTER); // 패널1은 센터에 위치함.
		
		JPanel panel3=new JPanel(); // Save와 Cancel 버튼을 위한 패널3 객체 생성
		// 버튼 만들기
		JButton b1=new JButton("Save");
		JButton b2=new JButton("Cancel");
		//버튼을 패널3에 추가
		panel3.add(b1);
		panel3.add(b2);
		
		add(panel3, BorderLayout.SOUTH);// 맨 아래에 위치함.
		
		pack();
		setVisible(true); // 화면에 보이도록 함.
	}

}

public class Week11_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		MyFrame2 f = new MyFrame2(); // 객체 생성

	}

}
