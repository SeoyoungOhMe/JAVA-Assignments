import java.util.Scanner;
public class Week3_3_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Scanner kbd=new Scanner(System.in);
		String title; // 파일의 제목
		int page; // 파일의 페이지수
		MyFile fOld = new MyFile(); // 원래 파일 객체 생성
		MyFile fNew = new MyFile(); // 복사된 파일 객체 생성
		System.out.println("--File정보입력(제목,페이지수)--");
		fOld.setTitle(kbd.nextLine()); // 원래 파일의 제목 입력받음
		fOld.setPage(kbd.nextInt()); // 원래 파일의 페이지수 입력받음
		fOld.fileCopy(fNew); // 복사된 파일에 원래 파일을 복사함
		System.out.println("<원래 File>");
		fOld.fileInfo(); // 원래 파일의 제목과 페이지수 출력
		System.out.println("<복사된 File>");
		fNew.fileInfo(); // 복사된 파일의 제목과 페이지수 출력
	}

}
