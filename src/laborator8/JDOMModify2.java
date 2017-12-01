package laborator8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDOMModify2 {
	public static void main(String args[]) throws IOException {
		final File XMLfile = new File("src/laborator8/recipe.xml");
		final SAXBuilder builder = new SAXBuilder();

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

		try {
			final Document jdoc = builder.build(XMLfile);
			final Element root = jdoc.getRootElement();
			final List<Element> elements = root.getChildren();
			for ( int i = 0 ; i < elements.size() ; i++) {
				final Row row = sh.createRow(i);
				final Cell c = row.createCell(0);
				c.setCellStyle(cs1);
				c.setCellValue(elements.get(i).getText().toString());
			}
			elements.forEach(e -> {

				System.out.println(e.toString());});
		} catch (final Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}

		final FileOutputStream fos = new FileOutputStream("src/laborator8/recipe2.xlsx");
		try {

			w.write(fos);
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("finished");
		fos.close();
	}

}
