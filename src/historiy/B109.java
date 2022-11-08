package historiy;

import java.awt.Point;
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

		//		dummy[0]="3.0";
		List<Point> bookedSheet = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(inpuStrings[0]); i++) {
			String booked = sc.nextLine();
			//			String[] temp = dummy[i].split(" ", 0);
			String[] temp = booked.split(" ", 0);
			Point pbooked = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			bookedSheet.add(pbooked);
		}
		//		見やすい席をリストアップ

		List<sheet> sheet = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(inpuStrings[1]); i++) {
			for (int j = 0; j < Integer.parseInt(inpuStrings[2]); j++) {
				Point p = new Point(i, j);
				sheet s = new sheet(p);
				int prio = 0;
				int n = 0;
				int m = 0;
				n = Math.abs(
						(Integer.parseInt(inpuStrings[3]) - i));
				m = Math.abs((Integer.parseInt(inpuStrings[4]) - j));
				prio = n + m;
				s.setPrio(prio);
				sheet.add(s);
			}
		}

		for (int i = 0; i < sheet.size(); i++) {
			for (Point p : bookedSheet) {
				if (sheet.get(i).getsheet().equals(p)) {
					sheet.remove(i);
					i--;
					break;
				}
			}
		}
		//		全席の優先順位を0から順に取り出す。
		int index = 0;
		List<String> ans = new ArrayList<>();
		while (ans.isEmpty()) {
			for (sheet s : sheet) {
				if (s.getprio() == index) {
					ans.add(s.toString());
				}
			}
			index++;
		}

		ans.forEach(s -> System.out.println(s));

	}

	static class sheet {
		Point p;
		int i;

		public sheet(Point point) {
			// TODO 自動生成されたコンストラクター・スタブ
			this.p = point;
		}

		public String toString() {
			int x = (int) p.getX();
			int y = (int) p.getY();
			return x + " " + y;
		}

		public Point getsheet() {
			return this.p;
		}

		public void setPrio(int i) {
			this.i = i;
		}

		public int getprio() {
			return this.i;
		}
	}
}