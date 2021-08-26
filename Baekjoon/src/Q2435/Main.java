package Q2435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[];
	static long ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N,K;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		
		while(idx <= N-K) {
		
			int sum = 0;
			for(int k=0; k<K;k++) {
				sum += arr[idx+k];
			}
			ans = Math.max(sum, ans);
			idx++;
		}
		
		System.out.println(ans);
		
	}

}
