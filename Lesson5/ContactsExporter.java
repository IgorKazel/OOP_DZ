import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public interface ContactsExporter {
    void exportContacts(List<Contact> contacts, String fileName) throws FileNotFoundException, XMLStreamException;
}
