package historiy;

/**
 * @author maetaku
 * 選択ソート
 * 配列の中から最小値（若しくは最大値）を探し、配列の先頭要素と交換することを繰り返す
 *
 */
public class ChoiseSort {

	public static void main(String[] args) {
		
		int[] dummy = { 3, 2, 1, 5, 6, 4 };

		//並べ替え（選択ソート）
		for (int i = 0; i < dummy.length; i++) {
			int pos = i;
			for (int j = i + 1; j < dummy.length; j++) {
				//i番以降で、iより小さい値があれば、posを更新
				if (dummy[j] < dummy[pos]) {
					pos = j;
				}
			}
			//入れ替え
			int w = dummy[i];
			//i番目に、最小値（pos）を入れる
			dummy[i] = dummy[pos];
			//最小値が入ってたところに、入れ替え前のi番目の値を入れ替える
			dummy[pos] = w;
		}

		for (int i : dummy) {
			System.out.print(i + " ");
		}
	}
}
