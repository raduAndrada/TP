package laborator7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FormattingResults;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

public class XSlFoToPDF {

	private static final String STREAM_SOURCE_LOCATION = "src/laborator7/recipe.fo";
	private static final String PDF_OUTPUT_DESTINATION = "src/laborator7/recipe.pdf";


	private static final String FOP_CONFIG_FILE_PATH = "src/laborator7/fop.xconf";


	public static void main(String args[]) throws SAXException, IOException {
		final FopFactory ff = FopFactory.newInstance(new File(FOP_CONFIG_FILE_PATH));
		final FOUserAgent foUa = ff.newFOUserAgent();
		final Source src = new StreamSource(STREAM_SOURCE_LOCATION);
		try {
			final OutputStream out = new FileOutputStream(new File(PDF_OUTPUT_DESTINATION));
			final Fop fop = ff.newFop(MimeConstants.MIME_PDF, foUa, out);
			final TransformerFactory trFact = TransformerFactory.newInstance();

			final Transformer tr = trFact.newTransformer();

			final Result res = new SAXResult(fop.getDefaultHandler());
			tr.transform(src, res);
			final FormattingResults foRes = fop.getResults();
			System.out.print("Generated: - " + foRes.getPageCount() + " pages");
		} catch (FileNotFoundException | FOPException | TransformerException e) {
			e.printStackTrace();
		}

	}

}
