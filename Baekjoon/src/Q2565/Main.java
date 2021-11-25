package Q2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static Integer[] dp;
	static int[][] wire;
	static int N,max;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		Solve();
		System.out.println(N-max);
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		dp = new Integer[N];
		wire = new int[N][2];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void Solve() {
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		
//		for(int i=0; i<N;i++) {
//			System.out.println(wire[i][0] + " " + wire[i][1]);
//		}
		
		for(int i=0; i<N;i++) {
			max = Math.max(Recur(i), max);
		}
		
		
	}
	
	public static int Recur(int n) {
		
		if(dp[n] == null) {
			dp[n] = 1;
			
			for(int i=n+1; i<dp.length;i++) {
				
				if(wire[n][1] < wire[i][1]) {
					dp[n] = Math.max(dp[n], Recur(i)+1);
				}
			}
		}
		
		return dp[n];
	}

}

// Reference: https://st-lab.tistory.com/138
