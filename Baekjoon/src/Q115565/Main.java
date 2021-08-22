package Q115565;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int K,N;
		int ans = Integer.MAX_VALUE;
		ArrayList<Integer> al = new ArrayList<>();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				al.add(i);
			}
		}
		
		
		if(al.size() < K) {
			System.out.println(-1);
		}else {
			for(int i=0; i<=al.size()-K;i++) {
				ans = Math.min(ans, al.get(i+K-1) - al.get(i) + 1);
			}
			System.out.println(ans);
		}
		
	}
}

/*
 Reference : https://yongmemo.tistory.com/17 
 */
