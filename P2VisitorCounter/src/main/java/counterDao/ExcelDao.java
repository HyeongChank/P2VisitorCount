package counterDao;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelDao {

	public String excelDaocreate() {
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("testsheet");
	    XSSFRow titleRow = sheet.createRow(0);
	    XSSFCell titleCell = titleRow.createCell(0);
	    titleCell.setCellValue("cell e");

	    // 파일 경로 설정
	    String filePath = "D:\\김형찬\\P2VisitCounter\\testExcel2.xlsx";

	    try {
	        File xlsFile = new File(filePath);
	        System.out.println("파일 생성");
	        FileOutputStream fileOut = new FileOutputStream(xlsFile);
	        workbook.write(fileOut);

	        // FileOutputStream 닫기
	        fileOut.close();

	        System.out.println("저장 성공");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return null;
	}

}