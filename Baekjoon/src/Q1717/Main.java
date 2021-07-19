package Q1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int root[], rank[];
	static int N,M;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		root = new int[N+1];
		rank = new int[N+1];
		
		for(int i=0;i<=N; i++) {
			root[i]=i;
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				Union(b,c);
			}else {
				int p1 = Find(b);
				int p2 = Find(c);
				
				if(p1==p2) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		
		//for(int i=0;i<=N;i++) {
		//	System.out.print(root[i] + " ");
		//}
		br.close();
	}
	
	public static int Find(int child) {
		
		if(root[child] == child) {
			return child;
		}
		
		return root[child] = Find(root[child]);
	}
	
	public static void Union(int x, int y) {
		
		int u1 = Find(x);
		int u2 = Find(y);
		
		if(u1==u2) return;
		
		if(rank[u1] > rank[u2]) {
			root[u2] = u1;
		}else {
			root[u1] = u2;
		}
		
		if(rank[u1] == rank[u2]) {
			rank[u1]++;
		}
	}
	
}

/*
참고 사이트 : https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
*/