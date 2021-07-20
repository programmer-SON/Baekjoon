package Q1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Node{
	int v1, v2;
	long cost;
	
	Node(int v1, int v2, long cost){
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
}

public class Main {

	static int V,E;
	static long sum = 0;
	static int graphs[];
	static ArrayList<Node> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Init();	
		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			al.add(new Node(a,b,c));			
		}
		
		Kruskal();
		
		System.out.println(sum);		
	}
	
	public static void Init() {
		graphs = new int[V+1];
		for(int i=1;i<=V;i++) {
			graphs[i] = i;
		}
	}
	
	public static void Kruskal() {
		Collections.sort(al, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.cost > n2.cost ? 1 : n1.cost == n2.cost ? 0 : -1;
			}
		});
		
		for(Node n : al) {
			if(checkUnion(n.v1,n.v2)) {
				sum += n.cost;
			}
		}
	}
	
	public static int Find(int child) {
		if(graphs[child] == child ) return child;
		
		return graphs[child] = Find(graphs[child]);
	}
	
	public static boolean checkUnion(int x, int y) {
		int u1 = Find(x);
		int u2 = Find(y);
		
		if(u1 == u2) return false;
		
		Union(u1,u2);
		return true;
	}
	
	public static void Union(int u1, int u2) {
		if(u1 != u2) {
			graphs[u1] = u2;
		}
	}

}
