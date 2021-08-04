package Q14502;

import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int map[][], copyMap[][];
	static int dirX[] = {0,0,1,-1};
	static int dirY[] = {1,-1,0,0};
	static ArrayList<Pair> virus = new ArrayList<>();
	static int ans = -1;
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		DFS(0);
		
		System.out.println(ans);
	}
	
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Pair(i,j));
				}
			}
		}
		
		br.close();
	}
	
	public static void DFS(int n) {
		
		if(n==3) {
			
			for(int i=0; i<N;i++) {
				for(int j=0; j<M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			for(Pair p : virus) {
				BFS(p.x,p.y);
			}
			
			ans = Math.max(Solve(),ans);
			
			return;
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(n+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void BFS(int x,int y) {
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int d=0;d<4;d++) {
				int dx = p.x + dirX[d];
				int dy = p.y + dirY[d];
				
				if(dx < 0 || dx >=N || dy < 0 || dy >= M || copyMap[dx][dy] != 0) continue;
				copyMap[dx][dy] = 2;
				q.add(new Pair(dx,dy));
			}
		}
	}
	
	public static int Solve() {
		int cnt = 0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}

}
