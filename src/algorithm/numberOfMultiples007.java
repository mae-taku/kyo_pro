package algorithm;

import java.util.Scanner;

public class numberOfMultiples007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		String[] numXY = line.split(" ", 0);
		int count = 0;
		for(int i = 0; i < Integer.parseInt(numXY[0]); i++) {
			if(i % Integer.parseInt(numXY[1]) == 0 || i % Integer.parseInt(numXY[2]) == 0) {
				count++;
				}
		}
		System.out.println(count);
	}

}
