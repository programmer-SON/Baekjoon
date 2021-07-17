package Q1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int start, cost;
	Node(int start, int cost){
		this.start = start;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.cost > n.cost ? 1 : this.cost == n.cost ? 0 : -1;
	}
}

public class Main {

	static int N,M;
	static int distance[];
	static int map[][];
	//static ArrayList<Node> al[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st = null;
		int start,end;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		//al = new ArrayList[N+1];
		distance = new int[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		/*for(int i=1; i<=N;i++) {
			al[i] = new ArrayList<>();
		}*/
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[s][d] = c;
			//al[s].add(new Node(d,c));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		System.out.println(Dikjstra(start, end));
	}
	
	public static int Dikjstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			/*for(int i=0; i < al[n.start].size();i++) {
				int next = al[n.start].get(i).start;
				int nextCost = distance[n.start] + al[n.start].get(i).cost;
				
				if(distance[next] > nextCost) {
					distance[next] = nextCost;
					pq.add(new Node(next,nextCost));
				}
			}*/
			
			for(int i=1; i<=N; i++) {
				if(map[n.start][i] == -1) continue;
				
				int next = i;
				int nextDist = distance[n.start] + map[n.start][i];
				
				if(distance[next] > nextDist) {
					distance[next] = nextDist;
					pq.add(new Node(next,nextDist));
				}				
			}
		}
		
		return distance[end];
	}

}
