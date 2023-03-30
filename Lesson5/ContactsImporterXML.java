import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactsImporterXML implements ContactsImporter {
    @Override
    public List<Contact> importContacts(String fileName) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = new FileInputStream(fileName + ".xml");
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        List<Contact> contacts = new ArrayList<>();
        Contact contact = null;
        String elementName = null;
        while (xmlStreamReader.hasNext()) {
            int eventType = xmlStreamReader.next();
            switch (eventType) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = xmlStreamReader.getLocalName();
                    if ("contact".equals(elementName)) {
                        contact = new Contact();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (contact != null) {
                        String data = xmlStreamReader.getText();
                        switch (elementName) {
                            case "firstName":
                                contact.setFirstName(data);
                                break;
                            case "lastName":
                                contact.setLastName(data);
                                break;
                            case "phoneNumber":
                                contact.addPhoneNumber(data);
                                break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = xmlStreamReader.getLocalName();
                    if ("contact".equals(elementName)) {
                        contacts.add(contact);
                        contact = null;
                    }
                    break;
            }
        }
        return contacts;
    }
}
