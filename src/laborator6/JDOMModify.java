package laborator6;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.JDOMResult;
import org.jdom2.transform.JDOMSource;

public class JDOMModify {

	public static void main(String[] args) throws JDOMException, IOException, TransformerException {
		final TransformerFactory trFact = TransformerFactory.newInstance();
		final StreamSource xslt = new StreamSource(new File("src/laborator6/recipe.xslt"));
		final SAXBuilder sb = new SAXBuilder();
		final Transformer tr = trFact.newTransformer(xslt);
		final Document jdoc = sb.build(new File("src/laborator6/recipe.xml"));
		// pregatirea documentului
		final JDOMSource in = new JDOMSource(jdoc);// 5
		final JDOMResult out = new JDOMResult();// 6
		tr.transform(in, out);
		final List results = out.getResult();
		final XMLOutputter xmlOut = new XMLOutputter();
		xmlOut.output(results, System.out);
	}
}