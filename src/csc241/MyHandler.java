package csc241;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class MyHandler extends DefaultHandler {

    private String currentMonth = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Handle the "month" element
        if (qName.equals("month")){
            // store the "name" attribute for use across all method calls
            currentMonth = attributes.getValue("name");
            System.out.println("CURRENTMONTH:" + currentMonth);
        }
    }

}
