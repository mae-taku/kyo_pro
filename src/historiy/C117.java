package historiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author maetaku
 *・1 行目には、出店する店舗の数を表す整数 N 営業する月数を表す整数 M が半角スペース区切りでこの順で与えられます。
 *・2 行目には、1 店舗あたりの店舗の建設費用を表す整数 A、1 店舗あたりの毎月の人件費を表す整数 B、ラーメン 1 杯あたりの利益を表す整数 C が半角スペース区切りでこの順で与えられます。
 *・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、i 番目の店舗が M ヶ月間に販売したラーメンの杯数を表す整数 R_i が与えられます。
 *・入力は合計で 2 + N 行となり、入力値最終行の末尾に改行が 1 つ入ります。
 *
 *入力例
 *3 3
 *1000 1000 50
 *25
 *500
 */
public class C117 {
	public static void main(String[] ags) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String line2 = sc.nextLine();

		//M ヶ月間営業した時点で投下した費用以上の利益が出ていない店
		String[] storeAndMonth = line.split(" ", 0);
		String[] costs_build_person_Andbenefit = line2.split(" ", 0);

		List<store> stores = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(storeAndMonth[0]); i++) {
			String count = sc.nextLine();
			store s = new store();
			s.setStoreNum(i + 1);
			s.setFlag(profitAndLoss(
					Integer.parseInt(count),
					Integer.parseInt(costs_build_person_Andbenefit[2]),
					Integer.parseInt(storeAndMonth[1]),
					Integer.parseInt(costs_build_person_Andbenefit[0]),
					Integer.parseInt(costs_build_person_Andbenefit[1])));
			stores.add(s);
		}
		sc.close();
		int closeStore = 0;
		for (store s : stores) {
			if (s.getFlag()) {
				closeStore++;
			}
		}
		System.out.println(closeStore);
	}

	/**
	 * （ラーメン杯数×一杯あたりの利益）×稼働月ー建築費＋月間人件費
	 * @return 不採算判定（利益＜費用）
	 */
	static boolean profitAndLoss(int count, int benefit, int month, int buildingCost, int personalCost) {

		int profit = 0;
		profit = count * benefit;
		int cost = 0;
		cost = buildingCost + (personalCost * month);

		return profit < cost;

	}

	static class store {
		int storeNum;
		boolean flag;

		public void setStoreNum(int storeNum) {
			this.storeNum = storeNum;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		public int getStoreNum() {
			return storeNum;
		}

		public boolean getFlag() {
			return flag;
		}
	}

}
