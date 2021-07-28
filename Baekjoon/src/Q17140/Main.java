package Q17140;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


class Pair implements Comparable<Pair>{
	int idx, cnt;
	Pair(int idx, int cnt){
		this.idx = idx;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Pair p) {
		// TODO Auto-generated method stub
		if(this.cnt > p.cnt) {
			return 1;
		}else if(this.cnt == p.cnt) {
			if(this.idx > p.idx) return 1;
			else if(this.idx < p.idx) return -1;
		}else {
			return -1;
		}
		
		return 0;
	}
}

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map[][] = new int[100][100];
	static int r,c,k;
	static int rSize, cSize;
	static Pair p[] = new Pair[101];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Input();
		System.out.println(Solve());
	}
	
	public static void Input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		rSize = cSize = 3;
		
		for(int i=0; i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static int Solve() {
		
		if(map[r][c] == k) {
			return 0;
		}		
		
	
		for(int t = 1; t<=100;t++) {
			
			if(rSize >= cSize) {
				Rcal();
			}else {
				Ccal();
			}
			
			if(map[r][c] == k) {
				return t;
			}
		}
		
		return -1;
	}
	
	public static void Rcal() {
		
		int tmpCsize = cSize;
		
		for(int i=0; i<rSize;i++) {
			int size = 0;
			int mapIdx = 0;
			Init();
			
			for(int j=0; j<tmpCsize; j++) {
				if(map[i][j] == 0) continue;
				int idx = map[i][j];
				p[idx].cnt++;
				if(p[idx].cnt == 1) size++;
			}
			
			cSize = Math.max(cSize, size * 2);
			if(cSize > 100) cSize = 100;
			
			Arrays.sort(p,1,101);
			
			for(int j=0; j<cSize;j++) {
				map[i][j] = 0;
			}
			
			for(int k=1; k<=100;k++) {
				
				if(p[k].cnt == 0) continue;
				
				map[i][mapIdx] = p[k].idx;
				map[i][mapIdx+1] = p[k].cnt; 
				mapIdx += 2;
			}
		}
	}
	
	public static void Ccal() {
		
		int tmpRsize = rSize;
		
		for(int i=0; i<cSize;i++) {
			int size = 0;
			int mapIdx = 0;
			Init();
			
			for(int j=0; j<tmpRsize; j++) {
				if(map[j][i] == 0) continue;
				int idx = map[j][i];
				p[idx].cnt++;
				if(p[idx].cnt == 1) size++;
			}
			
			rSize = Math.max(rSize, size * 2);
			if(rSize > 100) rSize = 100;
			
			Arrays.sort(p,1,101);
			
			for(int j=0; j<rSize;j++) {
				map[j][i] = 0;
			}
			
			for(int k=1; k<=100;k++) {
				
				if(p[k].cnt == 0) continue;
				
				map[mapIdx][i] = p[k].idx;
				map[mapIdx+1][i] = p[k].cnt; 
				mapIdx += 2;
			}
		}
	}
	
	
	public static void Init() {
		for(int i=1; i<=100;i++) {
			p[i] = new Pair(i,0);
		}
	}

}
