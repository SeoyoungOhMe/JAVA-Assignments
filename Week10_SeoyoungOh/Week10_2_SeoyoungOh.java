import java.util.*;

public class Week10_2_SeoyoungOh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171070");
		System.out.println("성명: 오서영");
		System.out.println("=============");
		
		Map<String, String> myMap = new HashMap<String, String>(); // 학생 아이디와 이름을 쌍으로 저장
		Scanner kbd=new Scanner(System.in);
		String ID, name, str; 
		System.out.println("학생의 ID와 이름을 차례로 입력하세요.(종료시 0 0 입력)");
		
		while(true) { 
			ID=kbd.next();
			name=kbd.next();
			if(ID.equals("0")&&name.equals("0")) { // 아이디와 이름이 0 0으로 입력된 경우 반복문 탈출
				break;
			}
			myMap.put(ID, name); // 아이디와 이름을 추가함
		}
		
		System.out.println("<학생명단>");
		System.out.println("[ID]\t\t[NAME]");
		
		Set s=myMap.keySet(); // Set s 생성
		Iterator<String> it=s.iterator();
		while(it.hasNext()) { // 학생 명단을 전체 출력함
			str=it.next();
			System.out.println(str+"\t\t"+myMap.get(str));
		}
		
		System.out.println();
		System.out.println("전체 학생수:"+ myMap.size()); // 전체 학생수 출력

		
		Iterator<String> it2=s.iterator(); 
		
		str=it2.next(); // 가장 처음의 ID 값을 입력받음
		String maxID=str, minID=str; // str로 최대와 최소 ID를 초기화
		int maxLength=myMap.get(maxID).length(), minLength=myMap.get(minID).length(); 
		// maxLength는 maxID에 해당하는 이름의 길이이고, minLength는 minID에 해당하는 이름의 길이
		
		while(it2.hasNext()) { // 목록의 전체를 모두 실행
			str=it2.next(); // 다음 값을 넣음.
			
			// maxID의 이름 길이가 str의 이름 길이보다 짧은 경우
			if(myMap.get(maxID).length() < myMap.get(str).length()) { 
				maxLength=myMap.get(str).length(); // str의 이름 길이로 최대 길이를 갱신함.
				maxID=str; // str로 갱신
			}
			
			// minID의 이름 길이가 str의 이름 길이보다 긴 경우
			if(myMap.get(minID).length() > myMap.get(str).length()) {
				minLength=myMap.get(str).length(); // str의 이름 길이로 최소 길이를 갱신함.
				minID=str; // str로 갱신
			}
		}
		
		// 반복문 결과 출력
		System.out.println("<가장 긴 이름을 가진 학생>");
		System.out.println("ID:"+maxID+" Name:"+myMap.get(maxID)+" 길이:"+maxLength);
		System.out.println("<가장 짧은 이름을 가진 학생>");
		System.out.println("ID:"+minID+" Name:"+myMap.get(minID)+" 길이:"+minLength);

	}

}
