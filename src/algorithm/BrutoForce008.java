package algorithm;

import java.util.Scanner;

public class BrutoForce008 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int count = 0;
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <= N ; j++) {
				if(i + j > S) {
					continue;
				}
				count++;
			}
		}
		System.out.println(count);
	}

}
