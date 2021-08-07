package Q5569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int dp[][][][];
	static final int mod = 100000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		dp = new int[h+1][w+1][2][2];
		
		for(int i=1; i<=w; i++) {
			dp[1][i][0][0] = 1;
		}
		
		for(int i=1; i<=h; i++) {
			dp[i][1][0][1] = 1;
		}

		for(int i=2; i<=h; i++) {
			for(int j=2; j<=w; j++) {
				dp[i][j][0][0] = (dp[i][j-1][0][0] + dp[i][j-1][1][0]) % mod;
				dp[i][j][0][1] = (dp[i-1][j][0][1] + dp[i-1][j][1][1]) % mod;
				dp[i][j][1][0] = (dp[i][j-1][0][1]) % mod;
				dp[i][j][1][1] = (dp[i-1][j][0][0]) % mod;
			}
		}
		
		int ans = (dp[h][w][0][0] + dp[h][w][0][1] + dp[h][w][1][0] + dp[h][w][1][1]) % mod;
		System.out.println(ans);
	}

}

/*
Reference : https://huiung.tistory.com/136 
 */
