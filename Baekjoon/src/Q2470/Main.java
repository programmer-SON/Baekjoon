package Q2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int mini = Integer.MAX_VALUE;
		int small=-1, big=-1;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(mini > Math.abs(sum)) {
				small = arr[start];
				big = arr[end];
				if(sum == 0) break;
				mini = Math.abs(sum);
			}
			
			if(sum < 0) {
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(small + " " + big);
	}

}

/*
 Reference : https://ansohxxn.github.io/boj/2470/
 */
