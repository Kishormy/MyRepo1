package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_data {
	public String Get_Data(int r, int c) throws IOException {
		File file = new File("E:\\SELENIUM\\SPRAOI\\AFLAC\\Test_data\\Data_sheet.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("sheet1");
		Cell cell = sheet.getRow(r).getCell(c);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		String data = cell.getStringCellValue();
		return data;
	}

	public void Write_Data(int r, int c, String s) throws IOException {
		File file = new File("E:\\SELENIUM\\SPRAOI\\AFLAC\\Test_data\\Data_sheet.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook WORKBOOK = new XSSFWorkbook(inputStream);
		Sheet sheet = WORKBOOK.getSheetAt(0);
		Row row = sheet.createRow(r);
		Cell cell = row.createCell(c);
		cell.setCellValue(s);
		FileOutputStream fos = new FileOutputStream("E:\\SELENIUM\\SPRAOI\\AFLAC\\Test_data\\Data_sheet.xlsx");
		WORKBOOK.write(fos);
		fos.close();
//		System.out.println("END OF WRITING DATA IN EXCEL");

	}
}
