package Q13699;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		long dp[] = new long[n+1];
		
		dp[0] = 1;
		
		for(int i=1; i<=n;i++) {
			for(int j=0; j<i; j++) {
				dp[i] += dp[j] * dp[i-j-1]; 
			}
		}
		
		System.out.println(dp[n]);
		
	}

}
