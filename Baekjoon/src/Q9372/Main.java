package Q9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int count;
	static int countries[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Init();
			for(int m =0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(checkFind(a,b)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
	public static void Init() {
		countries = new int[N+1];
		for(int i=1;i<=N;i++) {
			countries[i] = i;
		}
		count = 0;
	}
	
	public static boolean checkFind(int x, int y) {
		int u1 = Find(x);
		int u2 = Find(y);
		
		if(u1 == u2) return false;
		
		countries[u2] = u1;		
		return true;
	}
	
	public static int Find(int child) {
		if(child == countries[child]) return child;
		
		return countries[child] = Find(countries[child]);
	}

}
