import java.io.*;
import java.util.*;
import java.net.*;

public class Week14_server_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***
		전공: 사이버보안
		학번: 2171070
		성명: 오서영
		***/
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			/** 클라이언트와 연결 **/
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();

			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			/** 클라이언트로부터 "Hello?"를 읽어옴 **/
			String strIn = in.nextLine();
			System.out.println(strIn);
			
			/** 클라이언트에게 "How many numbers?"를 물어봄 **/
			out.println("How many numbers?");
			out.flush();
			
			/** 클라이언트로부터 n을 읽어옴 **/
			String strN = in.nextLine();
			System.out.println(strN);
			
			int n = Integer.parseInt(strN); // strN은 String 타입이므로 이를 정수형으로 변환해 저장
			
			/** 클라이언트에게 "Input n numbers"를 출력함 **/
			out.println("Input "+ strN +" numbers");
			out.flush();
			
			/** 클라이언트에게 n 개 정수를 입력받아 sum과 average를 계산함 **/
			int sum = 0; // 합계
			String strInput;
			int intInput;
			double avg; // 평균
			for(int i=0;i<n;i++) { // n회만큼 반복문 진행
				strInput = in.nextLine(); // 클라이언트로부터 읽어옴
				intInput = Integer.parseInt(strInput); // 문자열을 정수형으로 변환
				sum += intInput; // 총합에 더함
				
			}
			
			avg = (double)sum/n; // 평균값 계산
			
			/** 클라이언트에게 sum 계산 결과 전송 **/
			out.println("Sum: "+ sum);
			out.flush();
			
			/** 클라이언트에게 average 계산 결과 전송 **/
			out.println("Avg: "+ avg);
			out.flush();
			
			/** 클라이언트로부터 "Service finished."를 읽어옴. **/
			strN = in.nextLine();
			System.out.println(strN);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				serverSocket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
