package Q17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N;
	static int A[][];
	static int label[][];
	static Pair line[] = new Pair[4];
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		Solve();
		System.out.println(ans);
	}
	
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		label = new int[N][N];
		
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	
	public static void Solve() {
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				for(int d1 = 1; d1<=j; d1++) {
					for(int d2 = 1; d2 < N - j; d2++) {
						if(CheckLine(i,j,d1,d2)) {
							line[0] = new Pair(i,j);
							line[1] = new Pair(i+d1, j-d1);
							line[2] = new Pair(i+d2, j+d2);
							line[3] = new Pair(i+d2+d1, j+d2-d1);
							MakeArea();
							Cal();
						}
					}
				}
			}
		}
		

	}
	
	public static boolean CheckLine(int x, int y, int d1, int d2) {
		if(x+d1 >= N || y-d1 < 0) return false;
		if(x+d2 >= N || y+d2 >= N) return false;
		if(x+d1+d2 >= N || y-d1+d2 >= N) return false;
		if(x+d2+d1 >= N | y+d2-d1 < 0) return false;
			
		return true;
	}
	
	public static void MakeArea() {
		
		for(int i=0; i<N;i++) {
			Arrays.fill(label[i], 0);
		}
		
		int area = 0;
		
		for(int i=0; i<line[1].x; i++) {
			if(i>= line[0].x) area++;
			for(int j=0; j<=line[0].y-area; j++) {
				label[i][j] = 1;
			}
		}
		
		area = 0;
		
		for(int i=0; i<=line[2].x; i++) {
			if(i > line[0].x) area++;
			for(int j=line[0].y + 1 + area; j<N; j++) {
				label[i][j] = 2;
			}
		}
		
		area = 0;
		
		
		   for (int i = N - 1; i >= line[1].x; i--){
		        if (i < line[3].x) area++;
		        for (int j = 0; j < line[3].y - area; j++){
		            label[i][j] = 3;
		        }
		    }


		
		
		area = 0;
		for(int i=N-1; i>line[2].x; i--) {
			
			if(i<=line[3].x) area++;
			for(int j=line[3].y+area; j<N; j++) {
				label[i][j] = 4;
			}
			
		}
		
	}
	
	public static void Cal() {
		int result[] = new int[5];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result[label[i][j]] += A[i][j];
			}
		}
		
		Arrays.sort(result);
		
		ans = Math.min(ans, result[4] - result[0]);
	}

}
