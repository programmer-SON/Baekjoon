package Q5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[];
	static long dp[][];
	static long ans = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		dp = new long[N+1][21];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][arr[1]] = 1;
		
		for(int i=2;i<N;i++) {
			for(int j=0; j<=20;j++) {
				if(dp[i-1][j] != 0) {
					if(j + arr[i] <= 20) dp[i][j+arr[i]] += dp[i-1][j];
					if(j - arr[i] >= 0) dp[i][j-arr[i]] += dp[i-1][j];
				}
			}
		}
				
		System.out.println(dp[N-1][arr[N]]);
	}

}

/*
 Reference : https://lmcoa15.tistory.com/96
 */
