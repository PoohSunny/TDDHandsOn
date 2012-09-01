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

	private int totalAmount = 0;
	private List<Money> change = new ArrayList<Money>();


	public int totalAmount() {
		return totalAmount;
	}


	public void insert(Money money) throws IllegalAccessException {
		if (money == null) throw new IllegalArgumentException("お金を入れてください");

			totalAmount += money.getValue();
			change.add(money);

	}


	public List<Money> refund() {
		return change ;
	}

}
