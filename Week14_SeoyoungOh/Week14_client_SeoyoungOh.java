import java.io.*;
import java.util.*;
import java.net.*;

public class Week14_client_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***
		전공: 사이버보안
		학번: 2171070
		성명: 오서영
		***/
		
		Socket socket = null;
		Scanner kbd = null;
		
		try {
			/** 서버와 연결 **/
			socket = new Socket("10.200.32.23",9001);
			
			kbd = new Scanner(System.in);
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			/** 서버에게 "Hello?"를 물어봄**/
			out.println("Hello?");
			out.flush();
			
			/** 서버로부터 "How many numbers?"라는 입력을 받음 **/
			String strIn = in.nextLine();
			System.out.println(strIn);
			
			/** 사용자로부터 n을 입력받아 서버에게 전달함 **/
			int n = kbd.nextInt();
			out.println(n);
			out.flush();
			
			/** 서버로부터 "Input n numbers"를 입력받아 화면에 출력함 **/
			strIn = in.nextLine();
			System.out.println(strIn);
			
			/** 사용자로부터 n개 정수를 입력받아 서버에게 전달함 **/
			for(int i=0;i<n; i++) {
				int input = kbd.nextInt();
				out.println(input);
				out.flush();
			}
			
			/** 서버로부터 Sum을 입력받아 화면에 출력함 **/
			strIn = in.nextLine();
			System.out.println(strIn);
			
			/** 서버로부터 Average를 입력받아 화면에 출력함 **/
			strIn = in.nextLine();
			System.out.println(strIn);
			
			/** 서버에게 "Service finished."를 전달함.**/
			out.println("Service finished.");
			out.flush();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			try {
				socket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
