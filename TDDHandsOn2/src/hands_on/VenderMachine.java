package hands_on;

import java.util.ArrayList;
import java.util.List;

public class VenderMachine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	}

	private List<Money> changeList = new ArrayList<Money>();


	public int totalAmount() {
		int totalAmount = 0;
		for (int i = 0; i < changeList.size(); i++) {
			totalAmount += changeList.get(i).getValue();

		}
		return totalAmount;
	}


	public void insert(Money money) throws IllegalAccessException {
		if (money == null) throw new IllegalArgumentException("お金を入れてください");

			changeList.add(money);

	}


	public List<Money> refund() {
		return changeList ;
	}

}
