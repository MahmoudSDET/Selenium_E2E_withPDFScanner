package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReaderAndWriter {
	String filepath =System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
	static FileInputStream fis = null;
	static FileOutputStream fos = null;

	public FileInputStream getFileInputStream()
	{

		File srcFile = new File(filepath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {

			System.out.println("Test Data file not found. terminating process!! : check file path of testData");
			System.exit(0);

		}
		return fis;
	}

	public void copydatatofile(String firstname, String lastname, String email, String address, String mobile,
			String password) throws IOException {
		FileInputStream input = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet =wb.getSheetAt(0);
		int lastRow= sheet.getLastRowNum();
		Row row = sheet.createRow(++lastRow);
		row.createCell(0).setCellValue(firstname);
		row.createCell(1).setCellValue(lastname);
		row.createCell(2).setCellValue(email);
		row.createCell(3).setCellValue(address);
		row.createCell(4).setCellValue(mobile);
		row.createCell(5).setCellValue(password);
		FileOutputStream output = new FileOutputStream(filepath);
		wb.write(output);
		wb.close();

	}

	public String [] getloginData() throws IOException 
	{
		FileInputStream input = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet=wb.getSheetAt(0);
		int lastRow= sheet.getLastRowNum();
		Row row = sheet.getRow(lastRow);
		String email= row.getCell(2).toString();
		String password = row.getCell(5).toString();
		String[] data={email, password};
		wb.close();
		return data;
		
	}

}
