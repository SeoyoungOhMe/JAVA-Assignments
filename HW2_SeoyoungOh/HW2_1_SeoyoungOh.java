import java.util.*;
import java.io.*;

public class HW2_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		/*** 입력 파일 입력받기 ***/
		Scanner kbd = new Scanner(System.in);
		String inputFile; // 읽어올 파일
		String outputFile; // 출력할 파일

		System.out.println("Input the filename to read.");
		inputFile = kbd.next(); // 입력받을 파일 사용자로부터 입력받기
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(inputFile)); // 스트림에 연결
		}
		catch(FileNotFoundException e) { // 파일이 없는 경우 에러 처리
			System.out.println("Error opening the file "+ inputFile);
			System.exit(0);
		}
		
		/*** 출력 파일 입력받기 ***/
		System.out.println("Input the filename to write.");
		outputFile = kbd.next(); // 출력할 파일 사용자로부터 입력받기
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(outputFile); //스트림에 연결
		}
		catch(IOException e) { // 에러 처리
			System.out.println("Exception occurs.");
			System.exit(1);
		}
		
		/*** 입력파일을 읽어 출력파일에 쓰기 ***/
		while(inputStream.hasNextLine()) { // 아직 줄이 남아있는 경우
			String line = inputStream.nextLine(); // 텍스트를 줄 단위로 읽어옴
			StringTokenizer token = new StringTokenizer(line, ", \n"); // 분리자로 구분
			
			while(token.hasMoreTokens()) { // 토큰이 남아있는 경우
				String tk = token.nextToken(); // 다음 토큰을 가져옴
				if(tk.length() > 4) { // 길이가 4보다 큰 단어의 경우
					outputStream.println(tk);
				}
			}
		}
		
		// 결과 출력
		System.out.println(outputFile + " is generated.");
		
		// 닫기
		outputStream.close();
		inputStream.close();
		
	}

}
