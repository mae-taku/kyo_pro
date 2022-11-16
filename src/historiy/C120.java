package historiy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author maetaku
 * ・1 行目には、リースを構成する花の数を表す整数 N が与えられます。
 * ・2 行目には、1 つめのリースの状態を表す文字列 S_1 が与えられます。S_1 は英字小文字からなり、それぞれの文字が花の種類に対応します。同じ種類の文字の場合は同じ種類の花であることを表します。
 * ・3 行目には、2 つめのリースの状態を表す文字列 S_2 が与えられます。S_1 と同様に、英字小文字からなります。
 * ・入力は合計で 3 行となり、入力値最終行の末尾に改行が 1 つ入ります。
 * 
 * 入力例
 * 5
 * baaab
 * aabba
 */
public class C120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int charCount = sc.nextInt();
		String r = sc.nextLine();//改行をスキャン
		String model = sc.nextLine();
		String target = sc.nextLine();

		sc.close();

		char[] splitModel = model.toCharArray();
		char[] splitTarget = target.toCharArray();
		boolean result = false;

		char[] temp = splitModel;
		for (int i = 0; i < splitModel.length; i++) {
			temp = sort(temp, charCount);
			if (Arrays.equals(temp, splitTarget)) {
				result = true;
				break;
			}
		}
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static char[] sort(char[] charArray, int count) {
		char[] temp = new char[count];
		for (int i = 0, j = 1; i < charArray.length; i++, j++) {
			//			char c = splitModel[i];
			if (j < charArray.length) {
				temp[i] = charArray[j];
			} else {
				temp[i] = charArray[0];
			}
		}
		return temp;
	}
}
