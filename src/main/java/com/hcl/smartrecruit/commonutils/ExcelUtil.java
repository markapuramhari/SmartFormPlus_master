package com.hcl.smartrecruit.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hcl.smartrecruit.baseutil.BaseTest;

/**
 * @author: Shreya U,Vivek Dogra,Aatish Slathia
 * @description : Implemented all the generic method for excel.
 */

public class ExcelUtil {
	private ExcelUtil() {

	}

	/**
	 * Description:Fetches the row count in the specified sheet
	 * @author:Shreya U,Vivek Dogra
	 * @param sPath 
	 * @param sSheet
	 */
	public  static synchronized int getRowCount(String sPath, String sSheet) {
		int iRowNum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			iRowNum = sht.getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iRowNum;
	}

	/**
	 * Description:Fetches the column count in the specified sheet
	 * @author:Vivek Dogra
	 * @param sSheet 
	 * @parm sPath 
	 */
	public synchronized static int getColoumCount(String sPath, String sSheet) {
		int colnum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			colnum = sht.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colnum;
	}

	/**
	 * Description:Fetches the data from the cell
	 * @author:Shreya U
	 * @param xlPAth 
	 * @param sheetName 
	 * @param rowNo 
	 * @param colNo
	 */
	public static synchronized  String getCellData(String xlPAth, String sheetName, int rowNo, int colNo) {
		DataFormatter dataFormatter = new DataFormatter();

		int iRowNum = 0;
		String data = null;
		try {
			FileInputStream fis = new FileInputStream(xlPAth);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			iRowNum = sht.getLastRowNum();
			if (rowNo <= iRowNum) {
				Cell cell = sht.getRow(rowNo).getCell(colNo);
				data = dataFormatter.formatCellValue(cell);
			} else {
				BaseTest.logger.info("Please provide the valid Row Count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Description : Fetch the row data from the excel sheet
	 * @author:Aatish Slathia
	 * @param sFilePath 
	 * @param sSheet 
	 * @param rowNo
	 */
	public  static synchronized  String[] getRowData(String sFilePath, String sSheet, int rowNo) {
		DataFormatter dataFormatter = new DataFormatter();
		String sData[] = null;
		try {
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iCellNum = sht.getRow(rowNo).getPhysicalNumberOfCells();
			sData = new String[iCellNum];
			for (int j = 0; j < iCellNum; j++) {
				Cell cell = sht.getRow(rowNo).getCell(j);
				sData[j] = dataFormatter.formatCellValue(cell);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return sData;
	}

	/**
	 * Description :Fetches  the column data from the specified sheet
	 * @author:Vivek Dogra
	 * @param sFilePath 
	 * @param sSheet 
	 * @param colno                   
	 */
	public static synchronized  String[] getColoumData(String sFilePath, String sSheet, int colno) {
		DataFormatter dataFormatter = new DataFormatter();
		String sData[] = null;
		try {
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iRowNum = sht.getLastRowNum();
			sData = new String[iRowNum];

			for (int i = 1; i <= iRowNum; i++) {
				Cell cell = sht.getRow(i).getCell(colno);
				sData[i - 1] = dataFormatter.formatCellValue(cell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sData;
	}

	/**
	 * Description Fetches the column index
	 * @author:Shreya U
	 * @param sFilePath 
	 * @param sSheet 
	 * @param colName 
	 */
	public static synchronized  int getColoumIndex(String filepath, String sSheet, String colName) {
		String[] firstrow = getRowData(filepath, sSheet, 0);
		int index = 0;
		for (int i = 0; i < firstrow.length; i++) {
			if (firstrow[i].equalsIgnoreCase(colName)) {
				index = i;
			}
		}
		return index;

	}

	/**
	 * Description: Checks if an array contains blank
	 * @author:Aatish Slathia
	 * @param data 
	 * @return blank
	 */
	public static synchronized  boolean doesArrayContainsBlank(String[] data) {
		boolean blank = false;

		for (int i = 0; i < data.length; i++) {
			if (data[i].isEmpty() || data[i] == null) {
				blank = true;
				break;
			}
		}
		return blank;
	}

	/**
	 * Description :Reads the excel data
	 * @author:Vivek D
	 * @param sFilePath
	 * @param sSheet
	 * @param sTestCaseId 
	 * @return SData
	 */
	public static synchronized  String[] toReadExcelData(String sFilePath, String sSheet, String sTestCaseId) {
		DataFormatter dataFormatter = new DataFormatter();
		String SData[] = null;
		try {
			// File Read
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iRowNum = sht.getLastRowNum();
			for (int i = 0; i <= iRowNum; i++) {
				if (sht.getRow(i).getCell(0).toString().equals(sTestCaseId)) {
					int iCellNum = sht.getRow(i).getPhysicalNumberOfCells();
					SData = new String[iCellNum];
					for (int j = 0; j < iCellNum; j++) {
						Cell cell = sht.getRow(i).getCell(j);
						SData[j] = dataFormatter.formatCellValue(cell);
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return SData;

	}

	/**
	 * Description :Fetches the column index
	 * @author:Shreya U
	 * @param sFilePath
	 * @param sSheet
	 * @param colName
	 * @param firstRowName 
	 * @return index
	 */
	public static synchronized  int getColoumIndex(String filepath, String sSheet, String colName, String firstRowName) {
		String[] firstRow = ExcelUtil.toReadExcelData(filepath, sSheet, firstRowName);
		int index = 0;
		for (int i = 0; i < firstRow.length; i++) {
			if (firstRow[i].equalsIgnoreCase(colName)) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * Description: Fetches  the cell count
	 * @author:Shreya U
	 * @param sPath
	 * @param sSheet
	 * @param sSheeet
	 * @param row 
	 * @return column
	 */
	public static synchronized  int getCellCount(String sPath, String sSheeet, int row) {
		int colnum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheeet);
			colnum = sht.getRow(row).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colnum;
	}

	/**
	 * Description : Creates a new cell.
	 * @author:Vivek D
	 * @param sPath
	 * @param sSheet
	 * @param sSheeet
	 * @param row 
	 */
	public static synchronized  void createCell(String sPath, String sSheeet, int row) {
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheeet);
			sht.getRow(row).createCell(6).setCellValue(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	/**
	 * Description: Writes to the excel cell
	 * @author:Aatish Slathia 
	 * @param sPath,
	 * @param sSheet
	 * @param sSheeet
	 * @param row
	 * @param result
	 * @param count
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException  
	 */
	public synchronized static void writeResult(String sheet, String result,String path,int row,int count) throws IOException, EncryptedDocumentException, InvalidFormatException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook Book = (Workbook) WorkbookFactory.create(fi);
		Book.getSheet(sheet).getRow(row).createCell(count).setCellValue(result);
		FileOutputStream fo = new FileOutputStream(f);
		fo.flush();
		Book.write(fo);
		fo.close();
		Book.close();
	
		}

}
