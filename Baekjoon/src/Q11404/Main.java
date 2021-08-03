package Q11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];
	static final int INF =  10000000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Input();
		FloydWarshall();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=N;i++) {
			for(int j=1;j<=N; j++) {
				if(map[i][j] >= INF) bw.write("0 ");
                else bw.write(String.valueOf(map[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=1; i<=N;i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], c);
		}
		br.close();
	}
	
	public static void FloydWarshall() {
		for(int i=1; i<=N;i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(j == k) {
						map[j][k] = 0;
					}else {
						if(map[j][i] + map[i][k] < map[j][k]) {
							map[j][k] = map[j][i] + map[i][k];
						}
					}
				}
			}
		}
	}

}
