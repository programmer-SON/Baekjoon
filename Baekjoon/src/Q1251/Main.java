package Q1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int len;
	
	static int idxArr[] = new int[3];
	static String alpha;
	static String answer = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		DFS(0,0);
		System.out.println(answer);
	}
		
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alpha = br.readLine();
		len = alpha.length();
		
		for(int i=0; i<len;i++) {
			answer += "z";
		}
	}
	
	public static void DFS(int n, int size) {
		if(n==2) {
			idxArr[n] = len -size;
			String str = "";
			int idx = 0;
			for(int i=0; i<3;i++) {
				String temp = alpha.substring(idx,idx+idxArr[i]);
				for(int j = temp.length()-1; j>=0; j--) {
					str += temp.charAt(j);
				}
				idx += idxArr[i];
			}
			answer = answer.compareTo(str) < 0 ? answer : str;
			return;
		}
		
		for(int i=1; i<=len-1-size;i++) {
			idxArr[n] = i;
			DFS(n+1,i+size);
		}
	}

}
