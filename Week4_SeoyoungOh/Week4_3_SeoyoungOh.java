
public class Week4_3_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		int a=3, b=5;
		double da=1.2, db=3.4;
		char c1='x', c2='y';
		int i_arr[]= {2, 5, 3};
		double d_arr[]= {1.5, 3.6, 7.23};
		char c_arr[]= {'f','r','i','e','n','d'};
		String s_arr[]= {"I","love","you"};
		System.out.println(a + "+" + b + "=" + sum(a, b));
		System.out.println(da + "+" + db + "=" + sum(da, db));
		System.out.println(c1 + "+" + c2 + "=" + sum(c1, c2));
		System.out.println("sum of int array: " + sum(i_arr));
		System.out.println("sum of double array: " + sum(d_arr));
		System.out.println("sum of char array: " + sum(c_arr));
		System.out.println("sum of String array: " + sum(s_arr));
	}
	
	static int sum(int a, int b) { // 두 정수의 합 계산하는 메소드
		return a+b;
	}
	static double sum(double a, double b) { // 두 실수의 합 계산하는 메소드
		return a+b;
	}
	static String sum(char a, char b) { // 두 char형 변수를 합치는 메소드
		return a+""+b;
	}
	static int sum(int arr[]) { // 정수형 배열의 합을 계산하는 메소드
		int result=0;
		for(int i=0;i<arr.length;i++) { // 배열의 길이만큼 반복
			result+=arr[i];
		}
		return result;
	}
	static double sum(double arr[]) { // 실수형 배열의 합을 계산하는 메소드
		double result=0;
		for(int i=0;i<arr.length;i++) { // 배열의 길이만큼 반복
			result+=arr[i];
		}
		return result;
	}
	static String sum(char arr[]) { // char형 배열의 문자를 모두 합치는 메소드
		String result="";
		for(int i=0;i<arr.length;i++) { // 배열의 길이만큼 반복
			result=result+""+arr[i];
		}
		return result;
	}
	static String sum(String arr[]) { // 문자열 배열의 문자열을 모두 합치는 메소드
		String result="";
		for(int i=0;i<arr.length;i++) { // 배열의 길이만큼 반복
			result=result+""+arr[i]+" "; // 띄어쓰기가 중간에 들어감
		}
		return result;
	}
}
