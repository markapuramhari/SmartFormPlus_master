package com.cropin.dataproviders;

import org.testng.annotations.DataProvider;

import com.cropin.baseutil.BaseTest;
import com.cropin.commonutils.ExcelUtil;

/**
 * Description :Implements Data Provider required to fetch data from excel
 * @author shreya U
 */
public class CreateRequisitionDataProvider {

	/**
	 * Description   Data Provider to fetch data from  Excel file according to specified sheet name.
	 * @author Shreya Ugavekar
	 *
	 */
	@DataProvider(name = "TestDataProvider")
	public static Object[][] getTestData() {
		int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "Requisition-TestData");
		int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "Requisition-TestData");
		Object[][] workflowdata = new Object[noofrows][noofcols];

		for (int i = 1; i <= noofrows; i++) {
			String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "Requisition-TestData", i);

			for (int j = 0; j < data.length; j++) {

				workflowdata[i - 1][j] = data[j];
			}

		}
		return workflowdata;
	}

}
