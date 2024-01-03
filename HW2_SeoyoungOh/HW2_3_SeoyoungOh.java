import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Student{
	String id; // 아이디
	String name; // 이름
	int gender; // 0: male, 1: female
	String dept; // 주소 저장
	
	Student(String id, String name, int gender, String dept){ //생성자
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.dept=dept;
	}
}

class OutputFrame extends JFrame { // OutputFrame은 result 버튼을 눌렀을 때의 결과 화면
	
	public OutputFrame(HashMap<String, Student> hm) { // 해시맵을 인자로 받음
		
		/*** 기본 설정 ***/
		setSize(300,200); // 사이즈 지정
		setTitle("Student List"); // 이름 설정
		setLocation(0, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // x 버튼을 누르면 OutputFrame만 닫히고 InputFrame은 닫히지 않음
		
		String str; // iterator 값을 임시로 저장하는 변수
		
		/*** 패널 설정 ***/
		JPanel panel;
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,4)); // 그리드 레이아웃으로 설정
		
		panel.add(new JLabel("ID"));
		panel.add(new JLabel("NAME"));
		panel.add(new JLabel("GENDER"));
		panel.add(new JLabel("DEPARTMENT"));
		
		/*** iterator를 이용해 해시맵의 정보를 출력 ***/
		Set<String> s=hm.keySet(); // 키를 Set s에 저장
		Iterator<String> it=s.iterator(); // iterator 사용
		
		while(it.hasNext()) {
			str=it.next();
			
			Student std = hm.get(str);// std에 저장
			
			// id
			JLabel labelId = new JLabel(std.id);
			panel.add(labelId);
			
			// name
			JLabel labelName = new JLabel(std.name);
			panel.add(labelName);
			
			// gender
			JLabel labelGender;
			if(std.gender == 0) {
				labelGender = new JLabel("Male");
			}else {
				labelGender = new JLabel("Female");
			}
			panel.add(labelGender);
			
			// dept
			JLabel labelDept = new JLabel(std.dept);
			panel.add(labelDept);
			
		}
		
		add(panel); // 프레임에 패널 추가
		setVisible(true); // 화면에 보이도록 함.
		
	}
	
}

class InputFrame extends JFrame implements ActionListener{ // InputFrame은 초기 화면으로, 사용자에게 입력을 받음
	private JRadioButton RB1; // Male
	private JRadioButton RB2; // Female
	private JTextField idText = new JTextField(); // id 입력
	private JTextField nameText = new JTextField(); // name 입력
	private JTextField deptText = new JTextField(); // dept 입력

	HashMap<String, Student> hm = new HashMap<String, Student>(); // 해시맵 초기화
	
	public InputFrame() {
		setSize(300,200); // 사이즈 지정
		setTitle("New Student"); // 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료
		
		setLayout(new BorderLayout()); // BorderLayout으로 설정

		JLabel label = new JLabel("New Student"); // 레이블을 생성함.
		
		label.setHorizontalAlignment(JLabel.CENTER); // 레이블을 가운데 정렬함
		add(label, BorderLayout.NORTH); // 레이블을 맨 위에 배치함.
		
		JPanel panel1=new JPanel(); // 패널1 객체 생성
		JPanel panel2=new JPanel(); // gender를 위한 패널2 객체 생성
		
		panel1.setLayout(new GridLayout(4, 2)); // GridLayout으로 총 8칸을 생성
		
		panel2.setLayout(new FlowLayout());
		
		RB1= new JRadioButton("M");
		RB2= new JRadioButton("F", true); // Female을 초기값으로 설정함.
		panel2.add(RB1); // 패널2에 추가
		panel2.add(RB2); // 패널2에 추가
		ButtonGroup bg = new ButtonGroup(); // 논리적 묶음으로 만듦.
		bg.add(RB1); // 추가함.
		bg.add(RB2); // 추가함.
		
		panel1.add(new JLabel("ID")); // 아이디
		panel1.add(idText); // 아이디를 적을 수 있는 칸
		panel1.add(new JLabel("NAME")); // 이름
		panel1.add(nameText); // 이름을 적을 수 있는 칸
		panel1.add(new JLabel("GENDER")); // 성별
		panel1.add(panel2); // 성별을 선택할 수 있는 패널2
		panel1.add(new JLabel("DEPT")); // 주소
		panel1.add(deptText); // 주소를 적을 수 있는 칸
		
		add(panel1, BorderLayout.CENTER); // 패널1은 센터에 위치함.
		
		JPanel panel3=new JPanel(); // Save와 Cancel 버튼을 위한 패널3 객체 생성
		
		// 버튼 만들기
		JButton b1=new JButton("save");
		JButton b2=new JButton("cancel");
		JButton b3=new JButton("result");
		
		// actionLister 설정
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		//버튼을 패널3에 추가
		panel3.add(b1);
		panel3.add(b2);
		panel3.add(b3);
		
		add(panel3, BorderLayout.SOUTH);// 맨 아래에 위치함.
		
		setVisible(true); // 화면에 보이도록 함.
	}
	
	public void actionPerformed(ActionEvent e) {
		String bt = e.getActionCommand();
		
		if(bt.equals("save")) { // HashMap에 입력한 정보 저장하기
			
			if(RB1.isSelected()) { // Male이 선택된 경우
				hm.put(idText.getText(), new Student(idText.getText(), nameText.getText(), 0, deptText.getText()));
			} 
			else if(RB2.isSelected()) { // Female이 선택된 경우
				hm.put(idText.getText(), new Student(idText.getText(), nameText.getText(), 1, deptText.getText()));
			}
			
			/*** 초기화면 상태 보여주기 ***/
			idText.setText("");
			nameText.setText("");
			deptText.setText("");
			RB1.setSelected(false);
			RB2.setSelected(true);	
			
		}else if(bt.equals("cancel")) { // 입력데이터를 저장하지 않고 초기화면이 됨
			
			/*** 초기화면 상태 보여주기 ***/
			idText.setText("");
			nameText.setText("");
			deptText.setText("");
			RB1.setSelected(false);
			RB2.setSelected(true);
		
		} else if(bt.equals("result")) { // 입력창 하단에 결과창이 나타나서 저장된 내용 보여주기
			
			new OutputFrame(hm); // OutputFrame 생성자를 호출하면서 인자로 hashmap을 보낼 것
			
			/*** 초기화면 상태 보여주기 ***/
			idText.setText("");
			nameText.setText("");
			deptText.setText("");
			RB1.setSelected(false);
			RB2.setSelected(true);
		}
		
	}

}

public class HW2_3_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**********
		전공: 사이버보안
		학번: 2171070
		성명: 오서영
		**********/
		
		InputFrame f = new InputFrame(); // 객체 생성
		
	}

}
