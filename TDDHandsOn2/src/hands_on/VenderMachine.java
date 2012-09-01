package hands_on;

public class VenderMachine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	}

	private int totalAmount = 0;


	public int totalAmount() {
		return totalAmount;
	}


	public void insert(Money money) {
		totalAmount += money.getValue();

	}

}
