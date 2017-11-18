package laborator7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.stream.Stream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FormattingResults;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.render.afp.*;

public class XSlFoToPDF {

	private static final String STREAM_SOURCE_LOCATION = "src/laborator7/recipe.fo";
	private static final String PDF_OUTPUT_DESTINATION = "src/laborator7/recipe.pdf";

	public static void main(String args[]) {
		FopFactory ff = FopFactory.newInstance();
		FOUserAgent foUa = ff.newFOUserAgent();
		Source src = new StreamSource(STREAM_SOURCE_LOCATION);
		try {
			OutputStream out = new FileOutputStream(new File(PDF_OUTPUT_DESTINATION));
			Fop fop = ff.newFop(MimeConstants.MIME_PDF, foUa, out);
			TransformerFactory trFact = TransformerFactory.newInstance();

			Transformer tr = trFact.newTransformer();

			Result res = new SAXResult(fop.getDefaultHandler());
			tr.transform(src, res);
			FormattingResults foRes = fop.getResults();
			System.out.print("Generated: - "+ foRes.getPageCount() + " pages");
		} catch (FileNotFoundException | FOPException | TransformerException e) {
			e.printStackTrace();
		}

	}

}
