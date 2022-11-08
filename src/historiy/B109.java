package historiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B109 {

	/**
	 * 0 1 2 3 4
	 * N H W P Q
	 * 予約されている座席の数 N、映画館の座席の縦の数 H、映画館の座席の横の数 W、最も見やすい席の p 座標、q 座標を表す P, Q 
	 * p_1 q_1
	 * p_2 q_2
	 * ...
	 * p_N q_N
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		//		String line = "9 4 5 2 3 ";
		String[] inpuStrings = line.split(" ", 0);
		//		String[] dummy = { "1 0", "1 2", "1 3", "1 4", "2 2", "2 3", "2 4", "3 3", "3 4" };
		List<String> bookedSheet = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(inpuStrings[0]); i++) {
			String booked = sc.nextLine();
			//			String booked = dummy[i];
			bookedSheet.add(booked);
		}

		List<String> sheet = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(inpuStrings[1]); i++) {
			for (int j = 0; j < Integer.parseInt(inpuStrings[2]); j++) {
				sheet.add(i + " " + j);
			}
		}
		for (String s : bookedSheet) {
			sheet.removeIf(n -> (n.matches(s)));
		}
		List<String[]> sheetList = new ArrayList<>();
		for (String s : sheet) {
			String[] temp = new String[2];
			String num[] = s.split(" ", 0);
			int prio = 0;
			int n = 0;
			int m = 0;
			n = Math.abs(
					(Integer.parseInt(inpuStrings[3]) - Integer.parseInt(num[0])));
			m = Math.abs((Integer.parseInt(inpuStrings[4]) - Integer.parseInt(num[1])));
			prio = n + m;
			temp[0] = Integer.valueOf(prio).toString();
			temp[1] = s;
			sheetList.add(temp);

		}
		int count = 0;
		boolean stop = false;
		List<String> result = new ArrayList<>();
		for (int j = 0; j < sheetList.size(); j++) {
			for (int i = 1; i < sheetList.size(); i++) {
				String[] str = new String[2];
				str = sheetList.get(i);
				if (count == Integer.parseInt(str[0])) {
					result.add(str[1]);
					stop = true;
				}
			}
			if (stop) {
				break;
			}
			count++;
		}
		result.forEach(s -> System.out.println(s));
		//		int target = (P - p_n) + (Q - q_n);
		//        num1 = Math.abs(num1);

	}
}