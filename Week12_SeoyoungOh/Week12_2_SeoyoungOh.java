import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ColorFrame extends JFrame implements ActionListener{
	
	Color color=new Color(255,0,0);//초기 자체 색깔을 빨강색으로 지정

	JRadioButton rb1;//RED를 위한 라디오버트
	JRadioButton rb2;//GREEN을 위한 라디오버튼
	JRadioButton rb3;//BLUE를 위한 라디오버튼
	JButton b;//Paint를 위한 버튼
	
	ColorFrame(){ //생성자

		setLayout(new BorderLayout()); // 레이아웃 형식 지정
		setTitle("MyCar - 오서영");//타이틀
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Toolkit tk=getToolkit();
		Dimension d=tk.getScreenSize();//스크린의 가로, 세로 크기를 얻어옴
		int screenHeight=d.height;//스크린의 높이 저장
		int screenWidth=d.width;//스크린의 가로 길이 저장
		setSize(500,350);//프레임의 크기 지정함
		setLocation(screenWidth/2-this.getWidth()/2,screenHeight/2-this.getHeight()/2);//프레임을 모니터 정중앙에 위치
			
		JPanel p=new JPanel();//패널 생성
		p.setLayout(new FlowLayout());
		rb1=new JRadioButton("RED",true); // 초기에 선택된 라디오 버튼은 레드
		rb2=new JRadioButton("GREEN"); // 그린 라디오 버튼 객체 생성
		rb3=new JRadioButton("BLUE"); // 블루 라디오 버튼 객체 생성
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);
		ButtonGroup bg=new ButtonGroup();//라디오 버튼들을 그룹화함
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);

		b=new JButton("Paint");//버튼 생성
		b.addActionListener(this);
		p.add(b);//버튼을 패널에 붙임
		
		MyPanel mp=new MyPanel();//MyPanel 객체 생성

		add(mp,BorderLayout.CENTER);//센터에 자동차를 위치시킴
		add(p,BorderLayout.SOUTH);//라디오버튼과 페인트 버튼이 모여있는 패널을 아래쪽에 위치시킴
		setVisible(true);
		
	}
	class MyPanel extends JPanel{
		public void paint(Graphics g) {
			g.setColor(color);
			g.fillRect(140,60,140,60);//상단 사각형 그림
			g.fillRect(70,120,280,100);//하단 사각형 그림
			
			Color c1=new Color(192,192,192);//lightGray
			g.setColor(c1);
			g.fillOval(105,170,70,70);//왼쪽 바퀴 그림
			g.fillOval(220,170,70,70);//오른쪽 바퀴 그림
			
			Color c2=new Color(0,0,0);//검은색
			g.setColor(c2);
			g.drawArc(220,70,60,60,0,180);//눈 그림
			
		}
		
	}
	public void actionPerformed(ActionEvent e) {

		if(rb1.isSelected()) {//첫 번째 라디오 버튼이 선택된 경우
			color=new Color(255,0,0);//빨간색
		}
		else if(rb2.isSelected()) {//두 번째 라디오 버튼이 선택된 경우
			color=new Color(0,255,0);//초록색
		}
		else {//세 번째 라디오 버튼이 선택된 경우
			color=new Color(0,0,255);//파란색
		}
		repaint();
	}
}
public class Week12_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		new ColorFrame(); //ColorFrame 객체 생성
	}
}
