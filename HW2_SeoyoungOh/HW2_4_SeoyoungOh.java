import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class PieChart extends JFrame implements ActionListener{
	
	private JPanel p1; // Center panel로, pie chart와 각 성 및 수를 표시하고 하단에 메시지 표시
	private JPanel p2; // South panel로, 각 성 및 수를 사용자가 입력할 수 있는 textfield와 Graph button 표시
	private MyPanel p; // Graph 버튼을 누르면 pie chart와 문자열을 화면에 표시해주는 panel
	
	private JTextField textKim; // Kim의 수를 입력받는 textField
	private JTextField textLee; // Lee의 수를 입력받는 textField
	private JTextField textPark; // Park의 수를 입력받는 textField
	private JTextField textEtc; // Etc의 수를 입력받는 textField
	private JButton button; // pie chart를 띄울 수 있는 graph button
	private JLabel l; // p1의 하단에 표시되는 메시지
	
	private int nKim; // 사용자로부터 입력받은 Kim의 수
	private int nLee; // 사용자로부터 입력받은 Lee의 수
	private int nPark; // 사용자로부터 입력받은 Park의 수
	private int nEtc; // 사용자로부터 입력받은 Etc의 수
	private int total; // 모든 성별의 총합
	
	private double aKim; // 360도를 기준으로 구한 Kim의 수의 비율
	private double aLee; // 360도를 기준으로 구한 Lee의 수의 비율
	private double aPark; // 360도를 기준으로 구한 Park의 수의 비율
	private double aEtc; // 360도를 기준으로 구한 Etc의 수의 비율
	
	PieChart(){
		
		/*** Toolkit을 이용해 Frame을 스크린의 중앙에 위치하도록 함 ***/
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(500,400);
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2);	
		
		/*** 기본 설정 ***/
		setTitle("Pie Chart of Student names - 오서영");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*** 프레임의 레이아웃을 BorderLayout으로 설정함. ***/
		setLayout(new BorderLayout());
		
		/*** p1에 대한 설정 ***/
		p1 = new JPanel();
		p1.setLayout(new BorderLayout()); // BorderLayout으로 레이아웃 지정
		p1.setBackground(Color.white);
		
		l = new JLabel("Input numbers of names(0~100).");
		
		l.setBorder(BorderFactory.createEmptyBorder(0,0,25,0)); // 하단에 여백을 줌
		l.setHorizontalAlignment(JLabel.CENTER); // 수평 중앙 배치
		l.setForeground(Color.blue);
		p1.add(l, BorderLayout.SOUTH);
		
		/*** p2에 대한 설정 ***/
		p2 = new JPanel();
		
		JLabel labelKim = new JLabel("Kim");
		textKim = new JTextField(5);
		
		JLabel labelLee = new JLabel("Lee");
		textLee = new JTextField(5);
		
		JLabel labelPark = new JLabel("Park");
		textPark = new JTextField(5);
		
		JLabel labelEtc = new JLabel("Etc");
		textEtc = new JTextField(5);
		
		button = new JButton("Graph");
		
		// ActionListener와 연결
		button.addActionListener(this);
		
		/*** p2에 textField과 label, button을 추가함. ***/
		p2.add(labelKim);
		p2.add(textKim);
		p2.add(labelLee);
		p2.add(textLee);
		p2.add(labelPark);
		p2.add(textPark);
		p2.add(labelEtc);
		p2.add(textEtc);
		
		p2.add(button);
		
		/*** 프레임에 p1과 p2를 추가함 ***/
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paint(Graphics g) {
			//각 성 별로 색을 지정한 후 차트를 그리고 문자열 출력하는 함수
			
			//Orange:Kim
			g.setColor(Color.orange);
			g.fillArc(150,100, 150, 150, 0, (int)aKim);
			g.drawString("ORANGE: KIMs("+ nKim +")", 330, 130);
			
			//Red:Lee
			g.setColor(Color.red);
			g.fillArc(150,100, 150, 150, (int)aKim, (int)aLee);
			g.drawString("RED: LEEs("+ nLee +")", 330, 150);
			
			//Blue:Park
			g.setColor(Color.blue);
			g.fillArc(150,100, 150, 150, (int)(aKim+aLee), (int)aPark);
			g.drawString("BLUE: PARKs("+ nPark +")", 330, 170);
			
			//Green:Etc
			g.setColor(Color.green);
			g.fillArc(150,100, 150, 150, (int)(aKim+aLee+aPark), (int)aEtc);
			g.drawString("GREEN: ETC("+ nEtc +")", 330, 190);
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			/*** 사용자로부터 각 성별로 수를 입력받아 변수에 저장 ***/
			nKim = Integer.parseInt(textKim.getText());
			nLee = Integer.parseInt(textLee.getText());
			nPark = Integer.parseInt(textPark.getText());
			nEtc = Integer.parseInt(textEtc.getText());	

		}catch(NumberFormatException e1) { // 입력값이 숫자 형태가 아닌 경우
			l.setText("Number should be 0~100.");
			return; // actionPerformed 메서드 탈출
		}
		

		if((nKim<0 || nKim>100) || (nLee<0 || nLee>100) ||(nPark<0 || nPark>100) ||(nEtc<0 || nEtc>100)) {
			l.setText("Number should be 0~100."); // 입력값이 범위 밖인 경우
		}
		else {
			total = nKim+nLee+nPark+nEtc; // 모든 학생의 수를 구함
			
			// 성별 비율을 360도 기준으로 계산함
			aKim = (double)nKim/total*360;
			aLee = (double)nLee/total*360;
			aPark = (double)nPark/total*360;
			aEtc = (double)nEtc/total*360;
			
			// 사용자로부터 정상적인 수를 입력받은 경우에만 pie chart와 문자열을 보여주기 위해 panel을 여기서 추가.
			p = new MyPanel();
			p1.add(p,BorderLayout.CENTER);
			
			// 하단의 메시지 내용 변경
			l.setText("Total number of students is "+ total);
			
			// 버튼 누른 후 화면이 바뀜
			repaint();
		}
	}
}

public class HW2_4_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**********
		전공: 사이버보안
		학번: 2171070
		성명: 오서영
		**********/
		
		new PieChart(); // 실행

	}

}
