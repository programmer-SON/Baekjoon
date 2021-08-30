package Q10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int dp[][];
	static int pelin[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M;
		N = Integer.parseInt(st.nextToken());
		pelin = new int[N];
		dp = new int[N][N];
		
		for(int i=0; i<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			pelin[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		
		while(M-- != 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(Solve(a-1,b-1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int Solve(int i, int j) {
		
		if(i==j) {
			return 1;
		}else if(i+1 == j) {
			if(pelin[i] == pelin[j]) return 1;
			return 0;
		}
		
		if(dp[i][j] != -1) return dp[i][j];
		
		if(pelin[i] != pelin[j]) {
			dp[i][j] = 0;
			return dp[i][j];
		}
		
		dp[i][j] = Solve(i+1,j-1);		
		
		return dp[i][j];
	}	
	
}
