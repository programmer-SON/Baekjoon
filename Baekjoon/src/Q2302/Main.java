package Q2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int M;
	static int vip[];
	static long dp[];
	static long ans = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Input();
		Solve();
		System.out.println(ans);
	}
	
	public static void Input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dp = new long[N+1];
		vip = new int[M];
		
		for(int i=0; i<M;i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void Solve() {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int start = 0;
		int end = 0;
		for(int i=0; i<M;i++) {
			end = vip[i];
			ans = ans * dp[end - start - 1];
			start = vip[i];
		}
		
		ans = ans * dp[N-start];
		
	}

}

//Ref : https://yabmoons.tistory.com/550
