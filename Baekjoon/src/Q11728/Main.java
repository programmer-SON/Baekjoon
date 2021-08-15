package Q11728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static long A[], B[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new long[N];
		B = new long[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}
		
		int aIdx =0, bIdx = 0;
		
		while(aIdx != N && bIdx != M) {
			if(A[aIdx] >= B[bIdx]) {
				bw.write(String.valueOf(B[bIdx]));
				bIdx++;
			}else {
				bw.write(String.valueOf(A[aIdx]));
				aIdx++;
			}
			bw.write(" ");
		}
		
		for(int i=aIdx; i<N; i++) {
			bw.write(String.valueOf(A[i]));
			bw.write(" ");
		}
		
		for(int i=bIdx; i<M; i++) {
			bw.write(String.valueOf(B[i]));
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
