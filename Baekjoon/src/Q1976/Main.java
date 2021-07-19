package Q1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int citys[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		citys = new int[N+1];
		
		for(int i=1; i<=N;i++) {
			citys[i] = i;
		}
		
		for(int i=1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N;j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c == 1) {
					Union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		boolean flag = true;
		int checkCity = Integer.parseInt(st.nextToken());
		checkCity = Find(checkCity);
		
		
		for(int i=0; i<M-1;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			tmp = Find(tmp);
			
			if(tmp != checkCity) {
				flag = false;
				break;
			}
		}
		
/*		for(int i=1;i<=N;i++) {
			System.out.print(citys[i] + " ");
		}
		System.out.println();*/
		
		if(!flag) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
		br.close();
	}
	
	public static int Find(int child) {
		if(citys[child] == child) return child;
		
		return citys[child] = Find(citys[child]);
	}
	
	public static void Union(int x, int y) {
		int u1 = Find(x);
		int u2 = Find(y);
		
		if(u1 != u2) {
			citys[u1] = u2;
		}
	}
	
}
