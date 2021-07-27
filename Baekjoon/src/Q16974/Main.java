package Q16974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static long X;
	static long peti[], burger[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Input();
		System.out.println(Solve(N,X));
		
		br.close();
		bw.close();
	}
	
	public static void Input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
	
		peti = new long[N+1];
		burger = new long[N+1];
		
		peti[1] = 3;
		burger[1] = 5;
		for(int i=2; i<=N; i++) {
			peti[i] = peti[i-1] * 2 + 1;
			burger[i] = burger[i-1] * 2 + 3;
		}
	}
	
	public static long Solve(int n, long x) {
		if(n==1) {
			if(x <= 1) return 0;
			if(x == 2) return 1;
			if(x == 3) return 2;
			return 3;
		}
		
		if(x <= 1) return 0;
		if(x <= 1 + burger[n-1] ) return Solve(n-1,x-1);
		if(x <= 2 + burger[n-1]) return peti[n-1] + 1;
		if(x <= 2+ burger[n-1] * 2) {
			return peti[n-1] + 1 + Solve(n-1, x - 1 - burger[n-1] - 1);
		}
		return peti[n-1] * 2 + 1;
	}

}

/*
Reference : https://100100e.tistory.com/261
*/