package test.qtpselenium.com;

import com.qtpselenium.util.Xls_Reader;

public class TestDataExtract {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Xls_Reader x = new Xls_Reader((System.getProperty("user.dir") + "\\src\\com\\qtpselenium\\xls\\B suite.xlsx"));
		getData(x, "TestCase_B1");
		
		
	}
	
	//return test data from a test in two dimensional array
	public static Object[][] getData(Xls_Reader xls,String testCasename)
	{
		//if the sheet is not present 
		if(!xls.isSheetExist(testCasename))
		{
			xls=null; //for memory clean up
			//there is no test data so 0 and 1 because exceute test case once
			return new Object[1][0];
		}
		
		
		int rows= xls.getRowCount(testCasename);
		int cols= xls.getColumnCount(testCasename);
		System.out.println("Rows are "+ rows + "cols are "+ cols);
		
		//add the data into objetc array
				Object[][] data = new Object[rows-1][cols-3]; 
				
		//xtract data 
		for(int rowNum=2; rowNum<=rows;rowNum++)
		{
			for(int colNum=0; colNum<cols-3;colNum++)
			{
				//System.out.print(xls.getCellData(testCasename, colNum, rowNum)+ "---");
				data[rowNum-2][colNum] =xls.getCellData(testCasename, colNum, rowNum);
				
			}
			//System.out.println();
		}
		
		return data;
		
	}
	
	
}
