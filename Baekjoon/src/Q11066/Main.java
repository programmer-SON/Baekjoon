package Q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int nove[];
	static int dp[][];
	static int sum[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			nove = new int[N+1];
			dp = new int[N+1][N+1];
			sum = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N;i++) {
				nove[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + nove[i];
			}
			System.out.println(Solve());			
		}
		
	}

	public static int Solve() {
		for(int d=1; d<N; d++) {
			for(int tx = 1; tx+d <= N; tx++) {
				int ty = tx + d;
				dp[tx][ty] = Integer.MAX_VALUE;
				
				for(int mid=tx; mid < ty; mid++) {
					//dp[i][j] -> i ~ j 까지 최소 비용					 
					dp[tx][ty] = Math.min(dp[tx][ty], dp[tx][mid] + dp[mid+1][ty] + sum[ty] - sum[tx-1]);
				}
			}
		}
		return dp[1][N];
	}
}

/*
Reference: https://js1jj2sk3.tistory.com/3
 */
