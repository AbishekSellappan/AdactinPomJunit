package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelReadTask {
	public static void main(String[] args) throws IOException {
		
		// 1.Mention path for file
		File  file=new File ("C:\\Users\\Raj\\Downloads\\workspace\\FirstDay\\Excel Sheets\\WorkSheetTwo.xlsx");
		
		 //2.create workbook
		Workbook workbook= new XSSFWorkbook();
		
		//3. Create the sheet
		Sheet sheet = workbook.createSheet("Data");
		
		//4.Create Row
		Row rowHead = sheet.createRow(0);
		
		//5.Create Cell and Set Value
		Cell cellHead = rowHead.createCell(0);
	
		cellHead.setCellValue("Skill Select");
	
		//object creation
		DemoDD demoSkill = new DemoDD();
		List<WebElement> dropDownValues = demoSkill.getDropDownValues();
		
		for(int i=1;i<dropDownValues.size();i++) {
			
			String attribute = dropDownValues.get(i).getAttribute("value");
			System.out.println(attribute);
			
			//Create Row 
			Row row = sheet.createRow(i);
			
			//Create Cell and Set Value
			Cell cell = row.createCell(0);
			cell.setCellValue(attribute);;
		}
	
		FileOutputStream out =new FileOutputStream(file);
		
		//write/update workbook
		workbook.write(out);
		
	}	
}


