package Q14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int nums[];
	static int oper[] = new int[4];
	static int op[];
	static int N;
	static long maxi = Integer.MIN_VALUE;
	static long mini = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		DFS(0);
		System.out.println(maxi);
		System.out.println(mini);
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		op = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void DFS(int n) {
		
		if(n == N-1) {
			Solve();
			return;
		}
		
		for(int i=0; i<4;i++) {
			if(oper[i] > 0) {
				op[n] = i;
				oper[i]--;
				DFS(n+1);
				oper[i]++;
			}
		}
	}
	
	public static void Solve() {
		
		long total = nums[0];
		for(int i=1; i<N;i++) {
			switch(op[i-1]) {
				case 0 :
					total += nums[i];
					break;
				case 1 :
					total -= nums[i];
					break;
				case 2 :
					total *= nums[i];
					break;
				default :
					if(total < 0) {
						total *= -1;
						total /= nums[i];
						total *= -1;
					}else {
						total /= nums[i];
					}
			}
		}
		
		mini = Math.min(mini, total);
		maxi = Math.max(maxi, total);
	}

}
