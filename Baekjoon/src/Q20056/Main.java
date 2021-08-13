package Q20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class fireBall{
	int r,c,m,s,d;
	public fireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

class Pair{
	int x,y,d;
	Pair(int x, int y,int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {

	static int N,M,K;
	static Queue<fireBall> que = new LinkedList<>();
	static Queue<Pair> store = new LinkedList<>();
	static int dirX[] = {-1,-1,0,1,1,1,0,-1};
	static int dirY[] = {0,1,1,1,0,-1,-1,-1};
	static int map[][][]; // [][][0] -> Áú·®, [][][1]-> ¼Ó·Â [][][2] -> ¹æÇâ È¦¼ö°¹¼ö [][][3] -> ¹æÇâ Â¦¼ö°¹¼ö
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		System.out.println(Solve());
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N][4];
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			que.add(new fireBall(r-1, c-1, m, s, d));
		}
		
	}
	
	public static int Solve() {
		
		int ans = 0;
		
		for(int time = 0; time < K; time++) {

			//ÆÄÀÌ¾îº¼ ÀÌµ¿
			Move();

			//fireball °è»ê
			Cal();
		}
		
		while(!que.isEmpty()) {
			ans += que.poll().m;
		}
		
		return ans;
	}
	
	public static void Move() {
		
		
		while(!que.isEmpty()) {
			fireBall fb = que.poll();
			int dr = fb.r;
			int dc = fb.c;
			
			for(int s = 0; s < fb.s; s++) {
				dr += dirX[fb.d];
				dc += dirY[fb.d];
				
				if(dr < 0) {
					dr = N-1;
				}else if(dr ==N ) {
					dr = 0;
				}
				
				if(dc < 0) {
					dc = N-1;
				}else if(dc ==N ) {
					dc = 0;
				}
			}			
			
			if(map[dr][dc][0] == 0) {
				store.add(new Pair(dr,dc,fb.d));
			}
			
			map[dr][dc][0] += fb.m;
			map[dr][dc][1] += fb.s;
			
			if(fb.d % 2 != 0) {
				map[dr][dc][2]++;
			}else {
				map[dr][dc][3]++;
			}
			
		}
	}
	
	public static void Cal() {
		
		while(!store.isEmpty()) {
			Pair p = store.poll();
			
			if(map[p.x][p.y][2] + map[p.x][p.y][3] < 2) {
				que.add(new fireBall(p.x,p.y,map[p.x][p.y][0],map[p.x][p.y][1],p.d));
				for(int i=0; i<4;i++) {
					map[p.x][p.y][i] = 0;
				}
				continue;
			}
			
			if(map[p.x][p.y][0] / 5 == 0) {
				for(int i=0; i<4;i++) {
					map[p.x][p.y][i] = 0;
				}
				continue;
			}
			
			int m = map[p.x][p.y][0] / 5;
			int s = map[p.x][p.y][1] / (map[p.x][p.y][2] + map[p.x][p.y][3]); //¹æÇâÂ¦¼ö°¹¼ö + ¹æÇâÈ¦¼ö°¹¼ö = ÆÄÀÌ¾îº¼ ÃÑ °¹¼ö
			
			
			//È¦¼ö ¶Ç´Â Â¦¼ö ÀÏ °æ¿ì
			if(map[p.x][p.y][2] == 0 || map[p.x][p.y][3] == 0) {
				que.add(new fireBall(p.x, p.y, m, s, 0));
				que.add(new fireBall(p.x, p.y, m, s, 2));
				que.add(new fireBall(p.x, p.y, m, s, 4));
				que.add(new fireBall(p.x, p.y, m, s, 6));
			}else {
				que.add(new fireBall(p.x, p.y, m, s, 1));
				que.add(new fireBall(p.x, p.y, m, s, 3));
				que.add(new fireBall(p.x, p.y, m, s, 5));
				que.add(new fireBall(p.x, p.y, m, s, 7));
			}
			
			for(int i=0; i<4;i++) {
				map[p.x][p.y][i] = 0;
			}
		}
		
	}

}
