package laborator8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMModify3 {

	private static final String FILE_NAME = "src/laborator8/tp_lab8.xlsx";

	public static void main(String args[]) throws IOException {
		try {

			final FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			final Workbook workbook = new XSSFWorkbook(excelFile);

			final Element faculty = new Element("faculty");
			final Document doc = new Document(faculty);
			//doc.setRootElement(faculty);

			final Sheet datatypeSheet = workbook.getSheetAt(0);
			final Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				final Row currentRow = iterator.next();
				final Iterator<Cell> cellIterator = currentRow.iterator();

				//currentRow.getLastCellNum();

				cellIterator.next();
				while (cellIterator.hasNext()) {
					final Element student = new Element("student");
					student.setAttribute(new Attribute("id", String.valueOf(currentRow.getRowNum())));
					final Cell currentCell = cellIterator.next();

					if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.print(currentCell.getStringCellValue() + "--");
						if (currentCell.getColumnIndex() == 3) {
							student.setAttribute(new Attribute("firstname",currentCell.getStringCellValue()));
						} else {
							student.setAttribute(new Attribute("lastname",currentCell.getStringCellValue()));
						}

					} else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						System.out.print(currentCell.getNumericCellValue() + "--");
						if (currentCell.getColumnIndex() == 0) {
							student.setAttribute(
									new Attribute("year",String.valueOf(currentCell.getNumericCellValue())));
						} else if (currentCell.getColumnIndex() == 1) {
							student.setAttribute(
									new Attribute("group",String.valueOf(currentCell.getNumericCellValue())));
						} else {
							student.setAttribute(
									new Attribute("subgroup",String.valueOf(currentCell.getNumericCellValue())));
						}
					}

					doc.getRootElement().addContent(student);
				}
				System.out.println();

			}
			// new XMLOutputter().output(doc, System.out);
			final XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("src/laborator8/faculty.xml"));

			System.out.println("File Saved!");

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

}
