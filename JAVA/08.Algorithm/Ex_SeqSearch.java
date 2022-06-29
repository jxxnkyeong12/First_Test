import java.util.Scanner;

public class Ex_SeqSearch {
	public static void main(String[] args) {
		//순차검색(Sequence Search) : 데이터를 처음부터 끝까지 검색 ▶ 데이터가 소량(적을)일 경우 활용한다
		int[] arr = {30, 90, 80, 60, 50, 20, 10, 70, 40, 100}; // 데이터 목록이 저장된 배열
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("찾는 수를 입력하세요 : ");
		int searchDate = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		Ex_SeqSearch ex = new Ex_SeqSearch();
		int index = ex.seqSearch(arr, searchDate); //⑥int index써주고 
		if(index == -1) {		//⑦못 찾았다!
			System.out.println("찾는 수는 " + searchDate + "이며, 검색에 실패했습니다"); 
		}else {						//⑧
			System.out.println("찾는 수는 " + searchDate + "이며, " + index + "번째에 있습니다");
		}//if
		
	}//main()
	
	//순차검색 메소드
	public int seqSearch(int[] arr, int seaarchDate) {
		int index = -1;   // ①프로그램에서 -1은 통상 실패했다(끝이다)를 의미함.
		for (int i = 0; i < arr.length; i++) {   //②
			if(arr[i] == seaarchDate) { 	//③찾는 데이터가 있다! 빙고! 찾았다!
				index = i+1;	 //④찾는 데이터의 위치값을 구한다 (index는 0부터 시작해버리니까 +1해주면 1부터 나오지!)
				break;  		
			}//if
		}//for
		return index;  //⑤
	}//seqSearch()
}//class
