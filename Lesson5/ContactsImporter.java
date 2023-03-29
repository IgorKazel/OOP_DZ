import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public interface ContactsImporter {
    List<Contact> importContacts(String fileName) throws XMLStreamException, FileNotFoundException;
}
