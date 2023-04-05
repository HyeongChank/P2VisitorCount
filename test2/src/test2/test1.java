package test2;

public class test1 {

}
package test2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDao {

	public void excelDaocreate() {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("testsheet");
		Row titleRow = sheet.createRow(0);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("cell value");
	
		
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0,path.length()-1) + "temp.xlsx";
		
		  try {
	            File xlsFile = new File("D:\\김형찬\\P2VisitCounter\\testExcel.xls");
	            FileOutputStream fileOut = new FileOutputStream(xlsFile);
	            workbook.write(fileOut);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
}