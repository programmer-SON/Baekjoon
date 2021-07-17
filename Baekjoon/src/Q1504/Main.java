package Q1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
	int vertex, dist;
	Pair(int vertex, int dist){
		this.vertex = vertex;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Pair p) {
		return this.dist > p.dist ? 1 : this.dist == p.dist ? 0 : -1;
	}
}

public class Main {

	static int N,E;
	static int v1,v2;
	static int distance[];
	static final int INF = 9876543;
	static ArrayList<ArrayList<Pair>> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];
		//Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=1; i<=N+1; i++) {
			al.add(new ArrayList<>());
		}
		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			al.get(a).add(new Pair(b,c));
			al.get(b).add(new Pair(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int answer = solution();
		System.out.println(answer);
		
		br.close();
	}
	
	public static int solution() {
		int ans1 = 0;
		int ans2 = 0;
		
		// 1 -> v1 최단경로
		ans1 += Dijkstra(1,v1);
		//v1 -> v2 최단경로
		ans1 += Dijkstra(v1,v2);
		// v2 -> N 최단경로
		ans1 += Dijkstra(v2,N);

		// 1 -> v2 최단경로
		ans2 += Dijkstra(1,v2);
		// v2 -> v1 최단경로
		ans2 += Dijkstra(v2,v1);
		// v1 -> N 최단경로
		ans2 += Dijkstra(v1,N);

		if(ans1 >= INF && ans2 >= INF) return -1;
		return Math.min(ans1, ans2);
	}
	
	public static int Dijkstra(int start, int end) {
		Arrays.fill(distance, INF);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		distance[start] = 0;
		
		pq.add(new Pair(start,0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(distance[p.vertex] < p.dist) continue;
			
			for(int i=0; i<al.get(p.vertex).size();i++) {
				int next = al.get(p.vertex).get(i).vertex;
				int nextDist = al.get(p.vertex).get(i).dist + distance[p.vertex];
				
				if(distance[next] > nextDist) {
					distance[next] = nextDist;
					pq.add(new Pair(next,nextDist));
				}
			}
		}
		return distance[end];
	}
	
}

//풀이 참고사이트 : https://dragon-h.tistory.com/21
