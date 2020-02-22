package csc241;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {

    private String currentMonth = null;  // Current month value
    private Holiday currentHoliday = null; // Current Holiday object
    private ArrayList<Holiday> holidays = new ArrayList<Holiday>(); // List of Holiday object references


    // This method "fires" whenever a start element is encountered
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("month")){
            // Handle the "month" element
            // store the "name" attribute for use across all method calls
            currentMonth = attributes.getValue("name");
            //System.out.println("CURRENTMONTH:" + currentMonth);
        } else if (qName.equals("holiday")){
            // Handle the "holiday" element
            // Get the attribute values
            int day = Integer.parseInt(attributes.getValue("day")); // Get the value for "day" and convert to an integer
            String name = attributes.getValue("name"); // Get the name of the holiday
            // Instantiate a Holiday using these attributes to use across method calls
            currentHoliday = new Holiday(currentMonth, day, name);
        } else if (qName.equals("federal")){
            // Handle the "federal" element
            // Get its attribute value
            String value = attributes.getValue("value");
            // Examine this value
            if (value.equals("yes")) {
                // This is a federal holiday
                // Set the federal value of the current Holiday
                currentHoliday.setFederal();
            }
        } else if (qName.equals("oswego")){
            // Handle the "oswego" element
            // Get its attribute value
            String value = attributes.getValue("value");
            // Examine this value
            if (value.equals("yes")) {
                // This is an Oswego holiday
                // Set the oswego value of the current Holiday
                currentHoliday.setOswego();
            }
        }
    }

    // This method "fires" whenever a end element is encountered
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("holiday")){
            // Handle "holiday" element. The end element indicates
            // an end to the information about the current holiday.
            // Add the current Holiday to our list and await a new Holiday
            holidays.add(currentHoliday);
        }
    }

    // Return the list of all Holiday object references
    public ArrayList<Holiday> getHolidays(){
        return holidays;
    }
}
