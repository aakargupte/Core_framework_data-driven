package com.qtpselenium.suiteC;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class TestCase_C2 extends TestSuiteBase{

	@BeforeTest
	public void checkTestSkip()
	{
		if(!TestUtil.isTestCaseRunnable(suiteCXls, this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping testcase as test"+this.getClass().getSimpleName()+" case runmode set to no in test case"); //logs
			throw new SkipException("Test Case skipped as runmode set to no");//reports
		}
	}
	@Test
	public void testCaseC2()
	{
		System.out.println("TestCaseC2");
	}
}
