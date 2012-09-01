package hands_on;

import static org.junit.Assert.*;

import java.awt.geom.QuadCurve2D;

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
		vm.insert(null);
		assertEquals(0,vm.totalAmount());
	}

	//TODO 1円玉など扱えないお金を入れたときのテストをする

}
