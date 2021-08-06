package Q3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Direction{
	int x;
	char c;
	
	Direction(int x, char c){
		this.x = x;
		this.c = c;
	}
}

public class Main {

	static int map[][];
	static int N;
	static int L;
	static Direction dir[];
	static boolean snake[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		System.out.println(Solve());
	
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		snake = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			map[a-1][b-1] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		dir = new Direction[L];
		
		for(int i=0; i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			dir[i] = new Direction(x, c);
		}
	}
	
	public static int Solve() {
		Deque<Pair> dq = new LinkedList<>();
		dq.add(new Pair(0,0));
		snake[0][0] = true;
		
		int dirX[] = {-1,0,1,0};
		int dirY[] = {0,1,0,-1};
		
		int sec = 1;		
		int x=0 ,y=1,d=1;
		int idx = 0;
		
		while(true) {
			
/*			sec++;
			
			if(idx < L && dir[idx].x == sec) {
				if(dir[idx].c == 'D') {
					if(d == 3) {
						d = 0;
					}else {
						d++;
					}
				}else {
					if(d == 0) {
						d = 3;
					}else {
						d--;
					}
				}
				idx++;
			}
			
			x += dirX[d];
			y += dirY[d];*/
			
			if(x < 0 || x >= N || y < 0 || y >= N || snake[x][y]) break;
			//if(dq.size() >= 1 && (dq.peekFirst().x == x && dq.peekFirst().y == y)) break;
			
			/*if(dq.isEmpty() && map[x][y] == 0) {
				dq.add(new Pair(x,y));
			}else*/ if(map[x][y] == 0) {
				dq.add(new Pair(x,y));
				Pair p = dq.pollFirst();
				snake[p.x][p.y] = false;
				snake[x][y] = true;
			}
			
			if(map[x][y] == 1) {
				dq.add(new Pair(x,y));
				map[x][y] = 0;
				snake[x][y] = true;
			}
					
			
			if(idx < L && dir[idx].x == sec) {
				if(dir[idx].c == 'D') {
					if(d == 3) {
						d = 0;
					}else {
						d++;
					}
				}else {
					if(d == 0) {
						d = 3;
					}else {
						d--;
					}
				}
				idx++;
			}
			
			sec++;
			x += dirX[d];
			y += dirY[d];
		}
		
		return sec;
	}

}
