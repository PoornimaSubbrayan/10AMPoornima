package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;

public class ExcelRead {

	public static void main(String[] args) throws IOException {

		// Locate the file
		File f = new File(
				"C:\\Users\\Thirumurugan S\\eclipse-workspace\\SampleMavenProgram\\target\\ExcelData\\TestData.xlsx");
		// To read the data from excel file
		FileInputStream fInp = new FileInputStream(f);
		// Type of workbook
		Workbook w = new XSSFWorkbook(fInp);

		// Get the Sheet
		Sheet s = w.getSheet("Testing123");

		// get the Row
		Row r = s.getRow(7);
		// get the cell value
		Cell c = r.getCell(2);
		System.out.println("The value in the given cell is: " + c);

		// Physical number of rows and columns
		System.out.println("Physical number of rows in the data sheet is: " + s.getPhysicalNumberOfRows());
		System.out.println("Physical number of cells in the data sheet is: " + r.getPhysicalNumberOfCells());
		// for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		// Row row = s.getRow(i);
		// for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		// Cell cell = row.getCell(j);
		// System.out.println(cell);
		// }
		// }

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType(); // 1-String, 2 -Date or numbers
				if (cellType == 1) {
					String value = cell.getStringCellValue();
					System.out.println(value);
				} else if (cellType == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("EEEEE MMMMM yyyy"); //dd-MM-yyyy
						String value = sim.format(dateCellValue);
						System.out.println(value);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long l = (long) numericCellValue;
						String value = String.valueOf(l);
						System.out.println(value);
					}
				}

			}
		}

	}

}
