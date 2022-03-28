package sampletest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion1 {
	@Test
	public void AssersionStringcheck() {
		String expected="Abhishek is LoverBoy";
		String Actual="Abhishek is CuteBoy";
		Assert.assertEquals(Actual, expected);
	}
		@Test
		public void  AssersionIntcheck() {
		int i=1;
		int j=3;
		Assert.assertEquals(1, 3);
	}
		@Test
		public void AssersionBoolean() {
			boolean Ravi = true;
			boolean Kiran = false;
			Assert.assertEquals(Ravi, Kiran);
			
		}
		@Test
		public void SoftAssersioncheck() {
			SoftAssert sa = new SoftAssert();
			String Exc="Murli is equal to bruceely";
			String Act="Murli is more than bruceely";
			sa.assertEquals(Exc, Act);
			sa.assertAll();
			
		}

}
