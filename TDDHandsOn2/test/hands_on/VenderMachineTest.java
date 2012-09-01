package hands_on;

import static org.junit.Assert.*;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VenderMachineTest {


	private VenderMachine vm;

	/**
	 * お金は、enumで表現
	 * 実装：お金が取り出せる
	 * 各コイン・紙幣に書いてある、額が取り出せる
	 *
	 * ステップ０
	 * お金が投入できる
	 * 総計が出せる
	 * 投入が複数回できる
	 * →ここまで済み
	 * 払い戻しができる
	 * つり銭として出てくるのは、総計と同じ
	 *
	 *
	 */

	@Before
	public void before() throws Exception {
		vm = new VenderMachine();

	}

	@Test
	public void お金を投入していないときは合計は0円() throws Exception {
		assertEquals(0,vm.totalAmount());
	}

	@Test
	public void 十円玉を入れたときは合計は10円() throws Exception {

		vm.insert(Money.COIN_10);
		assertEquals(10,vm.totalAmount());
	}

	@Test
	public void 五十円玉を入れたときは合計は50円() throws Exception {
		vm.insert(Money.COIN_50);
		assertEquals(50,vm.totalAmount());

	}

	@Test
	public void 五十円玉と百円玉を入れたときは合計は150円() throws Exception {
		vm.insert(Money.COIN_50);
		vm.insert(Money.COIN_100);
		assertEquals(150,vm.totalAmount());
	}

	@Test
	public void お金でないものを入れたときは合計は0円() throws Exception {

		try {
			vm.insert(null);
		} catch (IllegalArgumentException 無視する) {
		}
		assertEquals(0,vm.totalAmount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void お金でないものを入れたときはエラー() throws Exception {
		vm.insert(null);
	}

	@Test
	public void お金を投入していないときはつり銭は空リストで返す() throws Exception {
		assertEquals(Arrays.asList(), vm.refund());
	}

	@Test
	public void 五百円玉を入れて払い戻ししたときはつり銭は500円() throws Exception {
		vm.insert(Money.COIN_500);
		assertRefund(Arrays.asList(Money.COIN_500));
	}

	@Test
	public void 千円と百円を入れて払い戻ししたときはつり銭は千円と百円() throws Exception {
		vm.insert(Money.BILL_1000);
		vm.insert(Money.COIN_100);
		assertRefund(Arrays.asList(Money.BILL_1000, Money.COIN_100));
	}

	@Test
	public void お金でないものだけ投入したときはつり銭は空リストで返す() throws Exception {
		try {
			vm.insert(null);
			
		} catch (IllegalArgumentException 無視する) {
		}
		assertEquals(Arrays.asList(), vm.refund());
	}

	@Test
	public void 百円を入れて次にお金でないものを入れた時は百円を返す() throws Exception {
		vm.insert(Money.COIN_100);
		try {
			vm.insert(null);
		} catch (IllegalArgumentException 無視する) {
		}
		assertRefund(Arrays.asList(Money.COIN_100));

	}

	@Test
	public void お金でないものを入れて次に千円を入れた時は千円を返す() throws Exception {
		try {
			vm.insert(null);
		} catch (IllegalArgumentException 無視する) {
		}
		vm.insert(Money.BILL_1000);
		assertRefund(Arrays.asList(Money.BILL_1000));

	}

	@Test
	public void 十円を投入しつり銭を出したあとの合計金額がゼロ() throws Exception {
		vm.insert(Money.COIN_10);
		vm.refund();
		assertEquals(0, vm.totalAmount());
	}

	@Test
	public void 十円を投入しつり銭を出したあともう一度つり銭を出したら空のリストを返す() throws Exception {
		vm.insert(Money.COIN_10);
		vm.refund();
		assertEquals(Arrays.asList(), vm.refund());
	}

	/**
	 * refundのテストはこれで賄えるので略
	 * @throws Exception
	 */
	@Test
	public void 百円を入れてつり銭を出したあともう一度五十円を入れると合計金額は50円() throws Exception {
		vm.insert(Money.COIN_100);
		vm.refund();
		vm.insert(Money.COIN_50);

		assertEquals(50, vm.totalAmount());

	}

	//TODO 合計額が大きかった場合に、桁あふれしないこと

	private void assertRefund(List<Money> list) {
		assertEquals(list, vm.refund());
	}

	@Test
	public void 一円を入れるとつり銭として一円を返し合計金額はゼロ() throws Exception {
		assertEquals(Money.COIN_1, vm.insert(Money.COIN_1));
		assertEquals(0, vm.totalAmount());
	}

	@Test
	public void 五円を入れるとつり銭として五円を返し合計金額はゼロ() throws Exception {
		assertEquals(Money.COIN_5, vm.insert(Money.COIN_5));
		assertEquals(0, vm.totalAmount());
	}

	@Test
	public void 五千円を入れるとつり銭として五千円を返し合計金額はゼロ() throws Exception {
		assertEquals(Money.BILL_5000, vm.insert(Money.BILL_5000));
		assertEquals(0, vm.totalAmount());
	}

	@Test
	public void 一万円を入れるとつり銭として一万円を返し合計金額はゼロ() throws Exception {
		assertEquals(Money.BILL_10000, vm.insert(Money.BILL_10000));
		assertEquals(0, vm.totalAmount());
	}
	//TODO メソッド名の変更



}
