package Q1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> que = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int len = N;
		
		for(int i=1;i<=N;i++) {
			que.add(i);
		}
		
		bw.write("<");
		while(!que.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				int temp = que.poll();
				que.add(temp);
			}
			//System.out.print(que.poll() + " ");
			bw.write(String.valueOf(que.poll()));
			if(!que.isEmpty()) {
				bw.write(", ");
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
		br.close();
		/*for(Integer i : que) {
			System.out.print(i + " ");
		}*/		
		
	}
	


}
