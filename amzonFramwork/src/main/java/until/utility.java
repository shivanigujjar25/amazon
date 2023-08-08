package until;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class utility {
	
	
	
	public static final String FileName="src\\main\\resources\\testdata\\fetch username-password.xlsx";
	public static String FetchData(String sheet, int row, int cloume) {
		String data=null;
		FileInputStream file=null;
		XSSFWorkbook wb=null;	
	    Sheet s=null;
	    Row rows =null;
	    Cell cells =null;
	    
		try {
			file=new FileInputStream(FileName);
			wb =new XSSFWorkbook(file);
			s=wb.getSheet("sheet1");
			rows=s.getRow(row);
			cells=rows.getCell(cloume);
			data=cells.getStringCellValue();
			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				if (data!=null) {
				file.close();
				}
				if(wb!=null) {
					file.close();
				}
				if(file!=null) {
					file.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return data;
	}
	
public static void takescreenshoot(WebDriver d,int testid ) throws IOException {
	
	SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	Date date=new Date();
	String datetime =df.format(date);
	
	//create a filename 
	String Screenshot=datetime+"  "+testid;
						
	TakesScreenshot ts=(TakesScreenshot)d;
	File socur=ts.getScreenshotAs(OutputType.FILE);
	
	File Dest=new File("C:\\Users\\hp\\eclipse-workspace\\amzonFramwork\\test-output\\screenshot\\"+Screenshot+"testid.png");
	FileHandler.copy(socur, Dest);
}

}
