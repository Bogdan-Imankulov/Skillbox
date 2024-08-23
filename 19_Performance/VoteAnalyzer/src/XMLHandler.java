import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");


    private Voter voter;
    private HashMap<Voter, Integer> voterCount = new HashMap<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter") && voter == null) {
                Date date = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), date);
                StringBuilder builder = new StringBuilder();
                System.out.println(builder.append(qName).append(" started"));
            } else if (qName.equals("visit") && voter != null) {
                int count = voterCount.getOrDefault(voter, 0);
                voterCount.put(voter, ++count);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
            StringBuilder builder = new StringBuilder();
            System.out.println(builder.append(qName).append(" ended"));
        }
    }

    public void printDuplicatedVoters(){
        for (Voter voter : voterCount.keySet()){
            int count = voterCount.get(voter);
            if (count > 1) {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }
}
