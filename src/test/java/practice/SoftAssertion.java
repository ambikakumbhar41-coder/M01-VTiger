package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	
	public void softAssertion() {
		String expectedFood="Biryani";
		String actualFood="Chiken Biryani";
		System.out.println("Soft assrtion starts");
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualFood, expectedFood);
		s.assertTrue(actualFood.contains(expectedFood));
		System.out.println("Soft assertion ends");
		s.assertAll();
	}

}
