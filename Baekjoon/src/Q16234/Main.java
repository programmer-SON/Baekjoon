package Q16234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,L,R;
	static int map[][];
	static boolean visited[][];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		Solve();
		
		System.out.println(ans);
	}
	
	public static void Input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//visited = new boolean[N][N];
	}
	
	public static void Solve() {
		
		boolean flag = true;
				
		while(flag) {
			visited = new boolean[N][N];
			int count = 0;
			
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					visited[i][j] = true;
					count += BFS(i,j);
				}
			}
			
			if(count > 0) { 
				ans++;
			}else {
				flag = false;
			}
		}
	}
	
	public static int BFS(int x, int y) {
		int dirX[] = {0,0,1,-1};
		int dirY[] = {1,-1,0,0};
		//boolean bfsVisited[][] = new boolean[N][N];
		
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> sq = new LinkedList<>();
		
		int peopleCnt = 0;
		int assCnt = 0;
		
		q.add(new Pair(x,y));
		sq.add(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			peopleCnt += map[p.x][p.y];
			assCnt++;
			
			for(int d = 0; d<4; d++) {
				int dx = p.x + dirX[d];
				int dy = p.y + dirY[d];
				
				if(dx < 0 || dx >=N || dy < 0 || dy >=N || visited[dx][dy]) continue;
				
				int diff = Math.abs(map[p.x][p.y] - map[dx][dy]);
				
				if(diff >= L && diff <= R ) {
					q.add(new Pair(dx,dy));
					visited[dx][dy] = true;
					sq.add(new Pair(dx,dy));
				}
			}				
		}
		
		if(assCnt > 1) {
			Search(sq, peopleCnt, assCnt);
			return 1;
		}
		return 0;
	}
	
	public static void Search(Queue<Pair> sq, int pc, int ac) {
		
		while(!sq.isEmpty()) {
			Pair p = sq.poll();
			map[p.x][p.y] = pc / ac;
		}		
	}

}
