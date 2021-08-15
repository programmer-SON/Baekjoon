package Q2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long M;
	static long A[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		A = new long[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Long.parseLong(st.nextToken()); 
		}
		
		
		long sum = A[0];
		long ans = 0;
		int start = -1, end = 0;
		
		while(true) {
			if(sum < M) {
				if(end+1 == N) break;
				sum += A[++end];
			}else {
				if(sum == M) ans++;
				sum -= A[++start];
			}
		}
		
		System.out.println(ans);
	}

}

