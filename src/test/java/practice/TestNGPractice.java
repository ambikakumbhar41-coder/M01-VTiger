package practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(genericUtility.ListenersImplementation.class)
public class TestNGPractice {
	@Test(priority=5)
	public void AnuWakes() {
		Assert.fail();
	  System.out.println("Good morning");
	}
	@Test(priority=2,dependsOnMethods= {"AnuWakes","AnuChats"})
	public void AnuEats() {
		System.out.println("Anu eats mango");
	}
	@Test(priority=3,invocationCount=0)
	public void AnuMakesReels() {
		System.out.println("he makes funny reels");
	}
	@Ignore
	@Test(priority=4/*,enabled=false*/)
	public void AnuSlepps() {
		System.out.println("Good night");
	}
	@Test(priority=-2)
	public void AnuChats() {
		System.out.println("How are you?");
	}
}
