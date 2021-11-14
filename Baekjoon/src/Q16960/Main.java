package Q16960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int lamp[];
	static ArrayList<Integer> al[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Input();
		
		boolean flag = false;
		for(int i=0; i<al.length;i++) {
			flag= CheckLamp(i);
			
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
		
		
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N];
		lamp = new int[M+1];
		
		for(int i=0; i<al.length;i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<len;j++) {
				int num = Integer.parseInt(st.nextToken());
				al[i].add(num);
				lamp[num]++;
			}
		}
		
	}
		
	public static boolean CheckLamp(int idx) {
		
		for(int i=0; i<al[idx].size();i++) {
			int lampIdx = al[idx].get(i);
			lamp[lampIdx]--;
			
			if(lamp[lampIdx] <= 0) {
				lamp[lampIdx]++;
				return false;
			}
			lamp[lampIdx]++;
		}
		
		return true;
	}

}

//Reference : https://yabmoons.tistory.com/277
