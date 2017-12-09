package laborator8;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.JDOMException;

public class JDOMModify {

	public static void main(String[] args) throws JDOMException, IOException, TransformerException {

		final Workbook w = new XSSFWorkbook();
		final Sheet sh = w.createSheet();
		final CellStyle cs1 = w.createCellStyle();
		final CellStyle cs2 = w.createCellStyle();

		final Font f1 = w.createFont();
		final Font f2 = w.createFont();

		f1.setColor(IndexedColors.CORAL.getIndex());
		f1.setFontHeightInPoints((short) 15);
		f1.setBold(true);

		f2.setColor(IndexedColors.CORAL.getIndex());
		f2.setFontHeightInPoints((short) 15);
		f2.setItalic(true);

		cs1.setFont(f1);
		cs2.setFont(f2);

		for (int ri = 0; ri < 10; ri++) {
			final Row row = sh.createRow(ri);
			for (int ci = 0; ci < 10; ci++) {
				final Cell c = row.createCell(ci);
				c.setCellStyle(cs1);
				c.setCellValue((double) ri + ci / 10);
				final Cell c2 = row.createCell(ci + 1);
				c2.setCellStyle(cs2);
				c2.setCellValue("OK");
			}
		}
		final FileOutputStream fos = new FileOutputStream("src/laborator8/recipe.xlsx");
		try {

			w.write(fos);
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("finished");
		fos.close();



	}
}