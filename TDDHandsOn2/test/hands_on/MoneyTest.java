package hands_on;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void 十円玉の額は10円() {
		assertEquals(10, Money.COIN_10.getValue());
	}
	@Test
	public void 五十円玉の額は50円() throws Exception {
		assertEquals(50, Money.COIN_50.getValue());
	}

	@Test
	public void 百円玉の額は100円() throws Exception {
		assertEquals(100,Money.COIN_100.getValue());
	}

	@Test
	public void 五百円玉の額は500円() throws Exception {
		assertEquals(500,Money.COIN_500.getValue());
	}

	@Test
	public void 千円札の額は1000円() throws Exception {
		assertEquals(1000,Money.BILL_1000.getValue( ));
	}
}
