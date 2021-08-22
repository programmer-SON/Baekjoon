package Q2204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		while(n != 0) {
			String mini = br.readLine();
			for(int i=1; i<n;i++) {
				String str = br.readLine();
				
				mini = mini.compareToIgnoreCase(str) > 0 ? str : mini;
			}
			
			System.out.println(mini);
			
			n = Integer.parseInt(br.readLine());
		}
		
		br.close();
	}

}
