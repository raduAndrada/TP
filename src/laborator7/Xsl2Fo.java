package laborator7;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.FopFactory;
import org.xml.sax.SAXException;

public class Xsl2Fo {

	private static final String STREAM_SOURCE_LOCATION = "src/laborator7/recipe.fo";
	private static final String FOP_CONFIG_FILE_PATH = "src/laborator7/fop.xconf";
	public static void main(String args[]) throws SAXException, IOException {
		final FopFactory ff = FopFactory.newInstance(new File(FOP_CONFIG_FILE_PATH));
		ff.newFOUserAgent();
		new StreamSource(STREAM_SOURCE_LOCATION);
	}
}