
public class MyFile {
	private String title; // 파일의 제목
	private int page; // 파일의 페이지수
	
	public void setTitle(String title) { // 파일의 제목을 저장하는 메소드
		this.title=title;
	}
	public String getTitle() { // 파일의 제목을 반환해주는 메소드
		return title;
	}
	public void setPage(int page) { // 파일의 페이지수를 저장하는 메소드
		this.page=page;
	}
	public int getPage() { // 파일의 페이지수를 반환해주는 메소드
		return page;
	}
	public void fileCopy(MyFile fnew) { // 원래 파일을 새로운 파일에 복사하는 메소드
		fnew.title=this.title;
		fnew.page=this.page;
	}
	public void fileInfo() { // 파일 제목과 페이지를 출력해주는 메소드
		System.out.println("파일제목:" + this.title);
		System.out.println("페이지:" + this.page);
	}

}
