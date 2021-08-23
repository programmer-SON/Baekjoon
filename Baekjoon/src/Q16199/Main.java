package Q16199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int born[] = new int[3];
		int stand[] = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<3;i++) {
			born[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3;i++) {
			stand[i] = Integer.parseInt(st.nextToken());
		}
		
		int age1 = 0;
		int age2 = stand[0] - born[0];
		
		if(stand[0] > born[0]) {
			
			if(born[1] > stand[1]) {
				age1 = stand[0] - born[0] - 1;
			}else if(born[1] == stand[1]) {
				if(born[2] <= stand[2]) {
					age1 = stand[0] - born[0];
				}else {
					age1 = stand[0] - born[0]-1;
				}
			}else {
				age1 = stand[0] - born[0];
			}
		}else {
			age1 = 0;
		}
		
		System.out.println(age1);
		System.out.println(age2+1);
		System.out.println(age2);
		
	}

}
