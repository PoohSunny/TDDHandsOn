package hands_on;

public enum Money {
	COIN_10(10),COIN_50(50),COIN_100(100),COIN_500(500),BILL_1000(1000), COIN_1(1);

	private int value;

	private Money(int value){
		this.value = value;
	}


	public int getValue(){
		return value;
	}

}
