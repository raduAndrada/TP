package laborator4;
import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class JDOMModify {
	public static void main(String args[]) {
		File XMLfile = new File("src/laborator4/recipeXSD.xml");
		SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
		try {
			Document jdoc = builder.build(XMLfile);
			Element root = jdoc.getRootElement();
			List<Element> elements = root.getChildren();
			elements.forEach(e->System.out.println(e.toString()));
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
