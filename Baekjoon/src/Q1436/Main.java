package Q1436;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		long num = 666;
		int rank = 0;
		while(rank != N) {
			long share = num;
			long mod;
			int cnt = 0;
			while(share != 0) {
				mod = share % 10;
				share /= 10;
				
				if(mod == 6) {
					cnt++;
				}else {
					cnt=0;
				}
				
				if(cnt == 3) {
					rank++;
					break;
				}
			}
			
			num++;
		}
		
		System.out.println(num-1);
		
		sc.close();
	}

}
