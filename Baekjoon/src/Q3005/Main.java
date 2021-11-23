package Q3005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R,C;
	static char map[][];
	static String mini = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
		Solve();
		System.out.println(mini);
	}
	
	public static void Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R;i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	}
	
	public static void Solve() {
		for(int i=0; i<R;i++) {
			String str = "";
			for(int j=0; j<C;j++) {
				if(map[i][j] == '#') {
					if(str.length() > 1) {
						mini =  (mini.equals("") || mini.compareTo(str) > 0) ? str : mini;
					}
					str = "";
				}else {
					str += map[i][j];
				}
			}
			if(!str.equals("")  && str.length() > 1) {
				if(str.length() > 1) {
					mini = (mini.equals("") || mini.compareTo(str) > 0)  ? str : mini;
				}
			}			
		}
		
		for(int i=0; i<C;i++) {
			String str = "";
			for(int j=0; j<R;j++) {
				if(map[j][i] == '#') {
					if(str.length() > 1) {
						mini = (mini.equals("") || mini.compareTo(str) > 0)  ? str : mini;
					}
					str = "";
				}else {
					str += map[j][i];
				}
			}
			if(!str.equals("") && str.length() > 1) {
				mini = (mini.equals("") || mini.compareTo(str) > 0) ? str : mini;
			}			
		}
				
	}

}
