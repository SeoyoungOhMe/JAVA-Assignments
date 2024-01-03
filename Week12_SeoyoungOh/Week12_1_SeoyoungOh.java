import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Week12_1_SeoyoungOh {
	JFrame f=new JFrame();//프레임 객체 생성
	JPanel p=new JPanel();//패널 객체 생성
	JButton b=new JButton("Click!");//클릭 버튼 객체 생성
	
	public Week12_1_SeoyoungOh() {
		f.setTitle("나 잡아봐~라!-오서영");//프레임 타이틀
		f.setSize(300,300);//프레임 사이즈
		f.setResizable(false);//프레임 사이즈 고정
		
		f.add(p);//패널을 프레임에 붙임
		b.addMouseListener(new myMouseEvent());//마우스 관련 동작 수행

		p.add(b);//패널 위에 버튼을 붙임
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	class myMouseEvent extends MouseAdapter{
		public void mouseClicked(MouseEvent e) { // 버튼이 클릭될 경우

			System.out.println("윽,,, 잡혔다ㅠㅠ"); // 메세지 콘솔창에 출력
		}
		
		public void mouseEntered(MouseEvent e) { // 버튼 영역 내에 마우스가 들어올 경우
			int b_x=(int)(Math.random()*150);
			int b_y=(int)(Math.random()*150);
			b.setLocation(b_x,b_y);
			
			int x=e.getX();//버튼의 x 위치
			int y=e.getY();//버튼의 y 위치
			System.out.println("x="+x+"    y="+y); // 버튼의 위치 출력
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		new Week12_1_SeoyoungOh(); //객체 생성
	}

}
