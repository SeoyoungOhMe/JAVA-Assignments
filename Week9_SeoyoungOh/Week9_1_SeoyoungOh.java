import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class Week9_1_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd = new Scanner(System.in);
		System.out.println("File name for input:");
		String file1 = kbd.next(); // 이미 만들어져 있는 파일
		System.out.println("File name for output:");
		String file2 = kbd.next(); // 새로 만들 파일

		try {
			System.out.println("The numbers in File, "+file1);
			// 입력 스트림, 출력 스트림 각각 생성
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file1));
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file2));
			
			try {
				while(true) { // 파일의 끝까지 실행
					int anInteger=inputStream.readInt(); // 정수 값을 읽음
					System.out.println(anInteger); // 출력
					outputStream.writeInt(anInteger*2); // 정수 값을 두 배 계산해서 출력 스트림을 통해 출력 파일에 씀.
				}
			}
			catch(EOFException e) {
				System.out.println("End of reading from File, "+file1);
				System.out.println(file2 + " is generated.");
				System.out.println();
			}
			// 두 스트림을 close
			inputStream.close(); 
			outputStream.close();

			System.out.println("The numbers in new File, "+ file2);
			// 생성된 파일과 연결된 스트림 생성
			ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream(file2));
			
			try {
				while(true) {
					int anInteger=inputStream2.readInt(); // 정수 값을 읽어들임
					System.out.println(anInteger); // 출력
				}
			}
			catch(EOFException e) { 
				System.out.println("End of reading from 2nd File, "+file2);
			}
		}
		catch(FileNotFoundException e) { // FileNotFoundException 예외처리
			System.out.println("Cannot find file");
		}
		catch(IOException e) {// IOException 예외 처리
			System.out.println("Problem with input from file");
		}
		
		
	}

}
