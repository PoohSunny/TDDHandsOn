package hands_on;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuiceTest {

	@Test
	public void コーラという名前のジュースから名前としてコーラが取得できること() {
		Juice juice = new Juice("コーラ");
		assertEquals("コーラ", juice.getName());
	}



}
