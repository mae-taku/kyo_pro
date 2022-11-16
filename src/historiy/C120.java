package historiy;

import java.util.ArrayList;
import java.util.List;
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
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int charCount = sc.nextInt();
		String r = sc.nextLine();//改行をスキャン
		String model = sc.nextLine();
		String target = sc.nextLine();

		sc.close();

		char[] splitModel = model.toCharArray();
		char[] splitTarget = target.toCharArray();
		List<Integer> modelParttern = parttern(splitModel, charCount);
		List<Integer> targetPartten = parttern(splitTarget, charCount);

		System.out.println(modelParttern == targetPartten);
		
		int count = 0;
		for(int i = 0 ; i < splitModel.length; i ++) {
			for(int j = 0 ; j < splitTarget.length; j++) {
				if(Character.compare(splitModel[i], splitTarget[j]) == 0) {
					i++;
				}
			}
		}
		for(char c : splitModel) {
		
		}
	}

	static List<Integer> parttern(char[] c, int charCount) {
		List<Integer> parttern = new ArrayList<>();
		for (int i = 0; i < c.length; i++) {
			int count = 0;
			//要素が最大値か否か。最大値の場合、最初の要素と比較する。以外は、次の要素と比較。
			if (i == charCount - 1) {
				if (Character.compare(c[i], c[0]) == 0) {
					count++;
				} else if (Character.compare(c[i], c[i + 1]) == 0) {
					count ++;
				} else {
					parttern.add(count);
				}
			}
		}
		return parttern;
	}
}
