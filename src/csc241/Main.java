package csc241;

import javax.xml.parsers.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Instantiate a parser factory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            // Instantiate a parser using the factory
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // Instantiate a handler
            MyHandler handler = new MyHandler();
            // Instantiate our input file using its file name
            File input = new File("holidays.xml");
            // Launch the XML parser on the input file
            saxParser.parse(input, handler);

            // Display the Holiday objects created
            



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
