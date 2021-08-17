package Q17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int map[][], time[][];
	static int N,M;
	static int Vidx[];
	static int ans = Integer.MAX_VALUE;
	static int blank = 0;
	static int dirX[] = {0,0,-1,1};
	static int dirY[] = {-1,1,0,0};
	
	static ArrayList<Pair> virus = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Input();
		DFS(0,0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		time = new int[N][N];
		Vidx = new int[M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Pair(i,j));
				}
				if(map[i][j] == 0) {
					blank++;
				}
			}
		}
	}
	
	
	public static void DFS(int m, int idx) {
		
		if(m == M) {
			
			for(int i=0; i<N;i++) {
				Arrays.fill(time[i], -1);
			}
			BFS();
			return;
		}		
		
		for(int i=idx; i<virus.size(); i++) {
			Vidx[m] = i;
			DFS(m+1,i+1);
		}
	}
	
	public static void BFS() {
		Queue<Pair> que = new LinkedList<>();
		int sec = 0;
		int infect = 0;
		
		for(int i=0; i<M;i++) {
			Pair p = virus.get(Vidx[i]);
			que.add(p);
			time[p.x][p.y]++;
		}
		
		while(!que.isEmpty()) {
			
			Pair p = que.poll();
							
			for(int d = 0; d<4;d++) {
				int dx = p.x + dirX[d];
				int dy = p.y + dirY[d];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= N ) continue;
				
				if(map[dx][dy] != 1 && time[dx][dy] == -1) {
					que.add(new Pair(dx,dy));
					time[dx][dy] = time[p.x][p.y] + 1;
					//visited[dx][dy] = true;
					if(map[dx][dy] == 0) {
						sec = time[dx][dy];
						infect++;
					}
				}
			}
				
		}
		
		if(infect == blank) {
			ans = Math.min(ans, sec);
		}
	}
}

/*
 Reference : https://yabmoons.tistory.com/254 
 */
