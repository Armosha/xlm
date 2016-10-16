package base;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MenuParser {

    String menuFileName;

    public MenuParser() {

    }

    public String getMenuParser() throws ParserConfigurationException, SAXException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new com.sun.java.util.jar.pack.Package.File("/Users/pankaj/employees.xml"), handler);
        }
    }
}
