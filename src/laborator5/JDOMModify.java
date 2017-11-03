package laborator5;

import java.io.File;
import java.util.List;

import javax.xml.xpath.XPath;

import org.jdom2.Attribute;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class JDOMModify {

	public static void main(String args[]) {
		File XMLfile = new File("src/laborator5/recipeXPath.xml");
		SAXBuilder builder = new SAXBuilder();
		try {
			Document jdoc = builder.build(XMLfile);
			XPathFactory xPathFactory = XPathFactory.instance();
			// rezultatul primului pas
			// coborarea pe elementul root si apoi pe reteta
			String xPathExprString = "/Collection/Recipe";
			XPathExpression<Object> xPathExpression = xPathFactory.compile(xPathExprString);
			List<Object> recipes = xPathExpression.evaluate(jdoc);
			recipes.forEach(e -> {
				
			
				Content content = (Content) e;
				System.out.println(content.getValue());

			});
			xPathExprString = "/Collection/Recipe[position()=2]/Ingredients/Ingredient[last()]/@Name";
		    xPathExpression = xPathFactory.compile(xPathExprString);
			List<Object> scndRecipe = xPathExpression.evaluate(jdoc);
			System.out.println("Cea de-a doua reteta");
			scndRecipe.forEach(e -> {
				Attribute attr = (Attribute) e;
				System.out.println(attr.getValue());

			});
			System.out.println("Cea de-a doua reteta");
			

			
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

}
