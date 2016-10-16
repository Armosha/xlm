package base;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {

    public static void main(String[] args) {
        MenuParser sax = new MenuParser();
        try {
            sax.getMenuParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println(sax);
    }

}
