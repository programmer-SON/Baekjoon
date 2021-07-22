package Q16967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int H,W,X,Y;
	static int A[][], B[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		A = new int[H][W];
		B = new int[H+X][W+Y];
		
		for(int i=0; i<H+X;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W+Y;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Solve();
		
		for(int i=0; i<H;i++) {
			for(int j=0; j<W;j++) {
				bw.write(String.valueOf(A[i][j]) + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	public static void Solve() {
		
		for(int i=0; i<H;i++) {
			for(int j=0; j<W;j++) {
				if(i>=X && j>=Y) {
					A[i][j] = B[i][j] - A[i-X][j-Y];
				}else {
					
					A[i][j] = B[i][j];
				}
			}
		}
	}
	

}

/*
 * Âü°í : https://docs16.tistory.com/45
 */
