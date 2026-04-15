package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionPractice {
	
	@Test
	public void strictLevelComparision(){
		String expectedName="ramu";
		String actualName="ramu";
		System.out.println("hard assrtion starts");
		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualName.equals(expectedName), true);
		System.out.println("Hard assetion mid");
		Assert.assertFalse(actualName.equals(expectedName));
		Assert.assertTrue(actualName.contains(expectedName));
		System.out.println("Hard assertion ends");
		
	}

}
