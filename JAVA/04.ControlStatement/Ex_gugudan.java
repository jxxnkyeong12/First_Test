public class Ex_gugudan {
	public static void main(String[] args) {
		//가로 출력
		for(int i = 2; i <=9; i++) {
			for(int j = 1; j <=9; j++) {
				if(i * j < 10) {
					System.out.print(i + "X" + j + "=0" + (i * j)+ "\t");
				} else {
					System.out.print(i + "X" + j + "=" + (i * j)+ "\t");
				}//if - 뒤에 숫자맞춰주는거 2->02 그 외 두자리수는 그대로!
     
			}//for j
			System.out.println();
		}//for i
			System.out.println();
			for(int i = 1; i<=9; i++) {
				for(int j = 2; j <=9; j++) {
					if(i * j < 10) {
						System.out.print(j + "X" + i + "=0" + (i * j)+ "\t");
					}else {
						System.out.print(j + "X" + i + "=" + (i * j)+ "\t");
					}//if
				}//for j
				System.out.println();
			}//for i
			
		//세로 출력
		
	}//main()
}//class
