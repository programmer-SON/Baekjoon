package Q16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,k;
	static int parent[];
	static int price[];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		
		int ans = 0;
		
		for(int i=1;i<=N;i++) {
			if(parent[i] == i) {
				ans += price[i];
			}
		}
		
		if(ans > k) {
			System.out.println("Oh no");
		}else {
			System.out.println(ans);
		}
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		price = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N;i++) {
			price[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Union(a,b);
		}
	}
	
	public static int Find(int a) {
		
		if(parent[a] == a) return a;
		
		return parent[a] = Find(parent[a]);
	}
	
	public static void Union(int x, int y) {
		int p1 = Find(x);
		int p2 = Find(y);
		
		if(p1 == p2) return;
		
		if(price[p1] > price[p2] ) {
			parent[p1] = p2; 
		}else {
			parent[p2] = p1;
		}
		
	}

}

/*
 Reference : https://akim9905.tistory.com/22
 */
