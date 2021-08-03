package Q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	
	static int N;
	static int map[][];
	static boolean visited[];
	//static ArrayList<Integer> start = new ArrayList<>();
	//static ArrayList<Integer> link = new ArrayList<>();
	static int start[],link[];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		DFS(0,0);
		
		System.out.println(ans);
	}
	
	public static void Input() throws IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N];
		start = new int[N/2];
		link = new int[N/2];
				
		for(int i=0; i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	public static void DFS(int n, int idx) {
		if(N/2 == n) {
			Solve();
			return;
		}
		
		for(int i=idx; i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(n+1,i+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void Solve() {
		int sIdx = 0;
		int lIdx = 0;
		int sSum = 0;
		int lSum = 0;
		
		for(int i=0; i<visited.length;i++) {
			if(visited[i]) {
				start[sIdx++] = i;
			}else {
				link[lIdx++] = i;
			}
		}
		
		
		for(int i=0; i<N/2;i++) {
			
			for(int j=i+1; j<N/2;j++) {
				int lVal = map[link[i]][link[j]] + map[link[j]][link[i]];
				int sVal = map[start[i]][start[j]] + map[start[j]][start[i]];
				
				lSum += lVal;
				sSum += sVal;
			}
		}
		
		ans = Math.min(ans,Math.abs(lSum-sSum));
	}

}
