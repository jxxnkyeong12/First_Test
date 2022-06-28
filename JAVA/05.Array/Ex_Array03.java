public class Ex_Array03 {
	public static void main(String[] args) {
		//2행 3열의 정수형 2차원 배열(arr[][])을 선언 및 생성하고,
		//모든 요소에 10을 할당하고 출력하시오   ▶중첩for문
		
		int[][] arr = new int[2][3]; 		//행을 먼저 써줘! 
		
		/*arr[0][0] = 10;
		arr[0][1] = 10;
		arr[0][2] = 10;
		
		arr[1][0] = 10;
		arr[1][1] = 10;
		arr[1][2] = 10;*/
		
		for (int i = 0; i < arr.length; i++) {			//arr.length : 2행 ▶ row
			for (int j = 0; j < arr[i].length; j++) {	//arr[i].length :3열 ▶ col
				arr[i][j] = 10;
				System.out.print("arr[" + i + "][" + j + "]의 값 : " + arr[i][j]+"\t");
			}//for j
			System.out.println();
		}//for i
		
		
	}//main()
}//class
