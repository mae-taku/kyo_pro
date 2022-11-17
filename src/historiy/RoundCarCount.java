package historiy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundCarCount {

	/**
	 * N（車数）
	 * A-1
	 * A_2
	 * A_3
	 * A_N
	 */
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		List<Integer> countCar = new ArrayList<>();
		for (int i = 0; i < line; i++) {
			countCar.add(sc.nextInt());
		}
		sc.close();
		//1周目で取り出された場合、0週のため、マイナスからカウント。
		int count = -1;
		int targetnum = 1;
		/*
		 * countCarの要素がなくなるまで、for文で回す
		 * numが0と一致すると、配列から要素を取り出す＆numをインクリメント
		 * 不一致であれば、countをインクリメントし
		 * countCarの要素がなくなるまで、よりインクリメントしていく
		*/
		while (!(countCar.size() == 0)) {
			for (int i = 0; i < countCar.size(); i++) {
				if (countCar.get(i) == targetnum) {
					countCar.remove(i);
					/*
					 * removeすると、後ろの要素が繰り上がるが、カーソル一は動かない
					 * カーソル位置を一つ戻す。
					 * 2要素の１つ目とると、要素は繰り上がるが、カーソルは、2つ目を取ろうとして、エラーになる。
					 * */
					i--;
					targetnum++;
				}
			}
			count++;
		}
		System.out.println(count);
	}
}
