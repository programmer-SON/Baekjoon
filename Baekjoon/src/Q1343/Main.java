package Q1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String poly;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		System.out.println(Solve());
	}

	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		poly = br.readLine();
		//StringTokenizer st = new StringTokenizer(br.readLine());
	}
	
	public static String Solve() {
		StringBuffer sb = new StringBuffer();
		
		for(int start = 0; start < poly.length();) {
			if(poly.charAt(start) == '.') {
				sb.append(".");
				start++;
			}else {
				int cnt = 0;
				int idx = 0;
				for(int i=start; i<poly.length() && poly.charAt(i) == 'X';i++) {
					cnt++;
				}
				
				if(cnt % 2 != 0) return "-1";
				
				while(idx < cnt) {
					if(cnt - idx >= 4) {
						for(int i=0; i<4;i++) {
							sb.append("A");
							idx++;
						}
					}else {
						for(int i=0; i<2;i++) {
							sb.append("B");
							idx++;
						}
					}
				}
				start += cnt;
			}
		}
		return sb.toString();
	}
}

/*
 Reference : https://jaimemin.tistory.com/1321
 * */
