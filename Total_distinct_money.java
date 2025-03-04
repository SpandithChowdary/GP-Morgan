package GP_morgan;

import java.util.*;

public class Total_distinct_money {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] grid = new int[R][C];
		
		for(int i=0 ; i< R; i++) {
			for(int j=0; j< C ; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[R][C];
		int[][] sum = new int[R][C];
		
		dp[0][0] = 1;
		sum[0][0] = 0;
		
		for(int i=0 ; i< R;i++) {
			for(int j=0;j<C ; j++) {
				if(i==0 && j==0) continue;
				
				// Paths from Top
				if(i>0) {
					dp[i][j] += dp[i-1][j];
					sum[i][j] += sum[i-1][j] + (dp[i-1][j]*grid[i][j]);
				}
				
				// Paths from Left
				if(j>0) {
					dp[i][j] += dp[i][j-1];
					sum[i][j] += sum[i][j-1] + (dp[i][j-1]*grid[i][j]);
				}
			}
		}
		
		System.out.println(dp[R-1][C-1]);
		System.out.println(sum[R-1][C-1]);
		sc.close();
	}
}
