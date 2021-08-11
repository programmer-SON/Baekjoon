package Q1789;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long S = Long.parseLong(sc.next());
		long num = 1;
		long sum = 0;
		long N = 1;
		
		while(true) {
			sum += num;
			num++;			
			if(sum >= S) {
				break;
			}

			N++;
		}
		
		System.out.println(N-1);
	}

}
