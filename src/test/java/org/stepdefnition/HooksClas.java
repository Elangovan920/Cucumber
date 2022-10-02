package org.stepdefnition;

import java.util.Date;

import org.baseclass.BaseClass;

import io.cucumber.java.*;

public class HooksClas extends BaseClass {

	@Before(value="@All",order=1)
	public void m1() {
		  browserLaunch("chrome");
		   urlLaunch( "https://www.amazon.in");
         System.out.println("Before 1");
	}
	@After(value="@All",order=2)
	public void m2() {
		driver.quit();
		
System.out.println("After1");
	}
	
	@Before(value="@regression",order=2)
	public void m3() {
		Date d = new Date();
		System.out.println("Scenario started at  "+d);
		
	}
	@After(value="@sanity",order=1)
	public void m4() {
		Date d = new Date();
		System.out.println("Scenario ended at  "+d);
		
		
	}
	
}
