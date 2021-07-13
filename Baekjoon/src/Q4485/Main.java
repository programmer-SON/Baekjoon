package Q4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int x,y,dist;
	Node(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.dist > n.dist ? 1 : this.dist == n.dist ? 0 : -1;
	}
}

public class Main {

	static int N;
	static int map[][];
	static int dist[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int idx = 1;
		while(true) {
			st =new StringTokenizer(br.readLine());
						
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) break;
			map = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N;i++) {
				st =new StringTokenizer(br.readLine());
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = Dijkstra();			
			
			System.out.println("Problem " + idx +": " + ans);
			idx++;
		}	
		
	}
	
	public static int Dijkstra() {
		
		int dirX[] = {0,0,1,-1};
		int dirY[] = {1,-1,0,0};
		
		dist[0][0] = map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,map[0][0]));
		
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.x][n.y] = true;
			
			for(int d = 0; d<4;d++) {
				int dx = n.x + dirX[d];
				int dy = n.y + dirY[d];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dx][dy]) continue;
				int nextDist = dist[n.x][n.y] + map[dx][dy];
				
				if(dist[dx][dy] > nextDist) {
					dist[dx][dy] = nextDist;
					pq.add(new Node(dx,dy,nextDist));
				}
			}
		}
		
		return dist[N-1][N-1];
	}

}
