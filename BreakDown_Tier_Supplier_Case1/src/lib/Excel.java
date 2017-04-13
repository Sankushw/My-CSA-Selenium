package lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static int getRowCount(String xlpath, String sheet) {
		int rc = 1;
		try {
			System.out.println(sheet + "" + xlpath);

			FileInputStream fis = new FileInputStream(xlpath);

			Workbook wb = WorkbookFactory.create(fis);

			rc = wb.getSheet(sheet).getLastRowNum();

		} catch (Exception e) {

		}
		return rc;
	}

	public static String getCellValue(String xlpath, String sheet, int row, int cell) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb = WorkbookFactory.create(fis);

			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception e) {

		}
		return value;
	}
}
