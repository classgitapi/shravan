package utilsLayer;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {

	private static XSSFWorkbook workbook;

	public ExcelReader(String path) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(path)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRowCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() + 1;
	}

	public static int getColumnCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}

	public static Object getSpecificSheetValue(int shetindex, int row, int columns) {
		XSSFCell cell = workbook.getSheetAt(shetindex).getRow(row).getCell(columns);

		if (cell == null) {
			return "";
		}

		if (cell != null) {
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}
		}

		return null;
	}

	public  Object[][] getTestData(int sheetindex) {
		int rows = getRowCount(sheetindex);
		int cells = getColumnCount(sheetindex);

		Object[][] data = new Object[rows][cells];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cells; j++) {

				data[i][j] = getSpecificSheetValue(sheetindex, i, j);
			}
		}

		return data;
	}

}

