//老师，这个题不会，找了网上的学习
import java.util.*;

public class SecondPro {

	public static void main(String[] args) {
		int m = 1;
		int[][] a = new int[6][6];
		for (int n = 0; n <= 3; n++) {
			for (int j = n; j < 6 - n; j++) 
				a[j][n] = m++;
			for (int i = n + 1; i < 6 - n; i++)
				a[6 - n - 1][i] = m++;
			for (int j = 6 - n - 2; j >= n; j--)
				a[j][6 - n - 1] = m++;
			for (int i = 6 - n - 2; i > n; i--)
				a[n][i] = m++;
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				System.out.print(" " + a[i][j] + " ");
			System.out.print("\n");
		}
	}
}