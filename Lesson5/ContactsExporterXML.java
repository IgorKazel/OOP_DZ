import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class ContactsExporterXML implements ContactsExporter {
    @Override
    public void exportContacts(List<Contact> contacts, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        OutputStream outputStream = new FileOutputStream(fileName + ".xml");
        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(outputStream);
        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeStartElement("contacts");
        for (Contact contact : contacts) {
            xmlStreamWriter.writeStartElement("contact");
            xmlStreamWriter.writeStartElement("firstName");
            xmlStreamWriter.writeCharacters(contact.getFirstName());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("lastName");
            xmlStreamWriter.writeCharacters(contact.getLastName());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("phoneNumber");
            xmlStreamWriter.writeCharacters(contact.getPhoneNumber());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();
        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.flush();
        xmlStreamWriter.close();
    }
}
