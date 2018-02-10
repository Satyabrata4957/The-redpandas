package generic_lib;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exel 
{
    String path="./TestData/Imdb.xlsx";
    //sname=sheet name,rownum=rowno,colnum=column no
    
    public String getdata(String sheetname,int rowNum,int colNum) throws Throwable
    {
    	FileInputStream file=new FileInputStream(path);
    	Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;	
    }
    
    
    public void setdata(String sheetname,int rowNum,int colNum,String data) throws Throwable
    {
    	//creating a file by java file class
    	FileInputStream file=new FileInputStream(path);
    	//creating a obj of workbook by workbook interface
    	Workbook wb = WorkbookFactory.create(file);
    	//here we are getting the sheet value bygetsheet methode
		Sheet sh = wb.getSheet(sheetname);
		//here we getting the row no by putting the roenum
		Row row = sh.getRow(rowNum);
		//here we are creating the cell giving the coumNum
		Cell cel=row.createCell(colNum);
		//here we are setting the data into the cell
		cel.setCellValue(data);
		//giving the value to the file or exel sheet
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		wb.close();

    	
    }
	  
	
}
