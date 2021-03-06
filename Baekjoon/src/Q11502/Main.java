package Q11502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static boolean[] prime = new boolean[1000];
	static int store[] = new int[3];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input();
	}
	
	public static void Input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		Eratos();
		
		for(int t=0; t<T; t++) {
			int num = Integer.parseInt(br.readLine());
			if(Solve(num)) {
				System.out.println(store[0] + " " + store[1] + " " +store[2]);
			}else {
				System.out.println("0");
			}
		}
		
		br.close();
	}
	
	public static boolean Solve(int target) {
		for(int i=2; i<1000; i++) {
			if(prime[i]) continue;
			for(int j=2; j<1000;j++) {
				if(prime[j]) continue;
				for(int k=2; k<1000;k++) {
					if(prime[k]) continue;
					
					if(i+j+k == target) {
						store[0] = i;
						store[1] = j;
						store[2] = k;
						return true;
					}
				}
			}
		}
		
		return false;
	}	

	
	public static void Eratos() {
		
		for(int i=2; i<=(int)Math.sqrt(1000); i++) {
			if(prime[i]) continue; 
			for(int j=i+i; j<1000; j+=i) {
				prime[j] = true;
			}
		}
	}

}
