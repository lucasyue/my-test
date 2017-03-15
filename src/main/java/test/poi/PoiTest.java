package test.poi;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiTest {

	public static void main(String[] args) throws IOException {
		Date date1=new Date();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2=new Date();
		System.out.println(date1.compareTo(date2));
		System.out.println(date2.compareTo(date1));
//		String path="C:/Users/Lucas/Documents/Tencent Files/405263645/FileRecv/销售代码数据 - 副本.xlsx";
//		InputStream is=new FileInputStream(path);
//		Workbook workbook=new XSSFWorkbook(is);
//		Sheet sheet=workbook.getSheetAt(0);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		for(Iterator<Row> it=sheet.rowIterator();it.hasNext();){
//			Row row=it.next();
//			Cell cell=row.getCell(5);
//			int type=cell.getCellType();
//			String value=null;
//			switch(type){
//				case Cell.CELL_TYPE_FORMULA:
//					Date d=cell.getDateCellValue();
//					value = sdf.format(d);
//					break;
//				case Cell.CELL_TYPE_NUMERIC:
//					boolean isDate=HSSFDateUtil.isCellDateFormatted(cell);
//					if(isDate){
//						Date d1=cell.getDateCellValue();
//						value = sdf.format(d1);
//					}else
//						value = String.valueOf(cell.getNumericCellValue());
//					break;
//				case Cell.CELL_TYPE_STRING:
//					value = String.valueOf(cell.getRichStringCellValue());
//					break;
//				case Cell.CELL_TYPE_BLANK:
//					break;
//			}
//			System.out.println(type+": "+value);
//		}
//		workbook.close();
	}

}
