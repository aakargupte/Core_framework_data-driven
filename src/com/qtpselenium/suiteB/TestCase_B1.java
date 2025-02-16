package com.qtpselenium.suiteB;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class TestCase_B1 extends TestSuiteBase{
	
	String runmodes[]=null;  //this is to check the run mode of data in test case with the values Y or N
	static int count=-1;
	
	@BeforeTest
	public void checkTestSkip()
	{
		if(!TestUtil.isTestCaseRunnable(suiteBXls, this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping testcase as test"+this.getClass().getSimpleName()+" case runmode set to no in test case"); //logs
			throw new SkipException("Test Case skipped as runmode set to no");//reports
		}
		
		//load runmodes off the test
		runmodes= TestUtil.getDataSetRunmodes(suiteBXls, this.getClass().getSimpleName());
	}
	@Test(dataProvider="getTestData")
	public void testCaseB1(String col1,String col2,String col3,String col4) //Arguments should be same as number of columns
	{
		
		//test run mode of current data set
				count++;
				if(!runmodes[count].equalsIgnoreCase("Y"))
				{
					throw new SkipException("Runmode for test set data set to NO"+count);
				}
				
		//test method would be called 4 times
		APP_LOGS.debug("Executing TestCase_B1");
		APP_LOGS.debug(col1+ "--"+col2+"---"+col3+"--"+col4 );
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		return TestUtil.getData(suiteBXls, this.getClass().getSimpleName());
	}
}
