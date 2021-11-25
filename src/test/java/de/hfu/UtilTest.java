package de.hfu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilTest {

	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testIstErstesHalbesJahrException(){
		Util.istErstesHalbjahr(0);
	}
	@Test
	public void testIstErstesHalbesJahr() {
		int istHalbesJahr = 4;
		int istNichtHalbesJahr = 8;
		
		assertTrue(Util.istErstesHalbjahr(istHalbesJahr));
		assertFalse(Util.istErstesHalbjahr(istNichtHalbesJahr));
	}
}
