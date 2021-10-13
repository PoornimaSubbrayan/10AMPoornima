package org.testing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		
		String fileName = "C:\\Users\\Thirumurugan S\\eclipse-workspace\\SampleMavenProgram\\target\\ExcelData\\WritingExcel.xlsx";
		File f = new File(fileName);
		boolean a = f.createNewFile();
		System.out.println("File created: "+a);
		
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet("LoginDetails");
		
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(4);
		cell.setCellValue("UserID");
		
		
		
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		
		System.out.println("Success");		
	}
}
