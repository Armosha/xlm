package base;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {

    private Dish position;
    private StringBuilder s;
    private List<Dish> dishList = new ArrayList<Dish>();
    MenuTagName tagName;

    public List<Dish> getDishlist() {
        return dishList;
    }

    public MenuSaxHandler() {
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        s = new StringBuilder();
        if (qName.equals("dish")) {
            position = new Dish();
        }
        if (qName.equals("option")) {
            position.setOption(attributes.getValue("name"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case TYPE:
                position.setType(s.toString());
                break;
            case PHOTO:
                position.setPhoto(s.toString());
                break;
            case NAME:
                position.setName(s.toString());
                break;
            case DESCRIPTION:
                position.setDescription(s.toString());
                break;
            case PORTION:
                position.setPortion(s.toString());
                break;
            case PRICE:
                position.setPrice(Double.parseDouble(s.toString()));
                break;
            case DISH:
                dishList.add(position);
                position = null;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        s.append(ch, start, length);
    }
}


