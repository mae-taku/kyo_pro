package algorithm;

import java.util.Scanner;

public class numberOfMultiples008 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		boolean flag = false;

		for (int i = 0; i < Math.pow(2, N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((1 & i >> j) == 1) {
					sum += nums[j];
					if (sum == S) {
						flag = true;
						break;
					}
				}
			}
		}
		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
