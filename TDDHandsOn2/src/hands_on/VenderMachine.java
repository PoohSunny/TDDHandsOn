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


	public Money insert(Money money) throws IllegalAccessException {
		if (money == null) throw new IllegalArgumentException("お金を入れてください");

		switch (money) {
		case COIN_1:
		case COIN_5:
		case BILL_5000:
		case BILL_10000:
			return money;
		default:
			changeList.add(money);
			return null;
		}

	}


	public List<Money> refund() {
		List<Money> changeList = new ArrayList<Money>(this.changeList);
		this.changeList.clear();
		return changeList;
	}

}
