package Q16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M,R,P;
	static long map[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		Print();
		
		bw.close();
		br.close();
	}
	
	public static void Input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new long[N][M];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R;i++) {
			int n = Integer.parseInt(st.nextToken());
			solve(n);
		}		
	}
	
	public static void solve(int num) {
		switch(num) {
			case 1 :
				Method1();
				break;
			case 2 :
				Method2();
				break;
			case 3 :
				Method3();
				break;
			case 4 :
				Method4();
				break;
			case 5 :
				Method5();
				break;
			default :
				Method6();
		}
	}
	
	public static void Method1() {
		
		for(int i=0, j=N-1; i<N/2;i++) {
			for(int k=0; k<M;k++) {
				long temp = map[i][k];
				map[i][k] = map[j-i][k];
				map[j-i][k] = temp;
			}
		}
	}
	
	public static void Method2() {
		
		for(int i=0; i<N;i++) {
			for(int j=M-1, k=0; k<M/2;k++) {
				long temp = map[i][k];
				map[i][k] = map[i][j-k];
				map[i][j-k] = temp;
			}
		}
	}
	
	public static void Method3() {
		long tmpMap[][];
		SWAP();		
		
		tmpMap = new long[N][M];
		
		for(int i=0; i<map.length;i++) {
			for(int j=0; j<map[i].length;j++) {
				tmpMap[j][map.length-1-i] = map[i][j];
			}
		}
		
		map = tmpMap;
	}
	
	public static void Method4() {
		long tmpMap[][];
		SWAP();
		
		tmpMap = new long[N][M];
		
		for(int i=0; i<map.length;i++) {
			for(int j=0; j<map[i].length;j++) {
				tmpMap[map[i].length-1-j][i] = map[i][j];
			}
		}
		
		map = tmpMap;
	}
	
	public static void Method5() {
		long tmpMap[][];
		
		tmpMap = new long[N][M];
		
		//1 -> 2
		for(int i=0; i<N/2;i++) {
			for(int j=0; j<M/2;j++) {
				tmpMap[i][M/2+j] = map[i][j];
			}
		}
		
		//2 -> 3
		for(int i=0; i<N/2;i++) {
			for(int j=M/2; j<M;j++) {
				tmpMap[N/2+i][j] = map[i][j];
			}
		}
		
		//3->4
		for(int i=N/2; i<N;i++) {
			for(int j=M/2; j<M;j++) {
				tmpMap[i][j-M/2] = map[i][j];
			}
		}

		//4->1
		for(int i=N/2; i<N;i++) {
			for(int j=0; j<M/2;j++) {
				tmpMap[i-N/2][j] = map[i][j];
			}
		}
		
		map = tmpMap;
	}
	
	public static void Method6() {
		long tmpMap[][];
		
		tmpMap = new long[N][M];
		
		//1 -> 4
		for(int i=0; i<N/2;i++) {
			for(int j=0; j<M/2;j++) {
				tmpMap[N/2+i][j] = map[i][j];
			}
		}
		
		//4 -> 3
		for(int i=N/2; i<N;i++) {
			for(int j=0; j<M/2;j++) {
				tmpMap[i][M/2+j] = map[i][j];
			}
		}
		
		//3->2
		for(int i=N/2; i<N;i++) {
			for(int j=M/2; j<M;j++) {
				tmpMap[i-N/2][j] = map[i][j];
			}
		}

		//2->1
		for(int i=0; i<N/2;i++) {
			for(int j=M/2; j<M;j++) {
				tmpMap[i][j-M/2] = map[i][j];
			}
		}
		
		map = tmpMap;
	}
	
	public static void Print() throws IOException {
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				bw.write(String.valueOf(map[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
	
	public static void SWAP() {
		int tmp = N;
		N = M;
		M = tmp;
	}
}
